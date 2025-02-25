Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login

    @delete1
    Scenario: Verify delete feature
    Given Admin is on Program page
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup
    
    @delete2   
    Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirm deletion form
    When Admin clicks on Yes button
    Then Admin can see message 'Successful Program Deleted' 
    
    @delete3
    Scenario Outline: Verify Admin is able to deleted program
    Given Admin is on Program page
    When Admin searches for Deleted Program Name "<Sheetname>" and <RowNumber> 
    Then There should be zero results
     Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |
    
    @delete4   
    Scenario: Verify Admin is able to click 'No'
    Given Admin is on Confirm deletion form
    When Admin clicks on No button
    Then Admin can see Confirmation form disappears
    
    @delete5
    Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Confirm deletion form
    When Admin Clicks on X button
    Then Admin can see Confirmation form disappears
    
    @delete6
    Scenario: Verify Admin is able to select multiple programs
    Given Admin is on Program page
    When Admin selects more than one program by clicking on the checkbox
    Then Programs get selected
    
   @delete7  
   Scenario: Verify Admin is able to delete Multiple programs
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    Then Admin lands on Confirmation form 
    
    @delete8 
    Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    When Admin clicks on Yes button
    Then Admin see message 'Successful Programs Deleted' 
    
    @delete9 @bug
    Scenario: Verify Admin is able to deleted program
    Given Admin is on Program page
    When Admin deletes the Programs Names
    When Admin Searches for Deleted Program names
    Then There should be zero results
    
    @delete10
    Scenario: Verify Admin is able to click 'No'
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    When Admin clicks on No button
    Then Admin see Programs are still selected and not deleted
    @delete11
    Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    When Admin Clicks on X button
    Then Admin can see Confirmation form disappears
    