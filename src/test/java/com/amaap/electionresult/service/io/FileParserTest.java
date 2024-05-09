package com.amaap.electionresult.service.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    private static FileParser fileParser;

    @BeforeAll
    static void setUp() {
        fileParser = new FileParser();
    }

    @Test
    void shouldBeAbleToTestValidInputLine() {
        String line = "Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertTrue(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleToTestInvalidFormatInputLine() {
        String line = "Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP,";
        assertFalse(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleToTestInvalidCityName() {
        String line = "Delhi, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertFalse(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleToTestValidCityName() {
        String line = "Pune, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND";
        assertTrue(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleToTestInvalidCityNameMixedCase() {
        String line = "banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertFalse(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleToTestInvalidCityNameExtraSpaces() {
        String line = "   Pune, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND";
        assertFalse(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleToTestInvalidCityNameNoComma() {
        String line = "Mumbai 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP";
        assertFalse(fileParser.parser(line));
    }

    @Test
    void shouldBeAbleTOReturnFalseIfLineContainsSpecialCharacters()
    {
        String line="Mumbai @#*#*#";
        assertFalse(fileParser.parser(line));
    }



}
