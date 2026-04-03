package tests.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.FileUtility.write;

public class LoginApi
{
   public Response  loginWithUserAndRetrieveAccessToken(String email , String password) throws IOException {
       HashMap<String,String> validUserCredentials  =new HashMap<>();
       validUserCredentials.put("email",email);
       validUserCredentials.put("password",password);

       Response response =  given()
               // .baseUri("https://api.practicesoftwaretesting.com")
               //    .basePath("/")
               .spec(requestSpecBuilder())
               .body(validUserCredentials)
               //   .contentType(ContentType.JSON)
               //    .log().all()
               .when()
               .post("users/login")
               .then()
               .spec(responseSpecBuilder())
               // .log().all()
               // .statusCode(200)
               .body("access_token",notNullValue())
               .body("token_type",equalTo("bearer"))
               .extract().response();

       JsonPath jsonPath = response.jsonPath();
       String access_token = jsonPath.getString("access_token");
       write("auth_token",access_token);
       return response;

   }
}
