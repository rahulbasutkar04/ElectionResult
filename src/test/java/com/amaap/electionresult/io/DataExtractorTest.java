package com.amaap.electionresult.io;

import com.amaap.electionresult.io.exception.EmptyFilepathException;
import com.amaap.electionresult.io.exception.IllegalFileFormatException;
import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import com.amaap.electionresult.io.exception.NoDataFoundInFileException;
import com.amaap.electionresult.io.DataExtractor;
import com.amaap.electionresult.io.Parser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataExtractorTest {

    @Test
    void shouldAbleToReadFileFromTheUserAndParseIt() throws IllegalFileFormatException, NoDataFoundInFileException, IOException, IllegalPartyNameException, EmptyFilepathException {
        // arrange
        DataExtractor dataExtractor=new DataExtractor();
        Parser d=new Parser();

        // act
        boolean isFileRaid=dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // assert
        assertTrue(isFileRaid);


        System.out.println(d.getResultMap());

    }

    @Test
    void shouldThrowExceptionIfPathIsEmpty() {
        DataExtractor dataExtractor=new DataExtractor();
        assertThrows(EmptyFilepathException.class,()->{
            dataExtractor.readFile("");
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionWhenOtherThanTextFilesIsGiven(){
        // arrange
        DataExtractor dataExtractor=new DataExtractor();

        // act and assert
        assertThrows(IllegalFileFormatException.class, () -> {
            dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.pdf");
        });


    }

    @Test
    void shouldAbleToThrowExceptionIfNoDataFoundInFile()
    {
        // arrange
        DataExtractor dataExtractor=new DataExtractor();

        // act &  assert
        assertThrows(NoDataFoundInFileException.class,()->{
           dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo1.txt");
        });

    }


}
