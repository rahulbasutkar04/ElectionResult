
# Problem
Election Results

It's election night! Exciting! We have a feed of election results from a data supplier. 
They will supply us a file which will be updated throughout the night as results come in.

A result will consist of:
 - A constituency
 - A repeating set of pairs with the party code and the votes cast

So for example:

Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP
Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND

Party Codes -

BJP - Bhartiya Janta Party
INC - Indian National Congress
BSP - Bahujan Samaj Party
CPI - Communist Party of India
NCP - Nationalist Congress Party
IND - Independant

We want to transform this into a standard result that shows:

- the constituency name
- translates the party code into a full name
- shows the winner of the constituency
Extensions - 

- shows the share of the vote as a percentage of all the votes cast 
- winning party i.e. party with maximum number of seats


# Solution report
![image](https://github.com/rahulbasutkar04/ElectionResult/assets/115400916/7f757b00-b8c7-40cb-9303-a91bd1c06b17)

# Design
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
