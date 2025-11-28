
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SmokeApiTests {

    @Test
    public void checkStatusCodeTest(){
       String body = """
               {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
               }""";

       Response response = given()
                   .header("accept", "application/json")
                   .header("Content-Type", "application/json")
                   .baseUri("https://petstore.swagger.io/v2/")
               .when()
                   .body(body)
                   .post("user")
               .andReturn();

       int actualCode = response.getStatusCode();

        Assertions.assertEquals(200, actualCode);
    }

    @Test
    public void checkTypeTest(){
        String baseUrl = "https://petstore.swagger.io/v2/";
        String body = """
               {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
               }""";

        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .baseUri(baseUrl)
                .when()
                .body(body)
                .post("user")
                .then()
                    .statusCode(200)
                    .body("type", equalTo("unknown"));
    }


}
