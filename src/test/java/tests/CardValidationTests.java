package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tests.api.CartApi;
import tests.api.LoginApi;
import tests.api.RetrieveProductsApi;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static tests.api.SpecBuilder.requestSpecBuilder;
import static tests.api.SpecBuilder.responseSpecBuilder;
import static utils.FileUtility.read;
import static utils.FileUtility.write;

public class CardValidationTests {

    CartApi cartApi;
    RetrieveProductsApi getProductID;
    LoginApi loginApi;


    @Test
    public void validateCartFlow() throws IOException
    {
//        Response response = given()
//                .spec(requestSpecBuilder())
//                .headers("Authorization", read("auth_token"))
//                .when()
//                .post("carts")
//                .then()
//                .spec(responseSpecBuilder())
//                .extract()
//                .response();
//
//        JsonPath jsonPath = response.jsonPath();
//        write("cart_id", jsonPath.getString("id"));
//
//        given().spec(requestSpecBuilder())
//                .contentType(ContentType.JSON)
//                .headers("Authorization", read("auth_token"))
//                .body("""
//                        {
//                        "product_id":"01KFJNS7PF3HR9FM5T2CK1D5Q6"
//                        "quantity":1
//                        }
//                        """)
//                .when().post("carts/" + read("cart_id"))
//                .then()
//                .spec(responseSpecBuilder());

        cartApi = new CartApi();
        getProductID = new RetrieveProductsApi();
        loginApi = new LoginApi();

        getProductID.getProudyctsWithPriceLessThan100();
        loginApi.loginWithUserAndRetrieveAccessToken(read("global_user_email"),
                read("global_user_password"));
        cartApi.retrieveCartID();
        cartApi.addItemToCart("product_id","1")
                .then().body("result",equalTo
                        ("item added or updated"));


    }
}
