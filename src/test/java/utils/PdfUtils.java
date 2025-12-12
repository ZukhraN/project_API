package utils;

import io.restassured.response.Response;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PdfUtils {
    public static void savePdf(Response response, String fileName) {
        if (response != null) {
            // Получение содержимого ответа в виде InputStream
            try (InputStream inputStream = response.getBody().asInputStream();
                 OutputStream outputStream = new FileOutputStream(fileName)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("PDF успешно сохранен в файл: " + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}