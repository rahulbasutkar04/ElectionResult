
import com.amaap.electionresult.io.datafilereader.DataExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataExtractorTest {

    @Test
    void shouldAbleToReadFileFromTheUser()
    {
        //Arrange
        DataExtractor dataExctractor=new DataExtractor();

        //Assert
        boolean isFileRaid=dataExctractor.readFile();

        //Act

        assertTrue(isFileRaid);

    }
}
