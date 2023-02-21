package com.catabase.mockdataproducerv2.factory.objectproducers;

import com.catabase.mockdataproducerv2.factory.objectdao.ContactGeneratorDao;
import com.catabase.mockdataproducerv2.model.pojos.objects.Address;
import com.catabase.mockdataproducerv2.model.pojos.objects.Contact;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Scope("singleton")
public class ContactGenerator implements ContactGeneratorDao {

    private final FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());

    private final Faker usFaker =
            new Faker(new Locale("en-US"));

    public ContactGenerator() {}

    @Override
    public Contact generateContact() {
        return handleGenerationDetails();
    }

    private Contact handleGenerationDetails() {
        Contact contact = new Contact();
        contact.setEmail(createNewEmail());
        contact.setPhone(generatePhoneNumber());
        contact.setAddress(generateAddress());
        return contact;
    }

    private String createNewEmail() {
        String firstName = usFaker.name().firstName();
        String lastName = usFaker.name().lastName();
        return fakeValuesService.bothify(firstName + "." + lastName + "##@gmail.com");
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
