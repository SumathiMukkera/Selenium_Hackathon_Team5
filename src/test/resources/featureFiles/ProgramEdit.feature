Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login


    @Edit1
    Scenario: Verify Edit option
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form
    
    @Edit2
    Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see editwindow title as "Program Details"
    
    @Edit3
    Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see red asterisk mark beside mandatory field Name
    @Edit4
    Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears
    @Edit5
    Scenario: Verify close the window with "X"
    Given Admin is on Program details form
    When Admin Click on X button
    Then Admin can see Program Details form disappears
    @Edit6
    Scenario Outline: Verify edit Program Name
    Given Admin is on Program page
    When Admin edits the program name and click on save button "<Sheetname>" and <RowNumber>
    Then Updated program name is seen by the Admin
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |
    @Edit7
    Scenario Outline: Verify edit Description
    Given Admin is on Program page
    When Admin edits the program description and click on save button "<Sheetname>" and <RowNumber>
    Then Updated program description is seen by the Admin
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |
    @Edit8
    Scenario Outline: Verify Admin is able to click Save
    Given Admin is on Program page
    When Admin edits editprogram form and click on save button "<Sheetname>" and <RowNumber> 
    Then Admin can see the updated program details
    Examples:
    | Sheetname    | RowNumber |
    | program      |  1        |
    #@Edit9
    #Scenario Outline: Verify edit Status
    #Given Admin is on Program page
    #When Admin can change the status of the program and click on save button "<Sheetname>" and <RowNumber>
    #Then Status updated can be viewed by the Admin
    #Examples:
    #| Sheetname    | RowNumber |
    #| program      |  1        |
    
    
    