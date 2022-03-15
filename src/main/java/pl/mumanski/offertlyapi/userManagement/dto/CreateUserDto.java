package pl.mumanski.offertlyapi.userManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Schema
public class CreateUserDto {
    private String username;
    private String password;
}
