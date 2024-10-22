package com.shridhar.model;

import lombok.Getter;

@Getter
public enum Residence {
    OWN_UNENCUMBERED("Own (Unencumbered)"),
    OWN_ENCUMBERED("Own (Encumbered)"),
    COMPANY_PROVIDED("Company provided"),
    LEASED_RENTED("Leased/Rented");

    private final String description;

    Residence(String description) {
        this.description = description;
    }
}

