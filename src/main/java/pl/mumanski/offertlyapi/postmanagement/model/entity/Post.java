package pl.mumanski.offertlyapi.postmanagement.model.entity;

import lombok.Data;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

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
    private Integer reportCount = 0;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User author;
}
