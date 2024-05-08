package com.amaap.electionresult;

import com.amaap.electionresult.controller.FileController;
import com.amaap.electionresult.controller.dto.Http;
import com.amaap.electionresult.controller.dto.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileControllerTest {

    @Test
    void shouldBeAbleToRespondWithOkMessageIfFileISTakenFromUser()
    {
        // arrange
        FileController fileController =new FileController();
        Response expected=new Response(Http.OK, Http.OK.getMessage());
        String path="";

        // act
          Response actual=fileController.getFile(path);

        // assert
        assertEquals(expected,actual);
    }
}
