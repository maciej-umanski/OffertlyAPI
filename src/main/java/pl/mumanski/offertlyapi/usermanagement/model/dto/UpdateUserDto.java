package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema
public class UpdateUserDto {
    private String password;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String photoUrl;
    private List<CommentDto> comments;
    private AvailabilityDto availability;
    private String city;
    private Double averageRate;
}
