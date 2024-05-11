package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
import com.amaap.electionresult.service.exception.ElectionResultException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ElectionServiceTest {
    @Test
    void shouldBeAbleToTestGetWinners() throws ElectionResultException {

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

    @Test
    void shouldBeAbleToTestGetWinnersWhenAnalyseWinnerReturnsFalse() throws ElectionResultException {
        // arrange
        ElectionResultAnalyser mockAnalyser = mock(ElectionResultAnalyser.class);
        ElectionService electionService = new ElectionService(mockAnalyser);
        boolean expectedResult = false;

        // act
        when(mockAnalyser.analyseWinner()).thenReturn(expectedResult);
        boolean actualResult = electionService.getWinners();
        verify(mockAnalyser).analyseWinner();

        // assert
        assertEquals(expectedResult, actualResult);
    }

}