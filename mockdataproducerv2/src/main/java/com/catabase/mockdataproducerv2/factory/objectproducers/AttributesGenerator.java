package com.catabase.mockdataproducerv2.factory.objectproducers;


import com.catabase.mockdataproducerv2.factory.objectdao.AttributesGeneratorDao;
import com.catabase.mockdataproducerv2.model.pojos.objects.Attributes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Component
public class AttributesGenerator implements AttributesGeneratorDao {

    private final SecureRandom random = new SecureRandom();

    public AttributesGenerator() {}

    @Override
    public Attributes generateAttributes(String petType) {
        return handleAttributeGeneration(petType);
    }

    private Attributes handleAttributeGeneration(String petType) {
        Attributes attributes = new Attributes();
        attributes.setSpayedNeutered(SpayedNeutered());
        attributes.setHouseTrained(houseTrained());
        attributes.setDeclawed(declawed(petType));
        attributes.setSpecialNeeds(specialNeeds());
        attributes.setShotsCurrent(shotsCurrent());
        return attributes;
    }

    private boolean SpayedNeutered() {
        int likelihood = random.nextInt(0, 10);
        return likelihood > 2;
    }

    private boolean houseTrained() {
        int likelihood = random.nextInt(0, 10);
        return likelihood > 3;
    }

    private boolean declawed(String petType) {
        if (petType.equalsIgnoreCase("cat")) {
            int likelihood = random.nextInt(0, 10);
            return likelihood > 5;
        } else {
            return false;
        }
    }

    private boolean specialNeeds() {
        int likelihood = random.nextInt(0, 10);
        return likelihood > 1;
    }

    private boolean shotsCurrent() {
        int likelihood = random.nextInt(0, 10);
        return likelihood > 2;
    }

}
