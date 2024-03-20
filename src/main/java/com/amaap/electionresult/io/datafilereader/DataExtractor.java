package com.amaap.electionresult.io.datafilereader;

import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;

import java.io.File;
import java.io.FileNotFoundException;

public class DataExtractor {


    public boolean readFile(String path) throws IllegalFileFormatException, NoDataFoundInFileException, FileNotFoundException, IllegalPartyNameException, EmptyFilepathException {

        if (path.isEmpty()) {
            throw new EmptyFilepathException("Path not found  / provide path");
        }
        if (!path.toLowerCase().endsWith(".txt")) {
            throw new IllegalFileFormatException("Invalid file format. Please provide a .txt file.");
        }


        File file = new File(path);

        if (file.length() == 0) {
            throw new NoDataFoundInFileException();
        }


        //if above condition fails that means we can do process  with file


        return DataProcessor.processor(path); // Placeholder return statement
    }


}
