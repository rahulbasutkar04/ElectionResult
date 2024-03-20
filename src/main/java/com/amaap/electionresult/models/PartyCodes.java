package com.amaap.electionresult.models;

public enum PartyCodes {
    INC("Indian National Congress"),
    CPI("Communist Party of India"),
    BJP("Bhartiya Janta Party"),
    NCP("Nationalist Congress Party"),
    BSP("Bahujan Samaj Party");

    private final String fullName;

    // Constructor
    PartyCodes(String fullName) {
        this.fullName = fullName;
    }

    // Method to get the full name based on the party code
    public static String getFullName(String code) {
        for (PartyCodes party : PartyCodes.values()) {
            if (party.name().equals(code)) {
                return party.fullName;
            }
        }
        return null; // Return null if party code not found
    }
}
