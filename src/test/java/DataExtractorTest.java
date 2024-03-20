
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataExtractorTest {

    @Test
    void shouldAbleToReadFileFromTheUser() throws IllegalFileFormatException {
        //Arrange
        DataExtractor dataExtractor=new DataExtractor();

        //Act
        boolean isFileRaid=dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        //Assert
        assertTrue(isFileRaid);

    }

    @Test

    void shouldAbleToTakeOnlyTextFileAsInput(){
        //Arrange
        DataExtractor dataExtractor=new DataExtractor();

        // Act and Assert
        assertThrows(IllegalFileFormatException.class, () -> {
            dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.pdf");
        });


    }

}
