package fr.akirabane.cite4mpfmanager.mapper;

import fr.akirabane.cite4mpfmanager.dto.UserDTO;
import fr.akirabane.cite4mpfmanager.model.Users;

public class UserMapper {

    public static UserDTO convertToDTO(Users users) {
        return new UserDTO(
                users.getId(),
                users.getPseudo(),
                users.getPassword(),
                users.getIsAdmin()
        );
    }

    public static Users convertToEntity(UserDTO UserDTO) {
        Users users = new Users();
        users.setPseudo(UserDTO.getPseudo());
        users.setPassword(UserDTO.getPassword());
        users.setIsAdmin(UserDTO.getIsAdmin());
        return users;
    }
}