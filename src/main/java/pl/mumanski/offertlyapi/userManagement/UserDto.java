package pl.mumanski.offertlyapi.userManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class UserDto {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String mail;
}
