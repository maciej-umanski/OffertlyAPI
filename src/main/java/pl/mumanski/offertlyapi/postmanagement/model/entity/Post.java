package pl.mumanski.offertlyapi.postmanagement.model.entity;

import lombok.Data;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private OffsetDateTime created;
    private String city;
    private Double price;
    private String currency;
    private String photoUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private User author;
}
