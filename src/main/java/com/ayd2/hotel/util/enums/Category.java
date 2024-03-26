package com.ayd2.hotel.util.enums;

public enum Category {

    TYPE_OF_FOOD(500L),
        FOOD(501L),
        DRINK(502L);

    public final Long internalId;

    Category(Long internalId) {
        this.internalId = internalId;
    }
}
