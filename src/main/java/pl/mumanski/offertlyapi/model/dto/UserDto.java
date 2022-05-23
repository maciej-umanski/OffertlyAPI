package pl.mumanski.offertlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mumanski.offertlyapi.model.entity.Comment;

import javax.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}