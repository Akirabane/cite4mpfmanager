package fr.akirabane.cite4mpfmanager.controllers;

import fr.akirabane.cite4mpfmanager.model.Units;
import fr.akirabane.cite4mpfmanager.services.UnitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitsController {

    private final UnitsService unitsService;

    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/allUnits")
    public ResponseEntity<List<Units>> getAllUnits() {
        List<Units> allUnits = unitsService.findAllUnits();
        return new ResponseEntity<>(allUnits, HttpStatus.OK);
    }

    @GetMapping("/findUnitById/{id}")
    public ResponseEntity<Units> getUnitById(@PathVariable("id") int id) {
        Units unit = unitsService.findUnitById(id);
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    @GetMapping("/findUnitsByGrade/{grade}")
    public ResponseEntity<List<Units>> getUnitsByGrade(@PathVariable("grade") String grade) {
        List<Units> units = unitsService.findUnitsByGrade(grade);
        return new ResponseEntity<>(units, HttpStatus.OK);
    }

    @GetMapping("/findUnitsByDivision/{division}")
    public ResponseEntity<List<Units>> getUnitsByDivision(@PathVariable("division") String division) {
        List<Units> units = unitsService.findUnitsByDivision(division);
        return new ResponseEntity<>(units, HttpStatus.OK);
    }

    @GetMapping("/findUnitByCID/{cid}")
    public ResponseEntity<Units> getUnitByCid(@PathVariable("cid") int cid) {
        Units unit = unitsService.findUnitByCid(cid);
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    @PostMapping("/addUnit")
    public ResponseEntity<Units> addUnit(@RequestBody Units unit) {
        Units newUnit = unitsService.addUnits(unit);
        return new ResponseEntity<>(newUnit, HttpStatus.CREATED);
    }

    @PutMapping("/updateUnit")
    public ResponseEntity<Units> updateUnit(@RequestBody Units unit) {
        Units updateUnit = unitsService.updateUnit(unit);
        return new ResponseEntity<>(updateUnit, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUnit/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable("id") int id) {
        unitsService.deleteUnit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
