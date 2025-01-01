package fr.akirabane.cite4mpfmanager.services;

import fr.akirabane.cite4mpfmanager.exceptions.UnitNotFoundException;
import fr.akirabane.cite4mpfmanager.model.Units;
import fr.akirabane.cite4mpfmanager.repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitsService {

    private final UnitsRepository unitsRepository;

    @Autowired
    public UnitsService(UnitsRepository unitsRepository) {
        this.unitsRepository = unitsRepository;
    }

    public Units addUnits(Units units) {
        return unitsRepository.save(units);
    }

    public Units updateUnit(Units units) {
        return unitsRepository.save(units);
    }

    public void deleteUnit(int id) {
        unitsRepository.deleteById(id);
    }

    public Units findUnitById(int id) {
        return unitsRepository.findById(id).orElseThrow(() -> new UnitNotFoundException("Unit with id " + id + " not found"));
    }

    public List<Units> findUnitsByGrade(String grade) {
        return unitsRepository.findUnitsByGrade(grade);
    }

    public List<Units> findUnitsByDivision(String division) {
        return unitsRepository.findUnitsByDivision(division);
    }

    public Units findUnitByCid(int cid) {
        return unitsRepository.findUnitsByCid(cid);
    }

    public List<Units> findAllUnits() {
        return unitsRepository.findAll();
    }
}
