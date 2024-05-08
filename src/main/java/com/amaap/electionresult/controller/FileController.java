package com.amaap.electionresult;

import com.amaap.electionresult.service.FileReaderService;

public class FileController {
    FileReaderService fileReaderService;

    public FileController(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public Response getFile(String path) {
        if(fileReaderService.readFile(path)) return  new Response(Http.OK,Http.OK.getMessage());

        return new Response(Http.BAD_REQUEST,Http.BAD_REQUEST.getMessage());
    }
}
