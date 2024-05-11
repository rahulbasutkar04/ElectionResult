package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.electionResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryElectionResultRepositoryTest {
    private electionResultRepository repository;

    @BeforeEach
    public void setUp() {
        repository = InMemoryElectionResultRepository.getInstance();
        repository.clear();
    }

    @Test
    public void shouldBeAbleToTestConstituencyResult() {
        HashMap<String, HashMap<String, Integer>> testData = new HashMap<>();
        HashMap<String, Integer> cityData = new HashMap<>();
        cityData.put("BJP", 10000);
        cityData.put("INC", 15000);
        testData.put("Bangalore", cityData);

        repository.ConstituencyResult(testData);

        HashMap<String, HashMap<String, Integer>> resultData = repository.getWinnerData();
        assertEquals(testData, resultData, "Inserted and retrieved data should match");
    }

    @Test
    public void shouldBeAbleToTestGetWinnerData() {
        HashMap<String, HashMap<String, Integer>> testData = new HashMap<>();
        HashMap<String, Integer> cityData = new HashMap<>();
        cityData.put("BJP", 10000);
        cityData.put("INC", 15000);
        testData.put("Bangalore", cityData);

        repository.ConstituencyResult(testData);

        HashMap<String, HashMap<String, Integer>> resultData = repository.getWinnerData();
        assertEquals(testData, resultData, "Inserted and retrieved data should match");
    }

}