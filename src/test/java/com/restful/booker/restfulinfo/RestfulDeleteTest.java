package com.restful.booker.restfulinfo;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class









RestfulDeleteTest extends TestBase {

    @Test
    public void deleteAllBookingInfo() {
        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token = 23c00dfb2634f8e")
                .basePath("/booking")
                .pathParam("id", 2216)
                .when()
                .delete("/{id}");
        response.prettyPrint();
        response.then().statusCode(201);
    }

}
