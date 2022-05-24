package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Data
@Schema
@Validated
public class UpdateUserDto {
    private String password;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String photoUrl;
    private List<CommentDto> comments;
    @Valid
    private AvailabilityDto availability;
}
