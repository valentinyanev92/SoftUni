package main.model;

import lombok.Getter;

@Getter
public enum PlayerClass {

    STORM_SCREAMER("Storm Screamer"),
    MOONLIGHT_SENTINEL("Moonlight Sentinel"),
    PHOENIX_KNIGHT("Phoenix Knight"),
    TRICKSTER("Trickster"),
    DREADNOUGHT("Dreadnought");

    private final String displayName;

    PlayerClass(String displayName) {
        this.displayName = displayName;
    }
}
