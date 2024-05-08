# Election Result Processing

## Problem Description

The task is to process election result data provided in a file format, analyze the results, and determine the winners for each city constituency. The input file contains data including the city name, party code, and the number of votes cast for each party.

## Components

### Controller

- **FileController**: Accepts input file from the user.
- **ElectionController**: Processes election data to calculate winners and saves results.

### Outer Service

- **FileRead**: Handles file-related operations and configurations.
- **Parsing**: Parses and validates input data, then saves it into the repository.
- **ResultCalculator**: Calculates winners and stores results using inner service.

### Domain Model

- **PartyFullName**: Represents the full name of parties, utilizing configuration files.
  
### Inner Service

- **VoteCalculator**: Analyzes city-wise winners and stores results in the repository.

### Repository

- **ElectionDataRepository**: Stores raw election data in a structured format.
- **ResultDataRepository**: Stores winners' data including city names, party full names, vote counts, and percentages.

## Configuration Files

1. **CityName**: Contains configurations for city names.
2. **PartyCodes**: Contains configurations for party codes and their corresponding full names.

## Workflow

1. **File Processing**: The FileController accepts the input file and hands it over to the Outer Service layer.
2. **Parsing and Validation**: The Parsing service reads and validates the input data, saving it into the ElectionDataRepository.
3. **Winner Calculation**: The ResultCalculator service calculates winners for each city using the VoteCalculator.
4. **Data Storage**: Election results, including winners' data, are stored in the ResultDataRepository.

## Output

The output consists of city names along with the full names of parties and their respective vote counts.
