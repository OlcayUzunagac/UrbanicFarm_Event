package stepDefinitions;

import com.github.javafaker.Faker;
import enums.URBANICFARM_CREDENTIALS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.*;
import org.junit.Assert;
import utilities.Authentication;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_Events {

    Response response;
    Map<String, Object> payload = new HashMap<>();
    int eventId;
    Faker faker = new Faker();
    int numberOfAttendees=faker.number().numberBetween(0, 10); //birden ona kadar bir rakam
    boolean isAuthenticatedUser=faker.bool().bool();//true or false

    String token;
    String cookie = Authentication.generateCookieDynamicWithEnum(URBANICFARM_CREDENTIALS.SELLER);
    int attendanceId;


    @When("user sends a request for getting token")
    public void userSendsARequestForGettingToken() {
        payload.put("email", "seller_urban@mailsac.com");
        payload.put("password", "VHt*zzt*wQNu6XS");
        response = given().formParams(payload).post("https://test.urbanicfarm.com/api/public/login");
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        token = response.jsonPath().getString("token");
        //response.prettyPrint();
        System.out.println("token = " + token);

    }

    @When("user makes a request and gets all Scheduled Events")
    public void user_makes_a_request_and_gets_all_scheduled_events() {
        response = given()
                .post("https://test.urbanicfarm.com/api/public/getAllEvents");
        // response.prettyPrint();
        eventId = response.jsonPath().getInt("events[-1].id");
        System.out.println("eventId = " + eventId);
        //System.out.println("cookie = " + cookie);
    }

    @Then("user register a scheduled event")
    public void userRegisterAScheduledEvent() {
        payload.put("eventId", eventId);
        payload.put("numberOfAttendees", numberOfAttendees);
        payload.put("isAuthenticatedUser", isAuthenticatedUser);


        //System.out.println("payload = " + payload);

        response = given()
                .contentType("application/json")
                .header("authorization", "Bearer " + token)
                .body(payload)
                .post("https://test.urbanicfarm.com/api/account/event/register");
        //response.prettyPrint();
        attendanceId = response.jsonPath().getInt("attendanceId");
        System.out.println("attendanceId = " + attendanceId);


    }

    @Then("user cancel a registered event")
    public void userCancelARegisteredEvent() {
        payload.put("attendanceId", attendanceId);
        payload.put("willBeRefunded", faker.bool().bool());
        response = given()
                .contentType("application/json")
                .header("authorization", "Bearer " + token)
                .body(payload)
                .post("https://test.urbanicfarm.com/api/account/event/attendance/my/cancel");
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        //response.prettyPrint();

    }

    @And("User verifies that {string} message is in response")
    public void userVerifiesThatMessageIsInResponse(String descr) {
        Assert.assertTrue(response.prettyPrint().contains(descr));
    }


}
