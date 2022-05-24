package pl.mumanski.offertlyapi.usermanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import pl.mumanski.offertlyapi.usermanagement.model.entity.Comment;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String photoUrl;
    private OffsetDateTime created;
    private String phoneNumber;
    private OffsetDateTime lastActive;
    private Double averageRate;
    Set<Comment> comments;
    @Valid
    private AvailabilityDto availability;
}
