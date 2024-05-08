package com.amaap.electionresult;

public class FileController {
    public Response getFile(String path) {

        return  new Response(Http.OK,Http.OK.getMessage());
    }
}
