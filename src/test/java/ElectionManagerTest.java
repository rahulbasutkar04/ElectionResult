import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;
import com.amaap.electionresult.models.ElectionManager;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectionManagerTest {

    @Test
    void shouldAbleToTakeFileInputFromUser() throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {

        ElectionManager electionManager=new ElectionManager();
        boolean actual=electionManager.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        assertTrue(actual);
    }
}
