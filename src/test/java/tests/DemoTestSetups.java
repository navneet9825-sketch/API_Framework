package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.api.LoginApi;

import java.io.IOException;
import java.util.HashMap;

import static groovy.xml.Entity.not;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static utils.FileUtility.read;

public class DemoTestSetups
{
    LoginApi loginApi;

//    RequestSpecification requestSpecification;
//    ResponseSpecification responseSpecification;
//

//
//    @BeforeClass
//    public void setup()
//    {
//        requestSpecification = new  RequestSpecBuilder()
//                .setBaseUri("https://api.practicesoftwaretesting.com")
//                .setBasePath("/")
//                .setContentType(ContentType.JSON)
//                .log(LogDetail.ALL)
//                .build();
//
//        responseSpecification = new ResponseSpecBuilder()
//                .expectContentType(ContentType.JSON)
//                .expectResponseTime(lessThan(5000L))
//                .expectStatusCode(200)
//                .log(LogDetail.ALL)
//                .build();
//
//    }

    @Test
    public void getAllProducts()
    {
//       /*
//       given() -> Pre-requiste/setup -> Arrange
//       when() -> Action -> Act
//       then() -> result of action -> Assertions -> Assert
//        */
//
//        HashMap<String,String> queryMap  =new HashMap<>();
//        queryMap.put("is_rental","false");
//        queryMap.put("between","price,1,100");
//        queryMap.put("page","1");
//
//        given()
//               //  .baseUri("https://api.practicesoftwaretesting.com/")
//                .spec(requestSpecification)
//                .queryParams(queryMap)
//               // .basePath("products")
//               // .log().all()
//                .when()
//                .get("products")
//              //  .get("?is_rental=false&between=price%2C1008&page=1")   (USed hashmap to make it more readable)
//                .then()
//                .spec(responseSpecification)
//               // .log().all()
//               // .statusCode(200)
//                  .body("data[0].name",equalTo("Combination Pliers"))
//                  .body("data[1].name",equalTo("Pliers"))
//                  .body("data.name",everyItem(notNullValue()));
    }

    @Test
    public void loginWithValidUserCredentialsTest() throws IOException {
//        HashMap<String,String> validUserCredentials  =new HashMap<>();
//        validUserCredentials.put("email","admin@practicesoftwaretesting.com");
//        validUserCredentials.put("password","welcome01");
//
//       Response response =  given()
//            // .baseUri("https://api.practicesoftwaretesting.com")
//            //    .basePath("/")
//               .spec(requestSpecification)
//                .body(validUserCredentials)
//             //   .contentType(ContentType.JSON)
//            //    .log().all()
//                .when()
//                .post("users/login")
//                .then()
//               .spec(responseSpecification)
//               // .log().all()
//               // .statusCode(200)
//                .body("access_token",notNullValue())
//                .body("token_type",equalTo("bearer"))
//               .extract().response();
//
//       JsonPath jsonPath = response.jsonPath();
//       String access_token = jsonPath.getString("access_token");
//       System.out.println("Access Token Retrieved: " + access_token);
        loginApi = new LoginApi();
        loginApi.loginWithUserAndRetrieveAccessToken(read("global_user_email"),
                read("global_user_password"))
                .then()
                .body("token_type",equalTo("bearer"))
                .body("access_token",notNullValue());




    }
}
