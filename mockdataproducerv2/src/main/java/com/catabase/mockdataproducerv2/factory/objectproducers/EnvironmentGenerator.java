package com.catabase.mockdataproducerv2.factory.objectproducers;


import com.catabase.mockdataproducerv2.factory.objectdao.EnvironmentGeneratorDao;
import com.catabase.mockdataproducerv2.model.pojos.objects.Environment;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Component
public class EnvironmentGenerator implements EnvironmentGeneratorDao {

    private SecureRandom random = new SecureRandom();

    public EnvironmentGenerator() {}

    @Override
    public Environment generateEnvironment(String petType) {
        return handleEnvironmentGeneration(petType);
    }

    private Environment handleEnvironmentGeneration(String petType) {
        Environment environment = new Environment();
        environment.setChildren(genIsGoodWithChildren());
        environment.setDogs(genIsGoodWithDogs(petType));
        environment.setCats(genIsGoodWithCats(petType));
        return environment;
    }

    private boolean genIsGoodWithChildren() {
        int likelihood = random.nextInt(0, 10);
        return likelihood > 3;
    }

    private boolean genIsGoodWithDogs(String petType) {
        int likelihood = random.nextInt(0, 10);
        if (petType.equalsIgnoreCase("dog")) {
            return likelihood > 2;
        } else if (petType.equalsIgnoreCase("cat")) {
            return likelihood > 7;
        } else {
            return likelihood > 5;
        }
    }

    private boolean genIsGoodWithCats(String petType) {
        int likelihood = random.nextInt(0, 10);
        if (petType.equalsIgnoreCase("dog")) {
            return likelihood > 7;
        } else if (petType.equalsIgnoreCase("cat")) {
            return likelihood > 2;
        } else {
            return likelihood > 5;
        }
    }

}
