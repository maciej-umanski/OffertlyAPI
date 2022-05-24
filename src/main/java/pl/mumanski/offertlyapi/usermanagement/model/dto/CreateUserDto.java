package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Data
@Schema
@Validated
public class CreateUserDto {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String photoUrl;
    @Valid
    private AvailabilityDto availability;
}
