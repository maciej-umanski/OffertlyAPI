package pl.mumanski.offertlyapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    private String name;
    private String lastName;
    private String photoUrl;
    private OffsetDateTime created;
    private String phoneNumber;
    private OffsetDateTime lastActive;
    private Double averageRate;

    @OneToMany
    List<Comment> comments;
}
