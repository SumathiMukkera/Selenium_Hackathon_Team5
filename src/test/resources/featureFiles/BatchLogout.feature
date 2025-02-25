Feature: LogOut of the application from the batch page

Background: Admin is on the Add new batch pop up

    Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on the batch page
    When Admin clicks on the logout button
    Then Admin should see the Login screen Page

