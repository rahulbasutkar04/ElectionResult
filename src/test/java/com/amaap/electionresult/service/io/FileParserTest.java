package com.amaap.electionresult.service.io;

import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.exception.InvalidCityNameException;
import com.amaap.electionresult.service.exception.InvalidFormatException;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileParserTest {
    private static FileParser fileParser;

    @BeforeAll
    static void setUp() {
        fileParser = new FileParser();
    }

    @Test
    void shouldBeAbleToTestValidInputLine() throws ElectionResultException {
        String line = "Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertTrue(fileParser.parser(line));
    }

    @Test
    void shouldThrowExceptionIfInvalidFormatInputLine() {
        String line = "Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP,";
        assertThrows(InvalidFormatException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldThrowExceptionIfLineContainsInvalidCityName() {
        String line = "Delhi, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertThrows(InvalidCityNameException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldBeAbleToTestValidCityName() throws ElectionResultException {
        String line = "Pune, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND";
        assertTrue(fileParser.parser(line));
    }

    @Test
    void shouldThrowExceptionIfLineContainsInvalidCityNameMixedCase() {
        String line = "banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertThrows(InvalidCityNameException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldThrowExceptionIfLineContainsInvalidCityNameExtraSpaces() {
        String line = "   Pune, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND";
        assertThrows(InvalidFormatException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldThrowExceptionIfLineContainsInvalidFormatCityNameNoComma() {
        String line = "Mumbai 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertThrows(InvalidFormatException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldThrowExceptionIfLineContainsSpecialCharacters() {
        String line = "Mumbai @#*#*#";
        assertThrows(InvalidFormatException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldThrowExceptionIfLineDonNotHavePartyCodeAsItsPlace() {
        // arrange
        String line = "Banglore, 11014, BJP, 17803, INVALID, 4923, CPI, 2069, NCP";

        // act
        assertThrows(InvalidPartyCodeException.class, () -> {
            fileParser.parser(line);
        });
    }

    @Test
    void shouldBeAbleToReturnTrueIfLineContainsTheValidPartCode() throws ElectionResultException {
        String line = "Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertTrue(fileParser.parser(line));
    }


}
