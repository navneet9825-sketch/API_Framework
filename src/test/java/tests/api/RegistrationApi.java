package tests.api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import pojo.registration.Address;
import pojo.registration.RegistrationRoot;

import static io.restassured.RestAssured.*;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.PojoManager.addressGeneration;

public class RegistrationApi
{
//    RegistrationRoot user;
//    Address address;
//    Faker faker;

    public Response registerValidUser(RegistrationRoot user)
    {
//        user = new RegistrationRoot();
//        address = new Address();
 //       faker = new Faker();

//       Address address = addressGeneration(faker.address().streetAddress(),faker.address().city(),faker.address().state(),
//                faker.address().country(),faker.address().zipCode());

//        address.setStreet(faker.address().streetAddress())
//                .setCity(faker.address().city())
//                .setState(faker.address().state())
//                .setCountry(faker.address().country())
//                .setPostal_code(faker.address().zipCode());

//      RegistrationRoot  user = new RegistrationRoot(faker.name().firstName(),faker.name().lastName(),
//                address,faker.phoneNumber().cellPhone(),"1990-01-01","WorldNavneet01@",
//                faker.internet().emailAddress());

        return  given()
                .spec(requestSpecBuilder())
                .body(user)
                .when()
                .post("users/register")
                .then()
                .spec(responseSpecBuilder())
//                .body("first_name",equalTo(user.getFirst_name()))
//                .body("address.street",equalTo(address.getStreet()));
                .statusCode(201)
                .extract()
                .response();
    }
}
