package com.amaap.electionresult.domain.datafilereader;

import com.amaap.electionresult.domain.exception.IllegalPartyNameException;
import com.amaap.electionresult.domain.datafilereader.DataProcessor;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    @Test

    void shouldAbleToThrowExceptionIfOtherThanAvailablePartyNameFoundWhileProcessingData()
    {
        //Arrange
        DataProcessor dataProcessor=new DataProcessor();
        //Act and Assert
        assertThrows(IllegalPartyNameException.class,()->{
            dataProcessor.processor("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo2.txt");
        });

    }

    @Test
    void shoudlAbleToReturnTrueIfProcessedDataIsAddedToTheList() throws FileNotFoundException, IllegalPartyNameException {
        DataProcessor dataProcessor=new DataProcessor();

        boolean actual=dataProcessor.processor("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        System.out.println(dataProcessor.getResultMap());
        assertTrue(actual);
    }


}