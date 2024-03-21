# OOMD for Election Result Management

## Classes:

### DataExtractor (Public)
#### States:
- `fileReader`: File -> Used for file traversal and handling.
- `parsed`: boolean -> Checks if the file is parsed or not.

#### Behavior:
- `getExtractedData()`: Private -> Returns a List of Map.

### PartyName (Enum) (Public)
#### States:
- `partyName`: String -> Represents the name of the party.

#### Behavior:
- `PartyName(partyCode)`: Constructor.
- `getPartyName()`: Returns the String name of the party.

### VoteCalculator (Private)
#### States:
- `cityNames`: List < String > -> Stores the names of cities.
- `voteWithParties`: List < Map<String, Integer > > -> Stores votes mapped to parties.

#### Behavior:
- `calculateVotes()`: Private -> Returns a Map.
- `cityMapper()`: Private -> Maps cities and returns the result.
- `getResult()`: Private -> Returns a List of Map.

### DisplayResult (Public)
#### States:
- `cityName`: String -> Represents the name of the city.
- `partyName`: String -> Represents the name of the party.
- `votes`: Long -> Represents the number of votes.

#### Behavior:
- `Display()`: Public -> Displays the result.
