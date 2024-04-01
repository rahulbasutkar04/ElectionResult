package com.amaap.electionresult.models;

public enum PartyCodes {
    INC("Indian National Congress"),
    CPI("Communist Party of India"),
    BJP("Bhartiya Janta Party"),
    NCP("Nationalist Congress Party"),
    BSP("Bahujan Samaj Party");

    private final String fullName;

    PartyCodes(String fullName) {
        this.fullName = fullName;
    }

    public static String getFullName(String code) {
        for (PartyCodes party : PartyCodes.values()) {
            if (party.name().equals(code)) {
                return party.fullName;
            }
        }
        throw new IllegalArgumentException("Invalid party code: " + code);
    }

}
