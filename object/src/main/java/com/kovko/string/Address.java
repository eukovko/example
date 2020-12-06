package com.kovko.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

    private String country;
    private String city;
    private String street;
    private String apartment;
    private String zip;

    public Address(String country, String city, String street, String apartment, String zip) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.apartment = apartment;
        this.zip = zip;
    }

    private Address(String address) {

    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return String which is the address in [Country],[City]:[Street]-[Apartments],[Zip] format
     */
    @Override
    public String toString() {
        return String.format("%s,%s:%s-%s,%s", country, city, street, apartment, zip);
    }

    public static Address parseAddress(String address){
        Address result = new Address();

        Pattern pattern = Pattern.compile("(\\w+),(\\w+):(\\w+)-(\\w+),(\\w+)");
        Matcher matcher = pattern.matcher(address);
        boolean matches = matcher.matches();
        assert matches;
        String country = matcher.group(1);
        String city = matcher.group(2);
        String street = matcher.group(3);
        String apartment = matcher.group(4);
        String zip = matcher.group(5);

        result.setCountry(country);
        result.setCity(city);
        result.setStreet(street);
        result.setApartment(apartment);
        result.setZip(zip);

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (apartment != null ? !apartment.equals(address.apartment) : address.apartment != null) return false;
        return zip != null ? zip.equals(address.zip) : address.zip == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        return result;
    }
}
