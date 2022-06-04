package pl.mumanski.offertlyapi.usermanagement.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @OneToMany(cascade = CascadeType.ALL)
    List<Comment> comments;
    @OneToOne(cascade = CascadeType.ALL)
    Availability availability;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String city;
}
