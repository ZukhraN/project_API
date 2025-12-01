package constans;

import models.Pet;

public class CommonConstans {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static final Pet DEFAULT_PET = new Pet(0, "pet", "available");
    public static final Pet UPDATED_PET = new Pet(1, "cat", "sold");
}
