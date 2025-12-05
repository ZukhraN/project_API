package models;

import lombok.Data;

@Data
public class AddResponsePet {
    private int code;
    private String type;
    private String message;
}
