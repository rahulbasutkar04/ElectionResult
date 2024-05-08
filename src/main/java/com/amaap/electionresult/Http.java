package com.amaap.electionresult;

public enum Http {

    OK("File Uploaded Successfully..");

    private final String message;

    Http(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
