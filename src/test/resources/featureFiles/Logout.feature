Feature: Logout functionality

Background: Verify that Admin is able to navigate to Program page
 Given Admin is on home page after Login

@logout
    Scenario: Verify logout function
    Given Admin is in home page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page

    Scenario: Verify back button function
    Given Admin is in login page
    When Admin clicks browser back button
    Then Admin should receive error message

