package com.amaap.electionresult.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryElectionRepositoryDataTest {

    private InMemoryElectionRepositoryData electionRepository;

    @BeforeEach
    void setUp() {
        electionRepository = InMemoryElectionRepositoryData.getInstance();
        electionRepository.clear();
    }

    @Test
    void shouldBeAbleToTestGetInstance() {
        assertNotNull(electionRepository);
    }

    @Test
    void shouldBeAbleToTestSingletonBehavior() {
        InMemoryElectionRepositoryData anotherInstance = InMemoryElectionRepositoryData.getInstance();
        assertSame(electionRepository, anotherInstance);
    }

    @Test
    void shouldBeAbleToTestInsertAndRetrieveData() {
        // arrange
        String testData = "Test Data";

        // act
        electionRepository.inertIntoElectionData(testData);

        // assert
        assertEquals(1, electionRepository.getElectionData().size());
        assertEquals(testData, electionRepository.getElectionData().get(0));
    }

    @Test
    void shouldBeAbleToTestClear() {
        // arrange
        electionRepository.inertIntoElectionData("Data 1");
        electionRepository.inertIntoElectionData("Data 2");

        // act
        electionRepository.clear();

        // assert
        assertEquals(0, electionRepository.getElectionData().size());
    }

    @Test
    void shouldBeAbleToTestNullDataInsertion() {
        assertDoesNotThrow(() -> electionRepository.inertIntoElectionData(null));
    }

}