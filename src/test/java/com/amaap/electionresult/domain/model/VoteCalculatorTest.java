import com.amaap.electionresult.domain.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.domain.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.domain.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.domain.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;
import com.amaap.electionresult.io.datafilereader.DataProcessor;
import com.amaap.electionresult.domain.models.VoteCalculator;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoteCalculatorTest {

    @Test
    void shouldAbleToGetThePartyNameWithHigherVoteWithCityName() throws  NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {
        // Arrange
        DataExtractor dataExtractor = new DataExtractor();
        dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // Act
        VoteCalculator voteCalculator = new VoteCalculator();
        Map<String, Map<String, Integer>> actual = voteCalculator.getPartyNameWithMaxVote(DataProcessor.getResultMap());

        // Define expected result for Banglore
        Map<String, Integer> bangaloreExpected = new HashMap<>();
        bangaloreExpected.put("BJP", 50);
        Map<String, Integer> puneExpected = new HashMap<>();
        puneExpected.put("INC", 90);
        Map<String, Integer> kolkataExpected = new HashMap<>();
        kolkataExpected.put("BJP", 1020);

        Map<String, Map<String, Integer>> expected = new HashMap<>();
        expected.put("Banglore", bangaloreExpected);
        expected.put("Pune", puneExpected);
        expected.put("Kolkata", kolkataExpected);

        System.out.println(expected);
        System.out.println(actual);
        System.out.println(VoteCalculator.getWinnersData());
        // Assert
        assertEquals(expected, actual);//will check city name of party who has more number of votes

    }
}
