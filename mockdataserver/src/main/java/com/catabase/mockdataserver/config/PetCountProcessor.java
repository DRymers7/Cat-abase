package com.catabase.mockdataserver.config;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PetCountProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    // this is for consumer - not needed for strictly producing data
    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> messageStream = streamsBuilder.stream(
                "cat-topic", Consumed.with(STRING_SERDE, STRING_SERDE)
        );

        KTable<String, Long> wordCounts = messageStream
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
                .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
                .count(Materialized.as("counts"));

        wordCounts.toStream().to("output-topic");
    }
}
