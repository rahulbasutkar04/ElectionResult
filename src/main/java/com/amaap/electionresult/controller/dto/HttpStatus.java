package com.amaap.electionresult.controller.dto;

public enum HttpStatus {
    OK("File Uploaded Successfully.."),
    BAD_REQUEST("File Cannot Be Uploaded..");

    private final String message;

    HttpStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
