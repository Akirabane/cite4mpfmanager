package fr.akirabane.cite4mpfmanager.services;

import fr.akirabane.cite4mpfmanager.dto.UserDTO;
import fr.akirabane.cite4mpfmanager.exceptions.UnitNotFoundException;
import fr.akirabane.cite4mpfmanager.exceptions.UserNotFoundException;
import fr.akirabane.cite4mpfmanager.model.Users;
import fr.akirabane.cite4mpfmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    public Users findUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UnitNotFoundException("User with id " + id + " not found"));
    }

    public Users findUserByPseudo(String pseudo) {
        return userRepository.findUserByPseudo(pseudo);
    }

    public List<Users> findUsersByAdmin(boolean admin) {
        return userRepository.findUsersByIsAdmin(admin);
    }

    public UserDTO addUser(UserDTO userDTO) {
        Users user = new Users();
        user.setPseudo(userDTO.getPseudo());
        user.setPassword(userDTO.getPassword());
        user.setIsAdmin(userDTO.getIsAdmin());
        Users newUser = userRepository.save(user);
        return new UserDTO(newUser.getId(), newUser.getPseudo(), newUser.getPassword(), newUser.getIsAdmin());
    }

    public Users updateUser(String pseudo, Users user) {
        Users findUser = userRepository.findUserByPseudo(pseudo);
        if (findUser == null) {
            throw new UserNotFoundException("User with pseudo " + pseudo + " not found");
        }
        Users existingUser = userRepository.findById(findUser.getId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + findUser.getId() + " not found"));

        existingUser.setPassword(user.getPassword());
        existingUser.setIsAdmin(user.getIsAdmin());
        return userRepository.save(existingUser);
    }


    public void deleteUserByPseudo(String pseudo) {
        Users user = userRepository.findUserByPseudo(pseudo);
        if (user == null) {
            throw new UserNotFoundException("User with pseudo " + pseudo + " not found");
        }
        Users existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + user.getId() + " not found"));
        userRepository.deleteById(existingUser.getId());
    }

}
