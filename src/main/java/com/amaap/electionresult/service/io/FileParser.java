package com.amaap.electionresult.service.io;

import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.exception.InvalidCityNameException;
import com.amaap.electionresult.service.exception.InvalidFormatException;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;

public class FileParser {

    Validator validator = new Validator();

    public boolean parser(String line) throws ElectionResultException {

        if (!(validator.isValidFormat(line))) throw new InvalidFormatException("InValid Format Of Line:"+line);
        if (!(validator.hasValidCityNames(line))) throw  new InvalidCityNameException("Invalid City Name Found:"+line);
        if(!(validator.containsOnlyValidPartyCodes(line))) throw new InvalidPartyCodeException("Invalid Party Code Found:"+line);
        return true;
    }


}
