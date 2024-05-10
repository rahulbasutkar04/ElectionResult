# Election Result Processing

## Problem Description

The task is to process election result data provided in a file format, analyze the results, and determine the winners for each city constituency. The input file contains data including the city name, party code, and the number of votes cast for each party.


### Controller
- **FileController**: Accepts input file from the user.
   Behaviour:readFile(String filepath)
- **ElectionController**: Processes election data to calculate winners and saves results.
    Behaviour:getWinner()

### Outer Service

- **FileReaderService**: readfile(String filePath)
- **ElectionService**: getWinner()

### Domain Model

- **PartyNameMapper**:getPartyFullName(String partyCode)


### Inner Service
- **ElectionResultAnalyser**: void analyseWinner()
- **DataExtractor**:ExtractData(List<String>)
- **VoteCalculator**: calculateVotes(Map<Map<Integer,String>>)
- **ResultAnnouncer**:displayWinner()



### Repository
- **ElectionDataRepository**: Stores raw election data in a structured format.
- **ElectionResultRepository**: Stores winners' data including city names, party full names, vote counts.

## Configuration Files
1. **ValidCityName**: Contains configurations for city names.
2. **ValidPartyCodes**: Contains configurations for party codes and their corresponding full names.


## Workflow

1. **File Processing**: The FileController accepts the input file and hands it over to the Outer Service layer.
2. **Parsing and Validation**: The Parsing service reads and validates the input data, saving it into the ElectionDataRepository.
3. **Winner Calculation**: The ResultCalculator service calculates winners for each city using the VoteCalculator.
4. **Data Storage**: Election results, including winners' data, are stored in the ResultDataRepository.



## Output
The output consists of city names along with the full names of parties and their respective vote counts.

![img.png](img.png)
