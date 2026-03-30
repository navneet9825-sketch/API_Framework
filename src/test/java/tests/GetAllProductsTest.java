package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.products.ProductRoot;
import tests.api.RetrieveProductsApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class GetAllProductsTest {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.practicesoftwaretesting.com")
                .setBasePath("/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5000L))
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();

    }

    RetrieveProductsApi getProducts;
    @Test
    @Description("Retrieve all the products and deserialize")
    public void deserializeGetProductsResponseTest()
    {
//        HashMap<String,String> queryMap  =new HashMap<>();
//        queryMap.put("is_rental","false");
//        queryMap.put("between","price,1,100");
//        queryMap.put("page","1");
//
//        ProductRoot root = given()
//                //  .baseUri("https://api.practicesoftwaretesting.com/")
//                .spec(requestSpecification)
//                .queryParams(queryMap)
//                // .basePath("products")
//                // .log().all()
//                .when()
//                .get("products")
//                //  .get("?is_rental=false&between=price%2C1008&page=1")   (USed hashmap to make it more readable)
//                .then()
//                .spec(responseSpecification)
//                // .log().all()
//                // .statusCode(200)
//                .body("data[0].name",equalTo("Combination Pliers"))
//                .body("data[1].name",equalTo("Pliers"))
//                .body("data.name",everyItem(notNullValue()))
//                .extract()
//                .as(ProductRoot.class);

        getProducts = new RetrieveProductsApi();
        Response response = getProducts.getProudyctsWithPriceLessThan100();
        ProductRoot root = response.then()
                .body("data[0].name",equalTo("Combination Pliers"))
                .body("data[1].name",equalTo("Pliers"))
                .body("data.name",everyItem(notNullValue())).extract().as(ProductRoot.class);


    }

}
