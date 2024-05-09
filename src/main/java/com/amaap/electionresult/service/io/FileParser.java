package com.amaap.electionresult.service.io;

public class FileParser {

    Validator validator = new Validator();

    public boolean parser(String line) {

        if (!(validator.isValidFormat(line))) return false;
        if (!(validator.hasValidCityNames(line))) return false;

        return true;
    }


}
