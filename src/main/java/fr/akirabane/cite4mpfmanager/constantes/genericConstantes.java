package fr.akirabane.cite4mpfmanager.constantes;

import java.util.Set;

public final class genericConstantes {

    private genericConstantes() {
        throw new UnsupportedOperationException("Cette classe ne peut pas être instanciée");
    }

    public static final Set<String> VALID_GRADES = Set.of("RCT", "EnS", "SqL", "OfC", "DvL", "EvO", "EpU", "CmD");

    public static final Set<String> VALID_DIVISION = Set.of("UNION", "BLADE", "SHIELD", "SWORD", "NOVA", "PRESSURE", "HELIX", "APEX", "JUDGE", "JURY");

    public static final Set<String> SECOND_JOBS_AVAILABLE = Set.of("Scanner", "OWS", "EOWS", "XRAY", "LDR", "GHOST", "SPECTRE", "CMP", "KING");

    public static final String API_MINECRAFT_UUID_URL = "https://minecraft-api.com/api/uuid/";

    public static final String API_MINECRAFT_SKIN_URL = "https://mc-heads.net/body/";


}

