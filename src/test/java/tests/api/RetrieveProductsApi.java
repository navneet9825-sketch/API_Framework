package tests.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.FileUtility.write;

public class RetrieveProductsApi {
    public Response getProudyctsWithPriceLessThan100() {
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("is_rental", "false");
        queryMap.put("between", "price,1,100");
        queryMap.put("page", "1");

        Response response  = given()
                //  .baseUri("https://api.practicesoftwaretesting.com/")
                .spec(requestSpecBuilder())
                .queryParams(queryMap)
                // .basePath("products")
                // .log().all()
                .when()
                .get("products")
                //  .get("?is_rental=false&between=price%2C1008&page=1")   (USed hashmap to make it more readable)
                .then()
                .spec(responseSpecBuilder())
                // .log().all()
                // .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        String id = jsonPath.getString("data[0].id");
        try {
            write("product_id",id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;

    }
}

