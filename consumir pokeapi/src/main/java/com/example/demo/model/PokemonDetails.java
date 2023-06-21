package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDetails {
    private List<Ability> abilities;
    private int baseExperience;
    private List<Form> forms;
    private List<GameIndex> gameIndices;
    private int height;
    private List<HeldItem> heldItems;
    private int id;
    private boolean isDefault;
    private String locationAreaEncounters;
    private List<Move> moves;

    public class Ability {
        private AbilityData ability;
        private boolean isHidden;
        private int slot;
        // Constructor, getters y setters
    }

    public class AbilityData {
        private String name;
        private String url;
        // Constructor, getters y setters
    }

    public class Form {
        private String name;
        private String url;
        // Constructor, getters y setters
    }

    public class GameIndex {
        private int gameIndex;
        private Version version;
        // Constructor, getters y setters
    }

    public class Version {
        private String name;
        private String url;
        // Constructor, getters y setters
    }

    public class HeldItem {
        // Estructura de los datos de los ítems (si es necesario)
        // Constructor, getters y setters
    }

    public class Move {
        private MoveData move;
        private List<VersionGroupDetail> versionGroupDetails;
        // Constructor, getters y setters
    }

    public class MoveData {
        private String name;
        private String url;
        // Constructor, getters y setters
    }

    public class VersionGroupDetail {
        private int levelLearnedAt;
        private MoveLearnMethod moveLearnMethod;
        private VersionGroup versionGroup;
        // Constructor, getters y setters
    }

    public class MoveLearnMethod {
        private String name;
        private String url;
        // Constructor, getters y setters
    }

    public class VersionGroup {
        private String name;
        private String url;
        // Constructor, getters y setters
    }

}
