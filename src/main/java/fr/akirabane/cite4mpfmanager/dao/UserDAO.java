package fr.akirabane.cite4mpfmanager.dao;

import fr.akirabane.cite4mpfmanager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users, Long> {
}
