package fr.akirabane.cite4mpfmanager.dao;

import fr.akirabane.cite4mpfmanager.model.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitDAO extends JpaRepository<Units, Long> {

}
