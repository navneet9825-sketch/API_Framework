package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.FileUtility.read;
import static utils.FileUtility.write;

public class CardValidationTests {
    @Test
    public void validateCartFlow() throws IOException {
        Response response = given()
                .spec(requestSpecBuilder())
                .headers("Authorization", read("auth_token"))
                .when()
                .post("carts")
                .then()
                .spec(responseSpecBuilder())
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        write("cart_id", jsonPath.getString("id"));

        given().spec(requestSpecBuilder())
                .contentType(ContentType.JSON)
                .headers("Authorization", read("auth_token"))
                .body("""
                        {
                        "product_id":"01KFJNS7PF3HR9FM5T2CK1D5Q6"
                        "quantity":1
                        }
                        """)
                .when().post("carts/" + read("cart_id"))
                .then()
                .spec(responseSpecBuilder());
    }
}
