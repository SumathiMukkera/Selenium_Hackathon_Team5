Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login

    @search1
    Scenario Outline: Verify Admin is able to search results found for program name
    Given Admin is on Program page
    When Admin enter the program to search By program name "<Sheetname>" and <RowNumber>
    Then Admin should able to see Program name, description, and status for searched program name
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |
    @search2
    Scenario Outline: Verify Admin is able to search results found for program description
    Given Admin is on Program page
    When Admin enter the program to search By program description "<Sheetname>" and <RowNumber>
    Then Admin should able to see Program name, description, and status for searched program description
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |

    @search3
    Scenario Outline: Verify Admin is able to search results not found
    Given Admin is on Program page
    When Admin enter the program to search By program name that does not exist "<Sheetname>" and <RowNumber>
    Then There should be zero results
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |
    @search4
    Scenario Outline: Verify Admin is able to search with partial program name
    Given Admin is on Program page
    When Admin enter the program to search By partial name of program "<Sheetname>" and <RowNumber>
    Then Admin should able to see Program name, description, and status for searched program name
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |

    @sort1
    Scenario: Verify ascending and descending sorting of Program Name
    Given Admin is on Program page
    When Admin clicks on Arrow next to programName
    Then ProgramName is sorted in ascending order
    When Admin clicks on the arrow next to ProgramName again
    Then ProgramName is sorted in descending order
    @sort2
    Scenario: Verify ascending and descending sorting of Program Description
    Given Admin is on Program page
    When Admin clicks on Arrow next to programDescription
    Then ProgramDescription is sorted in ascending order
    When Admin clicks on the arrow next to ProgramDescription again
    Then ProgramDescription is sorted in descending order
    @sort3
    Scenario: Verify ascending and descending sorting of Program Status
    Given Admin is on Program page
    When Admin clicks on Arrow next to programStatus
    Then ProgramStatus is sorted in ascending order
    When Admin clicks on the arrow next to ProgramStatus again
    Then ProgramStatus is sorted in descending order
    







