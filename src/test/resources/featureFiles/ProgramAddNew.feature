Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login

    @add1
    Scenario: Verify add New Program
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see pop up window for program details

    @add2
    Scenario: Verify sub menu displayed in program menu bar
    Given Admin is on Program page
    When Admin clicks Program on the navigation bar
    Then Admin should see program sub menu in menu bar as "Add New Program"

    @add3
    Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see window title as "Program Details"

    @add4
    Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see red asterisk mark beside mandatory field Name

    @add5
    Scenario Outline: Verify empty form submission for mandatory fields
    Given Admin is on Program details form
    When Admin clicks save button without entering mandatory
    Then Admin gets message "<Field>" is required

    Examples:
    | Field       |
    | Program name |
    | Description |
    | Status      | 
   
    @add6
    Scenario: Verify cancel button
    Given Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears
   
    @add7
    Scenario Outline: Verify text entry in different fields
    Given Admin is on Program details form
    When Admin enters the Name in the text box 
    Then Admin can see the entered text in Name box
    
    @add8
    Scenario Outline: Verify text entry in different fields
    Given Admin is on Program details form
    When Admin enters the description in the text box 
    Then Admin can see the entered text in description box
    
    @add9
    Scenario Outline: Verify selecting a status option
    Given Admin is on Program details form
    When Admin selects the status of the program by clicking on the radio button "<Status>"
    Then Admin can see "<Status>" status selected

    Examples:
    | Status    |
    | Active    |
    | Inactive  |
      
    @add10
    Scenario: Verify Admin is able to save the program details
    Given Admin is on Program details form
    When Admin enter valid details for mandatory fields and Click on save button
    Then Admin gets message 'Successful Program Created Successfully'
   
  
    @add11
    Scenario: Verify added Program is created
    Given Admin is on Program details form
    When Admin searches with newly created programName
    Then Records of the newly created programname is displayed and match the data entered
    
    @add12
    Scenario: Verify close window with "X"
    Given Admin is on Program details form
    When Admin Click on X button
    Then Admin can see Program Details form disappears
    
    