package fr.akirabane.cite4mpfmanager.repository;

import fr.akirabane.cite4mpfmanager.model.Units;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnitsRepository extends JpaRepository<Units, Integer> {
    List<Units> findUnitsByGrade(String grade);
    List<Units> findUnitsByDivision(String division);
    Units findUnitsByCid(int cid);
}
