package com.amaap.electionresult.domain;

import com.amaap.electionresult.domain.service.VoteCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class VoteCalculatorTest {

    @Test
    void shouldBeAbleToTestCalculateVotes() {

        // arrange
        HashMap<String, HashMap<String, Integer>> testData = new HashMap<>();
        HashMap<String, Integer> city1Data = new HashMap<>();
        city1Data.put("BJP", 10000);
        city1Data.put("INC", 15000);
        testData.put("City1", city1Data);

        HashMap<String, Integer> city2Data = new HashMap<>();
        city2Data.put("CPI", 20000);
        city2Data.put("NCP", 18000);
        testData.put("City2", city2Data);

        HashMap<String, HashMap<String, Integer>> expectedOutput = new HashMap<>();
        HashMap<String, Integer> city1Winner = new HashMap<>();
        city1Winner.put("INC", 15000);
        expectedOutput.put("City1", city1Winner);

        HashMap<String, Integer> city2Winner = new HashMap<>();
        city2Winner.put("CPI", 20000);
        expectedOutput.put("City2", city2Winner);

        // act
        HashMap<String, HashMap<String, Integer>> result = VoteCalculator.calculateVotes(testData);

        // assert
        assertEquals(expectedOutput, result, "Winner calculation should be correct");
    }

}