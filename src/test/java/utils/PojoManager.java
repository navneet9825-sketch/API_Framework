package utils;

import com.github.javafaker.Faker;
import pojo.registration.Address;

public class PojoManager
{
    static Address address;
    static Faker faker;

    public static Address  addressGeneration(String streetAddress,String city,String state,
                                  String country,String zipCode)
    {
        address = new Address();
        faker = new Faker();

       return  address.setStreet(streetAddress)
                .setCity(city)
                .setState(state)
                .setCountry(country)
                .setPostal_code(zipCode);
    }
}
