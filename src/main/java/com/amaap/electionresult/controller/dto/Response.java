package com.amaap.electionresult.controller.dto;

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


// should check if the path contains the file or not
// shoudl check if file has data or not
// should check if it contains extra spaces

// structural validations are done here
// then it then if extra space forun it it romoves that spces(trim) and then paesses easch line of data to the parser
// parser does the data validation such as if it contains the format like city name ,party code ,and number which is vote
// after doing that it will check whethee the name of city is presnt in cnfiguration also check party code preent in configuration file and also check if the vote count is not negative..
// then after parsing if data is right it will store into repository for further process..
//then it will retun true only if parser returns true other wose false..if parser retrunr true that means all data is right and added to repostiryu
