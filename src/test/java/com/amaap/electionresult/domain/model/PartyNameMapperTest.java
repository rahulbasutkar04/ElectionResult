package com.amaap.electionresult.domain.model;

import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PartyNameMapperTest {

    private PartyNameMapper partyNameMapper;

    @BeforeEach
    void setUp() {
        partyNameMapper = new PartyNameMapper();
    }

    @Test
    void shouldBeAbleToGetTheCorrectPartyFullName() throws ElectionResultException {
        // arrange
        String partyCode = "BJP";
        String expectedFullName = "Bhartiya Janta Party";

        // act
        String actualFullName = partyNameMapper.getPartyFullName(partyCode);

        // assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void shouldThrowExceptionIfInvalidPartyCodeIsGiven() {
        // arrange
        String invalidPartyCode = "XYZ";

        // act & assert
        assertThrows(InvalidPartyCodeException.class, () -> {
            partyNameMapper.getPartyFullName(invalidPartyCode);
        });
    }


}