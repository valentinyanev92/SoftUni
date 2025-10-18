package main.model;

import lombok.Getter;

@Getter
public enum MobType {

    COMMON("Common"),
    BLUE_CHAMPION("Blue Champion"),
    RED_CHAMPION("Red Champion");

    private final String displayName;

    MobType(String displayName) {
        this.displayName = displayName;
    }
}
