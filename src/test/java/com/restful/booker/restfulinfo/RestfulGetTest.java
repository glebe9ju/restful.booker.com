package com.restful.booker.restfulinfo;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestfulGetTest extends TestBase {
    @Test
    public void getAllIDInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleIDInfo() {

        Response response = given()
                .pathParam("id", 1687)
                .when()
                .get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}