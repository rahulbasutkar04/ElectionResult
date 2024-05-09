package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.Http;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.FileReaderService;

public class FileController {
    FileReaderService fileReaderService;

    public FileController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public Response getFile(String path) {

        try {
            if (fileReaderService.readFile(path)) return new Response(Http.OK, Http.OK.getMessage());
        } catch (Exception e) {
            return new Response(Http.BAD_REQUEST, Http.BAD_REQUEST.getMessage());
        }
        return new Response(Http.BAD_REQUEST, Http.BAD_REQUEST.getMessage());


    }
}
