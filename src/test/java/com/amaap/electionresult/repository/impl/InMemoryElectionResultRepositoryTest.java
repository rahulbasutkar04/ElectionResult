package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.ElectionResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryElectionResultRepositoryTest {
    private ElectionResultRepository repository;

    @BeforeEach
    public void setUp() {
        repository = InMemoryElectionResultRepository.getInstance();
        repository.clear();
    }

    @Test
    public void shouldBeAbleToTestConstituencyResult() {
        // arrange
        HashMap<String, HashMap<String, Integer>> testData = new HashMap<>();
        HashMap<String, Integer> cityData = new HashMap<>();
        cityData.put("BJP", 10000);
        cityData.put("INC", 15000);
        testData.put("Bangalore", cityData);
        repository.ConstituencyResult(testData);

        // act
        HashMap<String, HashMap<String, Integer>> resultData = repository.getWinnerData();

        // assert
        assertEquals(testData, resultData, "Inserted and retrieved data should match");
    }

    @Test
    public void shouldBeAbleToTestGetWinnerData() {
        // arrange
        HashMap<String, HashMap<String, Integer>> testData = new HashMap<>();
        HashMap<String, Integer> cityData = new HashMap<>();
        cityData.put("BJP", 10000);
        cityData.put("INC", 15000);
        testData.put("Bangalore", cityData);
        repository.ConstituencyResult(testData);

        // act
        HashMap<String, HashMap<String, Integer>> resultData = repository.getWinnerData();

        // assert
        assertEquals(testData, resultData, "Inserted and retrieved data should match");
    }

}