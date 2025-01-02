package fr.akirabane.cite4mpfmanager.mapper;

import fr.akirabane.cite4mpfmanager.dto.UnitDTO;
import fr.akirabane.cite4mpfmanager.model.Units;

public class UnitMapper {

    public static UnitDTO convertToDTO(Units unit) {
        return new UnitDTO(
                unit.getId(),
                unit.getPseudo(),
                unit.getUuid(),
                unit.getSkin(),
                unit.getCid(),
                unit.getGrade(),
                unit.getDivision(),
                unit.getMatricule()
        );
    }

    public static Units convertToEntity(UnitDTO unitDTO) {
        Units unit = new Units();
        unit.setPseudo(unitDTO.getPseudo());
        unit.setUuid(unitDTO.getUuid());
        unit.setSkin(unitDTO.getSkin());
        unit.setCid(unitDTO.getCid());
        unit.setGrade(unitDTO.getGrade());
        unit.setDivision(unitDTO.getDivision());
        unit.setMatricule(unitDTO.getMatricule());
        return unit;
    }
}

