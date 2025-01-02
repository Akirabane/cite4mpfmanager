package fr.akirabane.cite4mpfmanager.controllers;

import fr.akirabane.cite4mpfmanager.dto.UnitDTO;
import fr.akirabane.cite4mpfmanager.mapper.UnitMapper;
import fr.akirabane.cite4mpfmanager.model.Units;
import fr.akirabane.cite4mpfmanager.services.UnitsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/units")
public class UnitsController {

    private final UnitsService unitsService;

    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/allUnits")
    public ResponseEntity<List<UnitDTO>> getAllUnits() {
        List<Units> allUnits = unitsService.findAllUnits();
        List<UnitDTO> allUnitsDTO = allUnits.stream()
                .map(UnitMapper::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(allUnitsDTO, HttpStatus.OK);
    }

    @GetMapping("/findUnitById/{id}")
    public ResponseEntity<UnitDTO> getUnitById(@PathVariable("id") int id) {
        Units unit = unitsService.findUnitById(id);
        UnitDTO unitDTO = UnitMapper.convertToDTO(unit);
        return new ResponseEntity<>(unitDTO, HttpStatus.OK);
    }

    @GetMapping("/findUnitByPseudo/{pseudo}")
    public ResponseEntity<UnitDTO> getUnitByPseudo(@PathVariable("pseudo") String pseudo) {
        Units unit = unitsService.findUnitByPseudo(pseudo);
        UnitDTO unitDTO = UnitMapper.convertToDTO(unit);
        return new ResponseEntity<>(unitDTO, HttpStatus.OK);
    }

    @GetMapping("/findUnitByUuid/{uuid}")
    public ResponseEntity<UnitDTO> getUnitByUuid(@PathVariable("uuid") String uuid) {
        Units unit = unitsService.findUnitByUuid(uuid);
        UnitDTO unitDTO = UnitMapper.convertToDTO(unit);
        return new ResponseEntity<>(unitDTO, HttpStatus.OK);
    }

    @GetMapping("/findUnitsByGrade/{grade}")
    public ResponseEntity<List<UnitDTO>> getUnitsByGrade(@PathVariable("grade") String grade) {
        List<Units> units = unitsService.findUnitsByGrade(grade);
        List<UnitDTO> unitsDTO = units.stream()
                .map(UnitMapper::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(unitsDTO, HttpStatus.OK);
    }

    @GetMapping("/findUnitsByDivision/{division}")
    public ResponseEntity<List<UnitDTO>> getUnitsByDivision(@PathVariable("division") String division) {
        List<Units> units = unitsService.findUnitsByDivision(division);
        List<UnitDTO> unitsDTO = units.stream()
                .map(UnitMapper::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(unitsDTO, HttpStatus.OK);
    }

    @GetMapping("/findUnitByCID/{cid}")
    public ResponseEntity<UnitDTO> getUnitByCid(@PathVariable("cid") int cid) {
        Units unit = unitsService.findUnitByCid(cid);
        UnitDTO unitDTO = UnitMapper.convertToDTO(unit);
        return new ResponseEntity<>(unitDTO, HttpStatus.OK);
    }

    @PostMapping("/addUnit")
    public ResponseEntity<UnitDTO> addUnit(@RequestBody UnitDTO unitDTO) {
        UnitDTO newUnitDTO = unitsService.addUnit(unitDTO);
        return new ResponseEntity<>(newUnitDTO, HttpStatus.CREATED);
    }

    @PutMapping("/updateUnit/{CID}")
    public ResponseEntity<UnitDTO> updateUnit(@PathVariable("CID") int cid, @RequestBody UnitDTO unitDTO) {
        Units unitToUpdate = UnitMapper.convertToEntity(unitDTO);
        Units updatedUnit = unitsService.updateUnit(cid, unitToUpdate);
        UnitDTO updatedUnitDTO = UnitMapper.convertToDTO(updatedUnit);
        return new ResponseEntity<>(updatedUnitDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUnit/{cid}")
    public ResponseEntity<String> deleteUnit(@PathVariable("cid") int cid) {
        unitsService.deleteUnitByCid(cid);
        return new ResponseEntity<>("Unité supprimée avec succès.", HttpStatus.OK);
    }
}
