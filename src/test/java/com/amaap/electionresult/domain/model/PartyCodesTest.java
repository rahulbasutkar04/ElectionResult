package com.amaap.electionresult.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyCodesTest {


    @Test
    public void shouldBeAbleToGetFullNameForINC() {
        String fullName = PartyCodes.getFullName("INC");
        assertEquals("Indian National Congress", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForCPI() {
        String fullName = PartyCodes.getFullName("CPI");
        assertEquals("Communist Party of India", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForBJP() {
        String fullName = PartyCodes.getFullName("BJP");
        assertEquals("Bhartiya Janta Party", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForNCP() {
        String fullName = PartyCodes.getFullName("NCP");
        assertEquals("Nationalist Congress Party", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForBSP() {
        String fullName = PartyCodes.getFullName("BSP");
        assertEquals("Bahujan Samaj Party", fullName);
    }

    @Test
    public void shouldBeAbleToThrowExceptionForInvalidPartyCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            PartyCodes.getFullName("XYZ");
        });
    }

}