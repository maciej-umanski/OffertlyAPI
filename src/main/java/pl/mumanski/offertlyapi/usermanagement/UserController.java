package pl.mumanski.offertlyapi.usermanagement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateCommentDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UpdateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.entity.User;
import pl.mumanski.offertlyapi.usermanagement.model.dto.CreateUserDto;
import pl.mumanski.offertlyapi.usermanagement.model.dto.UserDto;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
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
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto createUserDto) {
        User user = userService.register(createUserDto);
        UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED); // todo: EH jak login taki sam
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
        try {
            User user = userService.getUserById(id);
            UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(operationId = "getAllUsers", summary = "Retrieve All Users", tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getUser() {
        List<UserDto> users = userService.getAllUsers()
                .stream()
                .map(UserMapper.INSTANCE::toUserDto).toList();

        if (users.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

    }

    @Operation(operationId = "authenticateUser", summary = "Authenticate User", tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.GET, value = "/user/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> authenticateUser(
            @RequestParam @Valid @NotNull String username,
            @RequestParam @Valid @NotNull String password) {
        try {
            User user = userService.getUserByCredentials(username, password);
            UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(operationId = "putUser", summary = "Update User", tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> putUser(@PathVariable @Valid @NotNull Long id,
                                           @RequestBody @Valid UpdateUserDto updateUserDto) {
        try {
            User user = userService.put(updateUserDto, id);
            UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(operationId = "addComment", summary = "Add Comment to User", tags = {"Comment"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @RequestMapping(method = RequestMethod.POST, value = "/user/{id}/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> addComment(@PathVariable @Valid @NotNull Long id,
                                              @RequestBody @Valid CreateCommentDto createCommentDto) {
        try {
            User user = userService.addComment(createCommentDto, id);
            UserDto userDto = UserMapper.INSTANCE.toUserDto(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
