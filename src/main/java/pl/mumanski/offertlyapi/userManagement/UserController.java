package pl.mumanski.offertlyapi.userManagement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mumanski.offertlyapi.userManagement.dto.CreateUserDto;
import pl.mumanski.offertlyapi.userManagement.dto.UserDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@Slf4j
class UserController {

    private final UserService userService;

    @Operation(operationId = "createUser", summary = "Create User", tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
            }
    )
    @RequestMapping(method = RequestMethod.POST, value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        User user = userService.save(createUserDto);
        UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @Operation(operationId = "getUser", summary = "Retrieve User", tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable @Valid @NotNull Long id) {
        User user = userService.getUserById(id);
        if(Objects.nonNull(user)){
            UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
