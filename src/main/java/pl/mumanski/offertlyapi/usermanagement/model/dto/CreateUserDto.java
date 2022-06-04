package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class CreateUserDto {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String photoUrl;
    private AvailabilityDto availability;
    private String city;
}
