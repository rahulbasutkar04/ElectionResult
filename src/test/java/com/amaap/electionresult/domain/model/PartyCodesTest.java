package com.amaap.electionresult.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PartyCodesTest {

    @Test
    public void shouldBeAbleToGetFullNameForINC() {
        // act & assert
        String fullName = PartyCodes.getFullName("INC");
        assertEquals("Indian National Congress", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForCPI() {
        // act & assert
        String fullName = PartyCodes.getFullName("CPI");
        assertEquals("Communist Party of India", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForBJP() {
        // act & assert
        String fullName = PartyCodes.getFullName("BJP");
        assertEquals("Bhartiya Janta Party", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForNCP() {
        // act & assert
        String fullName = PartyCodes.getFullName("NCP");
        assertEquals("Nationalist Congress Party", fullName);
    }

    @Test
    public void shouldBeAbleToGetFullNameForBSP() {
        // act & assert
        String fullName = PartyCodes.getFullName("BSP");
        assertEquals("Bahujan Samaj Party", fullName);
    }

    @Test
    public void shouldBeAbleToThrowExceptionForInvalidPartyCode() {
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            PartyCodes.getFullName("XYZ");
        });
    }
}