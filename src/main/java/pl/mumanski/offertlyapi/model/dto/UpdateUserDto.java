package pl.mumanski.offertlyapi.model.dto;

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
}
