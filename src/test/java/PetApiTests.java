import controllers.PetController;
import io.restassured.response.Response;
import models.AddPetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


import static constans.CommonConstans.*;

public class PetApiTests {


    @Test
    public void createPetTest(){
        PetController petController = new PetController();
        Response response = petController.CreatePet(DEFAULT_PET);
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("pet", createPetResponse.getName());
        Assert.assertEquals("available", createPetResponse.getStatus());
    }


    @Test
    public void updatePetTest(){
        PetController petController = new PetController();
        Response response = petController.UpdatePet(UPDATED_PET);
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("sold", createPetResponse.getStatus());
    }


    @Test
    public void getPetTest(){
        int pet_id = 1000;
        PetController petController = new PetController();
        Response response = petController.GetPetById(pet_id);
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("doggie", createPetResponse.getName());
    }


    @Test
    public void detelePetTest(){
        int pet_id = 1;
        PetController petController = new PetController();
        Response response = petController.CreatePet(DELETED_PET);

        Assert.assertEquals(200, response.getStatusCode());
    }
}
