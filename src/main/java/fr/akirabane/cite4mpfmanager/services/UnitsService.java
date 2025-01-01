package fr.akirabane.cite4mpfmanager.services;

import fr.akirabane.cite4mpfmanager.constantes.genericConstantes;
import fr.akirabane.cite4mpfmanager.exceptions.*;
import fr.akirabane.cite4mpfmanager.model.Units;
import fr.akirabane.cite4mpfmanager.repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class UnitsService {

    private final UnitsRepository unitsRepository;

    @Autowired
    public UnitsService(UnitsRepository unitsRepository) {
        this.unitsRepository = unitsRepository;
    }

    public Units addUnit(Units unit) {

        if (unit.getPseudo() == null || unit.getGrade() == null || unit.getDivision() == null || unit.getCid() == 0) {
            throw new AddUnitMissingInformationException("Missing information : Pseudo, Grade, Division and CID are required.");
        }

        String uuid = fetchUUIDFromMinecraftAPI(unit.getPseudo());
        unit.setUuid(uuid);

        String skin = genericConstantes.API_MINECRAFT_SKIN_URL + unit.getPseudo() + "/Body/10.5/10";
        unit.setSkin(skin);

        validateCID(unit);
        validateGrade(unit);
        validateDivision(unit);
        validateMatricule(unit);

        return unitsRepository.save(unit);
    }

    public Units updateUnit(int cid, Units unit) {
        Units existingUnit = unitsRepository.findUnitsByCid(cid);
        if (existingUnit == null) {
            throw new UnitNotFoundException("Unit with CID " + cid + " not found");
        }

        if (unit.getPseudo() != null) {
            existingUnit.setPseudo(unit.getPseudo());

            String uuid = fetchUUIDFromMinecraftAPI(unit.getPseudo());
            existingUnit.setUuid(uuid);

            String skin = genericConstantes.API_MINECRAFT_SKIN_URL + unit.getPseudo() + "/Body/10.5/10";
            existingUnit.setSkin(skin);
        }
        if (unit.getGrade() != null) {
            existingUnit.setGrade(unit.getGrade());
            validateGrade(existingUnit);
        }
        if (unit.getDivision() != null) {
            existingUnit.setDivision(unit.getDivision());
            validateDivision(existingUnit);
        }
        if (unit.getCid() != 0 && unit.getCid() != cid && String.valueOf(unit.getCid()).length() == 5) {
            existingUnit.setCid(unit.getCid());
            validateCID(existingUnit);
        }

        validateMatricule(existingUnit);

        return unitsRepository.save(existingUnit);
    }

    public void deleteUnitByCid(int cid) {
        Units unit = unitsRepository.findUnitsByCid(cid);
        if (unit == null) {
            throw new UnitNotFoundException("Unit with CID " + cid + " not found");
        }
        unitsRepository.delete(unit);
    }

    public Units findUnitById(int id) {
        return unitsRepository.findById(id).orElseThrow(() -> new UnitNotFoundException("Unit with id " + id + " not found"));
    }

    public Units findUnitByPseudo(String pseudo) {
        return unitsRepository.findUnitByPseudo(pseudo);
    }

    public Units findUnitByUuid(String uuid) {
        return unitsRepository.findUnitByUuid(uuid);
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

    private String fetchUUIDFromMinecraftAPI(String pseudo) {
        try {
            URL url = new URL(genericConstantes.API_MINECRAFT_UUID_URL + pseudo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    return reader.readLine();
                }
            } else {
                throw new IllegalArgumentException("Invalid pseudo: Unable to fetch UUID.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while fetching UUID from Minecraft API.", e);
        }
    }

    private void validateCID(Units unit) {
        Units checkingCID = unitsRepository.findUnitsByCid(unit.getCid());
        if (checkingCID != null) {
            throw new UnitAlreadyExistException("Unit with CID " + unit.getCid() + " already exists");
        }
        if (String.valueOf(unit.getCid()).length() < 5) {
            throw new IllegalArgumentException("CID must be at least 5 characters long.");
        }
    }

    private void validateGrade(Units unit) {
        String grade = unit.getGrade();
        if (genericConstantes.VALID_GRADES.stream().noneMatch(grade::equals)) {
            throw new InvalidGradeException("Grade " + grade + " is invalid, must be one of " + genericConstantes.VALID_GRADES);
        }
    }

    private void validateDivision(Units unit) {
        String division = unit.getDivision();
        if (genericConstantes.VALID_DIVISION.stream().noneMatch(division::equals)) {
            throw new InvalidGradeException("Division " + division + " is invalid, must be one of " + genericConstantes.VALID_DIVISION);
        }
    }

    private void validateMatricule(Units unit) {
        if (unit.getMatricule().length() < 5) {
            throw new IllegalArgumentException("Matricule must be at least 5 characters long.");
        }

        unit.setMatricule(unit.getMatricule());
    }
}
