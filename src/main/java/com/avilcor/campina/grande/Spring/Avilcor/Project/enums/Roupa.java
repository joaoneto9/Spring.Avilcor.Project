package com.avilcor.campina.grande.Spring.Avilcor.Project.enums;

public enum Roupa {
    CALCA(1),
    CAMISA(2),
    TERNO(3),
    SHORT(4),
    BONE(5),
    TENIS(6);

    private int code;

    private Roupa(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Roupa valueOf(int code) {
        for (Roupa value : Roupa.values()) {
            if (value.getCode() == code)
                return value;
        }

        throw new IllegalArgumentException("codigo invalido");
    }
}
