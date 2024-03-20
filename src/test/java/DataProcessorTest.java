import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.io.datafilereader.DataProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    @Test

    void shouldAbleToThrowExceptionIfOtherThanAvailablePartyNameFoundWhileProcessingData()
    {
        //Arrange
        DataProcessor dataProcessor=new DataProcessor();
        //Act and Assert
        assertThrows(IllegalPartyNameException.class,()->{
            dataProcessor.processor("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo2.txt");
        });

    }


}