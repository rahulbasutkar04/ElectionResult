package com.amaap.electionresult;

public enum Http {
    OK("File Uploaded Successfully.."),
    BAD_REQUEST("File Cannot Be Uploaded..");

    private final String message;

    Http(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
