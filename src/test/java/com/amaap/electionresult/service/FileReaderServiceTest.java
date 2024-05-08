package com.amaap.electionresult.service;

import com.amaap.electionresult.service.exception.InvalidFilePathException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderServiceTest {
    @Test
    void shouldThrowExceptionIfGivenPathISNullOrEmpty()
    {
        // arrange
        FileReaderService fileReaderService=new FileReaderService();
        String path="";

        // act & assert
       assertThrows(InvalidFilePathException.class,()->{
           fileReaderService.readFile(path);
       });

    }

}