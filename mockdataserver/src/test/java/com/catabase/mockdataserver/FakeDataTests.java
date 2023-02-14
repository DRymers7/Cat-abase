package com.catabase.mockdataserver;

import com.catabase.mockdataserver.factory.FakeDataService;
import org.junit.Before;
import org.junit.Test;

public class FakeDataTests {

    private FakeDataService fakeDataService;

    @Before
    public void setup() {
        fakeDataService = new FakeDataService();
    }

    @Test
    public void test_for_email_gen() {

    }
}
