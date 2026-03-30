package utils;

import com.github.javafaker.Faker;
import pojo.registration.Address;
import pojo.registration.RegistrationRoot;

import static utils.PojoManager.address;
import static utils.PojoManager.addressGeneration;

public class DataGenerator
{
    private static final ThreadLocal<Faker> fakerThreadLocal = ThreadLocal.withInitial(Faker::new);

    public static RegistrationRoot generateDataForUserRegistration()
    {
        Faker faker = fakerThreadLocal.get();

      return new RegistrationRoot(faker.name().firstName(),faker.name().lastName(),
               generateDataForAddress(),faker.phoneNumber().cellPhone(),"1990-01-01","WorldNavneet01@",
               faker.internet().emailAddress());
    }

    private static Address generateDataForAddress()
{
        Faker faker = fakerThreadLocal.get();
        return addressGeneration(faker.address().streetAddress(),faker.address().city(),
                faker.address().state(),faker.address().country(),faker.address().zipCode());
}
}
