package com.kovko.string.address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressParser {

    public static Address parseAddress(String string) {

        Pattern pattern = Pattern.compile("(\\w+),(\\w+):(\\w+)-(\\w+),(\\w+)");
        Matcher matcher = pattern.matcher(string);
        boolean matches = matcher.matches();
        assert matches;
        String country = matcher.group(1);
        String city = matcher.group(2);
        String street = matcher.group(3);
        String apartment = matcher.group(4);
        String zip = matcher.group(5);

        return new Address(country, city, street, apartment, zip);
    }

    public static Address parseAddress(String string, Address address) {

        Pattern pattern = Pattern.compile("(\\w+),(\\w+):(\\w+)-(\\w+),(\\w+)");
        Matcher matcher = pattern.matcher(string);
        boolean matches = matcher.matches();
        assert matches;
        String country = matcher.group(1);
        String city = matcher.group(2);
        String street = matcher.group(3);
        String apartment = matcher.group(4);
        String zip = matcher.group(5);

        address.setCountry(country);
        address.setCity(city);
        address.setStreet(street);
        address.setApartment(apartment);
        address.setZip(zip);
        return address;
    }
}
