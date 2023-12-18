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



   public static String generateCookieDynamicWithEnum(URBANICFARM_CREDENTIALS user) {
        Map<String, Object> body = new HashMap<>();
        body.put("username", user.getUsername());
        body.put("password", user.getPassword());

        Response response = given().contentType(ContentType.JSON).body(body).post("https://test.urbanicfarm.com/api/public/login");
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
