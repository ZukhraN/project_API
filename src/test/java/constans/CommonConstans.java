package constans;

import models.Pet;
import models.Status;

public class CommonConstans {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static final Pet DEFAULT_PET = new Pet(0, "pet", Status.available);
    public static final Pet UPDATED_PET = new Pet(2, "cat", Status.sold);
    public static final Pet DELETED_PET = new Pet(1, "pet", Status.pending);
}
