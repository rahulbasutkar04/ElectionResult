package com.amaap.electionresult;

import java.util.Objects;

public class Response{
    private final Http status;
    private final String message;

    public Response(Http status, String message) {
        this.status = status;
        this.message = message;
    }

    public Http getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Response response = (Response) obj;
        return status == response.status && message.equals(response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }
}
