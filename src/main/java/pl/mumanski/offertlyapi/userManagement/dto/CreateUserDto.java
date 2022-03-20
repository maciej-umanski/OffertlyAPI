package pl.mumanski.offertlyapi.userManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class CreateUserDto {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String mail;
}
