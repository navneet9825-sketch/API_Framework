package tests.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.FileUtility.read;
import static utils.FileUtility.write;

public class CartApi
{
    public void retrieveCartID() throws IOException {
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
    }

    public Response addItemToCart(String productID,String quantity) throws IOException
    {
        HashMap<String,String> requestMap = new HashMap<>();
        requestMap.put("product_id",productID);
        requestMap.put("quantity",quantity);

       return  given().spec(requestSpecBuilder())
                .contentType(ContentType.JSON)
                .headers("Authorization", read("auth_token"))
                .body(requestMap)
                .when().post("carts/" + read("cart_id"))
                .then()
                .spec(responseSpecBuilder())
               .extract()
                .response();
    }

}
