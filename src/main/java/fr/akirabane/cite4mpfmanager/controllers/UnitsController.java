package fr.akirabane.cite4mpfmanager.controllers;

import fr.akirabane.cite4mpfmanager.constantes.genericConstantes;
import fr.akirabane.cite4mpfmanager.exceptions.CidErrorException;
import fr.akirabane.cite4mpfmanager.exceptions.InvalidGradeException;
import fr.akirabane.cite4mpfmanager.exceptions.UnitAlreadyExistException;
import fr.akirabane.cite4mpfmanager.model.Units;
import fr.akirabane.cite4mpfmanager.services.UnitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/findUnitByPseudo/{pseudo}")
    public ResponseEntity<Units> getUnitByPseudo(@PathVariable("pseudo") String pseudo) {
        Units unit = unitsService.findUnitByPseudo(pseudo);
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    @GetMapping("/findUnitByUuid/{uuid}")
    public ResponseEntity<Units> getUnitByUuid(@PathVariable("uuid") String uuid) {
        Units unit = unitsService.findUnitByUuid(uuid);
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
        Units newUnit = unitsService.addUnit(unit);
        return new ResponseEntity<>(newUnit, HttpStatus.CREATED);
    }


    @PutMapping("/updateUnit/{CID}")
    public ResponseEntity<Units> updateUnit(@PathVariable("CID") int cid, @RequestBody Units unit) {
        Units updatedUnit = unitsService.updateUnit(cid, unit);
        return new ResponseEntity<>(updatedUnit, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUnit/{cid}")
    public ResponseEntity<?> deleteUnit(@PathVariable("cid") int cid) {
        unitsService.deleteUnitByCid(cid);
        return new ResponseEntity<>("Unité suprimée avec succès.", HttpStatus.OK);
    }

}
