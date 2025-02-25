Feature: LogOut of the application from the batch page

Background: Admin is on the Add new batch pop up
    Given Admin is on home page after Login

    Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on the batch page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page
    

