package com.amaap.electionresult.models;

import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;

import java.io.FileNotFoundException;

public class ElectionManager {
    public boolean readFile(String filepath) throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {
        DataExtractor dataExtractor=new DataExtractor();
        return dataExtractor.readFile(filepath);
    }
}
