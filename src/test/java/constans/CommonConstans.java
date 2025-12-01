package constans;

import models.Pet;

public class CommonConstans {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static final Pet DEFAULT_PET = new Pet(0, "pet", "available");
    public static final Pet UPDATED_PET = new Pet(2, "cat", "sold");
    public static final Pet DELETED_PET = new Pet(1, "pet", "available");
}
