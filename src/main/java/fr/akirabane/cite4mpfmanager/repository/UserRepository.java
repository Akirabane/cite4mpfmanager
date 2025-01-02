package fr.akirabane.cite4mpfmanager.repository;

import fr.akirabane.cite4mpfmanager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUserByPseudo(String pseudo);
    List<Users> findUsersByIsAdmin(boolean isAdmin);
}
