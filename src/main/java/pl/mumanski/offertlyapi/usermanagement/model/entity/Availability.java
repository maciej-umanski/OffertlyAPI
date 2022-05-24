package pl.mumanski.offertlyapi.usermanagement.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "availability")
@Data
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> mon;
    @ElementCollection
    private List<Integer> tue;
    @ElementCollection
    private List<Integer> wed;
    @ElementCollection
    private List<Integer> thu;
    @ElementCollection
    private List<Integer> fri;
    @ElementCollection
    private List<Integer> sat;
    @ElementCollection
    private List<Integer> sun;
}
