package com.amaap.electionresult.domain;

import com.amaap.electionresult.domain.service.DataExtractor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataExtractorTest {


    @Test
    public void shouldBeAbleToTestExtractData() {

        // arrange
        DataExtractor dataExtractor = DataExtractor.getInstance();
        String input = "Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP;" +
                "Pune, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309";
        HashMap<String, HashMap<String, Integer>> expectedOutput = new HashMap<>();
        HashMap<String, Integer> bangloreVotes = new HashMap<>();
        bangloreVotes.put("BJP", 11014);
        bangloreVotes.put("INC", 17803);
        bangloreVotes.put("CPI", 4923);
        bangloreVotes.put("NCP", 2069);
        HashMap<String, Integer> puneVotes = new HashMap<>();
        puneVotes.put("CPI", 9389);
        puneVotes.put("BJP", 4829);
        puneVotes.put("NCP", 3375);
        puneVotes.put("BSP", 3371);

        expectedOutput.put("Banglore", bangloreVotes);
        expectedOutput.put("Pune", puneVotes);

        // act
        HashMap<String, HashMap<String, Integer>> actualOutput = dataExtractor.ExtractData(input);

        // assert
        assertEquals(expectedOutput.size(), actualOutput.size(), "Number of cities should match");

        for (String city : expectedOutput.keySet()) {
            assertTrue(actualOutput.containsKey(city), "Expected city not found in actual output");
            assertEquals(expectedOutput.get(city), actualOutput.get(city), "Votes for each party should match");
        }
    }
}

