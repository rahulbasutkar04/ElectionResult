package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ElectionServiceTest {
    @Test
    void testGetWinners() throws InvalidPartyCodeException {

        // arrange
        ElectionResultAnalyser mockAnalyser = mock(ElectionResultAnalyser.class);
        ElectionService electionService = new ElectionService(mockAnalyser);
        boolean expectedResult = true;

        // act
        when(mockAnalyser.analyseWinner()).thenReturn(expectedResult);
        boolean actualResult = electionService.getWinners();
        verify(mockAnalyser).analyseWinner();

        // assert
        assertEquals(expectedResult, actualResult);
    }

}