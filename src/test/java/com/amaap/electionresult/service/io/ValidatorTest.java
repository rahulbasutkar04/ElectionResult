package com.amaap.electionresult.service.io;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator=new Validator();

    @Test
    void shouldBeAbleToReturnTrueForValidInputLine() {
        String line = "Bangalore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertTrue(validator.isValidFormat(line));
    }

    @Test
    void ShouldReturnFalseWhenMissingCommaAfterPartyCodeAndVotes() {
        String line = "Pune 11014 BJP 17803 INC 4923 CPI 2069 NCP";
        assertFalse(validator.isValidFormat(line));
    }

    @Test
    void ShouldReturnFalseWhenNoPartyCodeAndVotesPresentInLine() {
        String line = "Chennai";
        assertFalse(validator.isValidFormat(line));
    }

    @Test
    void shouldReturnFalseWhenNegativeVotesArePresentInTheLine() {
        String line = "Kolkata, -11014, BJP, -17803, INC";
        assertFalse(validator.isValidFormat(line));
    }

    @Test
    void ShouldReturnTrueIfLineFollwsTheStructuralPatternOfValidLine() {
        String line = "Hyderabad, 11014, XYZ, 17803, INC";
        assertTrue(validator.isValidFormat(line));
    }

    @Test
    void shouldBeAbleToReturnTrueIfLineHasValidCityNamesFromTheConfigurationFile(){
        assertTrue(validator.hasValidCityNames("Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP"));
    }

    @Test
    void shouldBeAbleToReturnTrueIfLineHasAnotherValidCityNamesFromTheConfigurationFile()  {
        assertTrue(validator.hasValidCityNames("Mumbai, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP"));
    }

    @Test
    void shouldBeAbleToReturnFalseIfLineHasInValidCityNameWhichIsNotInConfigurationFile()  {
        assertFalse(validator.hasValidCityNames("Solapur, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP"));
    }


    @Test
    void shouldBeAbleToTestLoadValidCityNames() {

        // act
        Set<String> cityNames = validator.loadValidCityNames("/validCityNames.yaml");

        // assert
        assertEquals(3, cityNames.size());
        for (String cityName : cityNames) {
            System.out.println(cityName);
        }
    }


    @Test
    void shouldBeAbleToCheckValidPartyCodesWhichIsInTheConfigurationFile() {
        // arrange
        String line = "Bangalore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";

        // act
        boolean result = validator.containsOnlyValidPartyCodes(line);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToCheckIfGivenLineHasValidPartyCodeOrNot() {
        // arrange
        String line = "Bangalore, 11014, BJP, 17803, INVALID, 4923, CPI, 2069, NCP";

        // act
        boolean result = validator.containsOnlyValidPartyCodes(line);

        // assert
        assertFalse(result);
    }
    @Test
    void  shouldBeAbleToReturnFalseIfLineDonNotHavePartyCodeAsItsPlace() {
        // arrange
        String line = "Bangalore, 11014, BJP, 17803, , 4923, CPI, 2069, NCP";

        // act
        boolean result = validator.containsOnlyValidPartyCodes(line);

        // assert
        assertFalse(result);
    }



}