package com.restful.booker.restfulinfo;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestfulPatchTest extends TestBase {
    @Test
    public void updateProductWithPatch(){
        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Beatric");
        bookingPojo.setLastname("Barratt");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token =" + token)
                .basePath("/booking")
                .pathParam("id", 2216)
                .body(bookingPojo)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
