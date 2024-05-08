package com.amaap.electionresult;

import com.amaap.electionresult.service.FileReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileControllerTest {

    FileReaderService fileReaderService;
    @BeforeEach
    void setup()
    {
        fileReaderService=new FileReaderService();
    }
    @Test
    void shouldBeAbleToRespondWithOkMessageIfFileISTakenFromUser()
    {
        // arrange
        FileController fileController =new FileController(fileReaderService);
        Response expected=new Response(Http.OK, Http.OK.getMessage());
        String path="";

        // act
          Response actual=fileController.getFile(path);

        // assert
        assertEquals(expected,actual);
    }
}
