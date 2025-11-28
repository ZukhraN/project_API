package controllers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import static constans.CommonConstans.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserController {

    RequestSpecification requestSpecification;
    private static final String END_POINT = "user";

    public UserController(){
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL);
    }

    public Response CreateUser(User user){
        return  given(this.requestSpecification)
                    .body(user)
                .when()
                    .post(END_POINT)
                    .andReturn();
    }

    public Response UpdateUser(User user){
        return  given(this.requestSpecification)
                    .body(user)
                .when()
                    .put(END_POINT + "/" + user.getUsername())
                .andReturn();
    }

    public Response DeleteUser(String username){
        return  given(this.requestSpecification)
                .when()
                    .delete(END_POINT + "/" + username)
                    .andReturn();
    }

    public Response GetUserByUserName(String username){
        return given(this.requestSpecification)
                .when()
                    .get(END_POINT + "/" + username)
                    .andReturn();
    }

}
