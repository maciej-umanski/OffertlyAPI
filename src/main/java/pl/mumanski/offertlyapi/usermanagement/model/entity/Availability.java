package pl.mumanski.offertlyapi.usermanagement.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "availability")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
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

    public static Availability empty() {
        return Availability.builder()
                .mon(Collections.emptyList())
                .tue(Collections.emptyList())
                .wed(Collections.emptyList())
                .thu(Collections.emptyList())
                .fri(Collections.emptyList())
                .sat(Collections.emptyList())
                .sun(Collections.emptyList())
                .build();
    }
}
