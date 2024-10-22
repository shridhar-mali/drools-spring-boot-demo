package com.shridhar.model;

import lombok.Getter;

@Getter
public enum AssetSubType {
    LUXURY("More than 1500 sq. ft."),
    SEDAN("Up to 1000 sq. ft."),
    ECONOMY("Less than 1000 sq. ft.");

    private final String description;

    AssetSubType(String description) {
        this.description = description;
    }
}
