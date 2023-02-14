package com.catabase.mockdataserver.factory;

import com.catabase.mockdataserver.model.objects.Address;
import com.catabase.mockdataserver.model.objects.Contact;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@NoArgsConstructor
public class FakeDataService {

    private final FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());

    private final Faker usFaker =
            new Faker(new Locale("en-US"));

    public Contact generateContact() {
        Contact contact = new Contact();
        contact.setEmail(createNewEmail());
        contact.setPhone(generatePhoneNumber());
        contact.setAddress(generateAddress());
        return contact;
    }

    private String createNewEmail() {
        return fakeValuesService.bothify("????##@gmail.com");
    }

    private String generatePhoneNumber() {
        return String.valueOf(usFaker.phoneNumber());
    }

    private Address generateAddress() {
        Address address = new Address();
        address.setAddress1(usFaker.address().streetAddress());
        address.setCity(usFaker.address().city());
        address.setState(usFaker.address().state());
        address.setPostcode(usFaker.address().zipCode());
        address.setCountry(usFaker.address().country());
        return address;
    }

}
