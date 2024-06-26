
import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;
import com.amaap.electionresult.io.datafilereader.DataProcessor;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataExtractorTest {

    @Test
    void shouldAbleToReadFileFromTheUser() throws IllegalFileFormatException, NoDataFoundInFileException, FileNotFoundException, IllegalPartyNameException, EmptyFilepathException {
        //Arrange
        DataExtractor dataExtractor=new DataExtractor();
        DataProcessor d=new DataProcessor();

        //Act
        boolean isFileRaid=dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        //Assert
        assertTrue(isFileRaid);


        System.out.println(d.getResultMap());//to print and check the data

    }

    @Test
    void shouldThrowExceptionIfPathIsEmpty() throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {
        DataExtractor dataExtractor=new DataExtractor();
        assertThrows(EmptyFilepathException.class,()->{
            dataExtractor.readFile("");
        });

    }

    @Test
    void shouldAbleToTakeOnlyTextFileAsInputIfNotThrowException(){
        //Arrange
        DataExtractor dataExtractor=new DataExtractor();

        // Act and Assert
        assertThrows(IllegalFileFormatException.class, () -> {
            dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.pdf");
        });


    }

    @Test
    void shouldAbleToThrowExceptionIfNoDataFoundInFile()
    {
        //Arrange
        DataExtractor dataExtractor=new DataExtractor();
        //Act and Assert

        assertThrows(NoDataFoundInFileException.class,()->{
           dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo1.txt");
        });

    }


}
