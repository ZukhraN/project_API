import io.restassured.response.Response;
import models.AddPetResponse;
import models.AddResponsePet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUploadTests {


    @Test
    void apiUploadTest() {

        // URL API для загрузки изображения
        String apiUrl = "https://petstore.swagger.io/v2/pet/1/uploadImage";
        // Создаем объект File, который указывает на изображение для загрузки
        // Путь к файлу
        File file = new File("src/test/resources/webdrivermanager.png");
        // Отправляем POST-запрос на API с изображением
        Response response =
                given()
                        .header("accept", "application/json")
                        .contentType("multipart/form-data")
                        .multiPart("file", file, "image/jpeg") // Указываем тип содержимого файла
                        .when()
                        .post(apiUrl)
                        .then()
                        .statusCode(200)  // Проверяем, что запрос успешен
                        .extract()
                        .response();
        // Выводим ответ сервера
        System.out.println("Response: " + response.asString());
        AddResponsePet createPetResponse = response.as(AddResponsePet.class);

        Assert.assertEquals(200, createPetResponse.getCode());
        Assert.assertEquals("unknown", createPetResponse.getType());

    }
}
