Feature: Add New Class
Background: Admin Is on the Manage class page after login
 Given Admin is on home page after Login
 When Admin clicks the Class Navigation bar in the Header
 And Admin clicks a add new class under the class menu bar 
 Given Admin is on the Class Popup window
 
    Scenario: Validate Class Details Popup window
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

    Scenario: Validate input fields and their text boxes in Class details form
    Then Admin should see few input fields and their respective text boxes in the class details window

    Scenario: Check if class is created when only mandatory fields are entered with valid data
    When Admin enters mandatory fields in the form and clicks on save button
    Then Admin gets message Class added Successfully

    Scenario: Check no of classes value added when selecting class dates
    When Admin selects class date in date picker
    Then Admin should see no of class value is added automatically

    Scenario: Check weekend dates are disabled in calendar
    When Admin clicks date picker
    Then Admin should see weekends dates are disabled to select

    Scenario: Check if class is created when only optional fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin skips to add value in mandatory field and enter only the optional field
    Then Admin should see error message below the test field and the field will be highlighted in red color

    Scenario: check if class is created when invalid data is entered in all of the fields
    Given Admin is on the Class Popup window
    When Admin enters invalid data in all of the fields in the form and clicks on save button
    Then Admin gets error message and class is not created

    Scenario: Empty form submission
    Given Admin is on the Class Popup window
    When Admin clicks on save button without entering data in the class pop up window
    Then class will not be created and Admin gets error message

    Scenario: Validate Cancel/Close(X) icon on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks Cancel Icon on Admin Details form
    Then Class Details popup window should be closed without saving

    Scenario: Validate Save button on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks save button in the class pop up window
    Then Admin can see the class details popup closed and adding new class