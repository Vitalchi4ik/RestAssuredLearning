package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class NasaConfig {
    public static RequestSpecification nasRequestSpec;
    public static ResponseSpecification nasaResponseSpec;

    @BeforeClass
    public static void setUp() {

        nasRequestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.nasa.gov")
                .setBasePath("/mars-photos/api/v1/")
                .addQueryParam("sol", 1666)
                .addQueryParam("api_key", "prQCyiOaYJ1n7fd8hvUAqEfAdolPySqlNWSX895r")
                .addQueryParam("name", "Curiosity")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        nasaResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                .build();

        RestAssured.requestSpecification = nasRequestSpec;
        RestAssured.responseSpecification = nasaResponseSpec;
    }
}
