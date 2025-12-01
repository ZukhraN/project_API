package controllers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Pet;

import static constans.CommonConstans.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PetController {

    private static final String END_POINT_PET = "/pet";

    RequestSpecification requestSpecification;

    public PetController(){
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL);
    }

    @Step("Create a new pet")
    public Response CreatePet(Pet pet){
        return  given(this.requestSpecification)
                .body(pet)
                .when()
                .post(END_POINT_PET)
                .andReturn();
    }

    @Step("Update information of pet")
    public Response UpdatePet(Pet pet){
        return  given(this.requestSpecification)
                .body(pet)
                .when()
                .put(END_POINT_PET)
                .andReturn();
    }

    @Step("Get information of pet")
    public Response GetPetById(long id){
        return given(this.requestSpecification)
                .when()
                .get(END_POINT_PET + "/" + id)
                .andReturn();
    }

    @Step("Delete pet")
    public Response DeletePetById(long id){
        return given(this.requestSpecification)
                .when()
                .delete(END_POINT_PET + "/" + id)
                .andReturn();
    }


}
