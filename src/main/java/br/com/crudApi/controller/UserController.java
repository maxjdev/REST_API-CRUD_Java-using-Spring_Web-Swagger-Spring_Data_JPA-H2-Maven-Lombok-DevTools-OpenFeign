package br.com.crudApi.controller;

import br.com.crudApi.dto.UserDTO;
import br.com.crudApi.model.User;
import br.com.crudApi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author maxjdev
 */

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "CRUD operations for users")
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }
    // REQUESTS
    @GetMapping
    @Operation(summary = "List users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = service.getAllUsers();
        List<UserDTO> usersDTO = users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usersDTO);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Search users by ID")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = service.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(user));
    }
    @PostMapping
    @Operation(summary = "Create a new user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User createdUSer = service.createUser(user);
        UserDTO createdUSerDTO = convertToDto(createdUSer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUSerDTO);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update user by id")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = service.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        User updatedUser = service.updateUser(id, user);
        return ResponseEntity.ok(convertToDto(updatedUser));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    // CONVERSIONS
    @Operation(summary = "Convert User to UserDTO")
    private UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
