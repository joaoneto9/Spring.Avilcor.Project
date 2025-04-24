package com.avilcor.campina.grande.Spring.Avilcor.Project.enums;

public enum Trabalho {
    BORDADO(1),
    BARRA(2),
    COSTURA(3);

    private int code;

    private Trabalho(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Trabalho valueOf(int code) {
        for (Trabalho value : Trabalho.values()) {
           if (value.getCode() == code)
                return value;
        }

        throw new IllegalArgumentException("codigo invalido");
    }

}
