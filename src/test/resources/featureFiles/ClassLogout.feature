Feature: Navigation Validation from Manage Class to other Pages
Background: Admin is on home page after Login and clicks Class on the navigation bar
 Given Admin is on home page after login
 When Admin clicks the Class Navigation bar in the Header     
 Given Admin is on the Manage Class page  
 
    Scenario: Class link on navigation bar
    When Admin clicks on Class link on Manage Class page
    Then Admin is redirected to class page

    Scenario: Class link to other page on navigation bar
    When Admin clicks on any page link on Manage Class page
    Then Admin is redirected to which page link they clicked.

    Scenario: Logout link on navigation bar
    When Admin clicks on Logout link on Manage class page
    Then Admin is redirected to Login page
