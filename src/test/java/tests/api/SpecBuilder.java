package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class SpecBuilder
{

    public static RequestSpecification requestSpecBuilder()
    {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.practicesoftwaretesting.com")
                .setBasePath("/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();


    }

    public static ResponseSpecification responseSpecBuilder()
    {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(9000L))
                .log(LogDetail.ALL)
                .build();
    }
}
