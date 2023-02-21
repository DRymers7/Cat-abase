package com.catabase.mockdataproducerv2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class RandomNumTests {

    private SecureRandom random;

    @Before
    public void setup() {
        random = new SecureRandom();
    }

    @Test
    public void randomNeverGoesAbove1OrBelow0() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(0, 2));
        }
        boolean noOutOfBoundsValues = true;
        for (Integer integer : list) {
            if (integer > 1 || integer < 0) {
                noOutOfBoundsValues = false;
                fail("Number exceeded target range");
            }
        }
        Assert.assertTrue(noOutOfBoundsValues);

    }
}
