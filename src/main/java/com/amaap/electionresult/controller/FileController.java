package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.io.FileReaderService;

public class FileController {
    FileReaderService fileReaderService;

    public FileController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public Response readFile(String path){


        try {
            if (fileReaderService.readFile(path)) return new Response(HttpStatus.OK, HttpStatus.OK.getMessage());

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new Response(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getMessage());

    }
}
