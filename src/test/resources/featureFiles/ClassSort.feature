Feature: Sort Class Details
Background: Admin is on the Manage class page
 Given Admin is on home page after login
 When Admin clicks the Class Navigation bar in the Header     
 Given Admin should land on the Manage class page
  
    Scenario: Sort Class by Batch name
    When Admin clicks on the Batchname sort icon
    Then Admin should see Class details are sorted by Batch Name

    Scenario: Sort Class by Class topic
    When Admin clicks on the Class topic sort icon
    Then Admin should see Class details are sorted by Class Topic

    Scenario: Sort Class by Class Description
    When Admin clicks on the Class description sort icon
    Then Admin should see Class details are sorted by Class Description

    Scenario: Sort Class by Status
    When Admin clicks on the Status sort icon
    Then Admin should see Class details are sorted by Status

    Scenario: Sort Class by Class date
    When Admin clicks on the Class Date sort icon
    Then Admin should see Class details are sorted by Class Date

    Scenario: Sort Class by staff name
    When Admin clicks on the Staff Name sort icon
    Then Admin should see Class details are sorted by Staff name

    Scenario: Validate row level delete icon
    When Admin clicks the delete icon
    Then Admin should see a alert open with heading "Confirm" along with <YES> and <NO> button for deletion

    Scenario: Click Yes on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks yes option
    Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table

    Scenario: Click No on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks No option
    Then Admin can see the deletion alert disappears without deleting

    Scenario: Validate Close(X) icon on Confirm Deletion alert
    Given Admin is on Confirm Deletion alert
    When Admin clicks on close button
    Then Admin can see the deletion alert disappears without any changes