package pl.mumanski.offertlyapi.userManagement;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String middleName;
    private String surname;
}
