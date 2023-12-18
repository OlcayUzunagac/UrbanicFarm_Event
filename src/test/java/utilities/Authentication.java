package utilities;


import enums.URBANICFARM_CREDENTIALS;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class Authentication {

    public static String cookie;
    public static Response response;
    public static String PHPSESSID;
    public static String csrfToken;

    public static String generateCookie() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", "hypnotes2022tr2@gmail.com");
        body.put("password", "Aydinlik123/");

        Response response = given().contentType(ContentType.JSON).body(body).post("https://test.hypnotes.net/api/login");
        response.prettyPrint();

        Map<String, String> cookieAsMap = new HashMap<>(response.getCookies());
        for (Map.Entry<String, String> entry : cookieAsMap.entrySet()) {
            if (entry.getKey().equals("PHPSESSID")) {
                cookie = entry.getKey() + "=" + entry.getValue();
            }
        }
        return cookie;
    }

    public static void main(String[] args) {
        System.out.println("generateCookie() = " + generateCookie());
    }




    public static String generateCookieDynamicWithEnum(URBANICFARM_CREDENTIALS user) {
        Map<String, Object> body = new HashMap<>();
        body.put("username", user.getUsername());
        body.put("password", user.getPassword());

        Response response = given().contentType(ContentType.JSON).body(body).post("https://test.hypnotes.net/api/login");
        //response.prettyPrint();
        //System.out.println("phpSessİd= " + response.getCookies().get("PHPSESSID"));

        Map<String, String> cookieAsMap = new HashMap<>(response.getCookies());
        for (Map.Entry<String, String> entry : cookieAsMap.entrySet()) {
            if (entry.getKey().equals("PHPSESSID")) {
                cookie = entry.getKey() + "=" + entry.getValue();
            }
        }
        return cookie;
    }


}
