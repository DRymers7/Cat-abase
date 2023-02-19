package com.catabase.mockdataserver.factoryimplementation.objectfactoryimplementation;

import com.catabase.mockdataserver.factoryimplementation.objectdao.AttributesGeneratorDao;
import com.catabase.mockdataserver.model.objects.Attributes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@Scope("singleton")
public class AttributesGenerator implements AttributesGeneratorDao {

    private final SecureRandom random = new SecureRandom();

    public AttributesGenerator() {}

    @Override
    public Attributes generateAttributes() {
        return handleAttributeGeneration();
    }

    private Attributes handleAttributeGeneration() {
        Attributes attributes = new Attributes();
        attributes.setSpayedNeutered(SpayedNeutered());
        attributes.setHouseTrained(houseTrained());
        attributes.setDeclawed(declawed());
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

    private boolean declawed() {
        int likelihood = random.nextInt(0, 10);
        return likelihood > 5;
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
