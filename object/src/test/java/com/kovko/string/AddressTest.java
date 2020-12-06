package com.kovko.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class AddressTest {

    Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
    }

    @Test
    void testParseAddress() {

        Address expected = new Address("Country", "City", "Street", "Apartment", "Zip");
        Address actual = Address.parseAddress("Country,City:Street-Apartment,Zip");

        assertThat(actual).isEqualTo(expected);

    }
}