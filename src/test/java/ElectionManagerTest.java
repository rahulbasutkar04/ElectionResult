import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataProcessor;
import com.amaap.electionresult.models.ElectionManager;
import com.amaap.electionresult.models.VoteCalculator;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectionManagerTest {

    @Test
    void shouldAbleToTakeFileInputFromUser() throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {
        // Arrange
        ElectionManager electionManager = new ElectionManager();

        // Act
        boolean actual = electionManager.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldAbleToProcessTheDataInWellFormat() throws FileNotFoundException, IllegalPartyNameException {
        // Arrange
        ElectionManager electionManager = new ElectionManager();

        // Act
        boolean actual = electionManager.processData("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldAbleToCalculateVote() throws FileNotFoundException, IllegalPartyNameException {
        // Arrange
        ElectionManager electionManager = new ElectionManager();
        electionManager.processData("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // Act
        boolean actual = electionManager.calculateVote(DataProcessor.getResultMap());

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldAbleToDisplayResult() throws FileNotFoundException, IllegalPartyNameException {
        // Arrange
        ElectionManager electionManager = new ElectionManager();
        electionManager.processData("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");
        electionManager.calculateVote(DataProcessor.getResultMap());

        // Act: Display the result
        electionManager.displayWinner(VoteCalculator.getWinnersData());
    }
}
