package tests;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.registration.Address;
import pojo.registration.RegistrationRoot;
import tests.api.RegistrationApi;
import utils.DataGenerator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.DataGenerator.generateDataForUserRegistration;
import static utils.PojoManager.addressGeneration;

public class RgisterNewUserTest
{
//    RequestSpecification requestSpecification;
//    ResponseSpecification responseSpecification;
//    RegistrationRoot user;
//    Address address;
    RegistrationApi registrationApi;
 //   Faker faker;

    @BeforeClass
    public void setup()
    {
//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri("https://api.practicesoftwaretesting.com")
//                .setBasePath("/")
//                .setContentType(ContentType.JSON)
//                .log(LogDetail.ALL)
//                .build();
//
//        responseSpecification = new ResponseSpecBuilder()
//                .expectContentType(ContentType.JSON)
//                .expectResponseTime(lessThan(5000L))
//                .expectStatusCode(201)
//                .log(LogDetail.ALL)
//                .build();

//        requestSpecification = requestSpecBuilder();
//        responseSpecification = responseSpecBuilder();
//        user = new RegistrationRoot();
//        address = new Address();
        registrationApi = new RegistrationApi();
      //  faker = new Faker();

    }

    @Test
    public void registerValidUser()
    {
//        String rqstPayload = """
//                {
//                  "first_name": "John",
//                  "last_name": "Doe",
//                  "address": {
//                    "street": "Street 1",
//                    "city": "City",
//                    "state": "State",
//                    "country": "Country",
//                    "postal_code": "1234AA"
//                  },
//                  "phone": "0987654321",
//                  "dob": "1970-01-01",
//                  "password": "SuperSecure@123",
//                  "email": "john@doe5.example"
//                }
//                """;

       // user = new RegistrationRoot();

     //   address = new Address();

     //   address = addressGeneration(faker.address().streetAddress(),faker.address().city(),faker.address().state(),
     //           faker.address().country(),faker.address().zipCode());

//        address.setStreet(faker.address().streetAddress());
//        address.setCity(faker.address().city());
//        address.setState(faker.address().state());
//        address.setCountry(faker.address().country());
//        address.setPostal_code(faker.address().zipCode());

        //Builder Pattern
        //Fluent Interface
        //We are reusing the object refrence
        //Tight Coupling
//        address.setStreet(faker.address().streetAddress())
//                .setCity(faker.address().city())
//                .setState(faker.address().state())
//                .setCountry(faker.address().country())
//                .setPostal_code(faker.address().zipCode());
//
//        user = new RegistrationRoot(faker.name().firstName(),faker.name().lastName(),
//                address,faker.phoneNumber().cellPhone(),"1990-01-01","WorldNavneet01@",
//                faker.internet().emailAddress());

//        user.setFirst_name(faker.name().firstName());
//        user.setLast_name(faker.name().lastName());
//        user.setAddress(address);
//        user.setPhone(faker.phoneNumber().cellPhone());
//        user.setDob("1990-01-01");
//        user.setPassword("WorldNavneet01@");
//        user.setEmail(faker.internet().emailAddress());

//       RegistrationRoot responsePayload =  given()
//                .spec(requestSpecification)
//                .body(user)
//                .when()
//                .post("users/register")
//                .then()
//                .spec(responseSpecification)
////                .body("first_name",equalTo(user.getFirst_name()))
////                .body("address.street",equalTo(address.getStreet()));
//                .statusCode(201)
//                .extract()
//                .as(RegistrationRoot.class);
     RegistrationRoot requestPayload  = DataGenerator.generateDataForUserRegistration();
     RegistrationRoot responsePayload = registrationApi.registerValidUser(requestPayload)
                     .then().extract().as(RegistrationRoot.class);

     //System.out.println("Printed throughout statement: " + response.asPrettyString());

       assertThat(requestPayload.getFirst_name(),equalTo(responsePayload.getFirst_name()));

        System.out.println(requestPayload.getFirst_name()+" " + responsePayload.getFirst_name());

   }
}
