package fr.akirabane.cite4mpfmanager.controllers;

import fr.akirabane.cite4mpfmanager.dto.UserDTO;
import fr.akirabane.cite4mpfmanager.mapper.UserMapper;
import fr.akirabane.cite4mpfmanager.model.Users;
import fr.akirabane.cite4mpfmanager.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<Users> allUsers = userService.findAllUsers();
        List<UserDTO> allUsersDTO = allUsers.stream()
                .map(UserMapper::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(allUsersDTO, HttpStatus.OK);
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id) {
        Users user = userService.findUserById(id);
        UserDTO userDTO = UserMapper.convertToDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/findUserByPseudo/{pseudo}")
    public ResponseEntity<UserDTO> getUserByPseudo(@PathVariable("pseudo") String pseudo) {
        Users user = userService.findUserByPseudo(pseudo);
        UserDTO userDTO = UserMapper.convertToDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/findUsersByAdmin/{admin}")
    public ResponseEntity<List<UserDTO>> getUsersByAdmin(@PathVariable("admin") boolean admin) {
        List<Users> users = userService.findUsersByAdmin(admin);
        List<UserDTO> usersDTO = users.stream()
                .map(UserMapper::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO newUserDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{pseudo}")
    public ResponseEntity<UserDTO> updateUnit(@PathVariable("pseudo") String pseudo, @RequestBody UserDTO userDTO) {
        Users userToUpdate = UserMapper.convertToEntity(userDTO);
        Users updatedUser = userService.updateUser(pseudo, userToUpdate);
        UserDTO updatedUserDTO = UserMapper.convertToDTO(updatedUser);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{pseudo}")
    public ResponseEntity<String> deleteUser(@PathVariable("pseudo") String pseudo) {
        userService.deleteUserByPseudo(pseudo);
        return new ResponseEntity<>("Utilisateur supprimé avec succès.", HttpStatus.OK);
    }
}
