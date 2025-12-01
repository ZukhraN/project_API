import controllers.PetController;
import io.restassured.response.Response;
import models.AddPetResponse;
import models.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constans.CommonConstans.DEFAULT_PET;
import static constans.CommonConstans.UPDATED_PET;

public class PetApiTests {


    @Test
    public void createPetTest(){
        PetController petController = new PetController();
        Response response = petController.CreatePet(DEFAULT_PET);
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("pet", createPetResponse.getName());
        Assertions.assertEquals("available", createPetResponse.getStatus());
    }

    @Test
    public void updatePetTest(){
        PetController petController = new PetController();
        Response response = petController.UpdatePet(UPDATED_PET);
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("sold", createPetResponse.getStatus());
    }

    @Test
    public void getPetTest(){
        int pet_id = 1000;
        PetController petController = new PetController();
        Response response = petController.GetPetById(pet_id);
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("cat", createPetResponse.getName());
    }


    public void detelePetTest(){
        Pet pet = Pet.builder()
                .id(0L)
                .name("cattie")
                .build();
        PetController petController = new PetController();
        Response response = petController.DeletePetById(pet.getId());
        AddPetResponse createPetResponse = response.as(AddPetResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("puppy", createPetResponse.getName());
    }
}
