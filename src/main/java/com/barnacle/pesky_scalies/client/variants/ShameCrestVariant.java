package com.barnacle.pesky_scalies.client.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ShameCrestVariant {

    COMMON(0),
    GIGGLE(1),
    ZEB(2);

    private static final ShameCrestVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(ShameCrestVariant::getId)).toArray(ShameCrestVariant[]::new);
    private final int id;

    ShameCrestVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ShameCrestVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
