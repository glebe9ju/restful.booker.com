package com.restful.booker.restfulinfo;

import com.restful.booker.model.RestfulPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfulPostTest extends TestBase {
    @Test
    public void createBookingTest() {

       // creating map variable which is key and value
        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        RestfulPojo bookingPojo = new RestfulPojo();
        bookingPojo.setFirstname("Beatric");
        bookingPojo.setLastname("Potter");
        bookingPojo.setTotalprice(120);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("Veggie Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}


