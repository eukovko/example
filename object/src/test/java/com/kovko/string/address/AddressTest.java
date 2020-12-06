package com.kovko.string.address;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    @Test
    void testParseAddress() {

        Address expected = new Address("Country", "City", "Street", "Apartment", "Zip");
        Address actual = AddressParser.parseAddress("Country,City:Street-Apartment,Zip");

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testParseConstructor() {

        Address expected = new Address("Country", "City", "Street", "Apartment", "Zip");
        Address actual = new Address("Country,City:Street-Apartment,Zip");

        assertThat(actual).isEqualTo(expected);

    }
}