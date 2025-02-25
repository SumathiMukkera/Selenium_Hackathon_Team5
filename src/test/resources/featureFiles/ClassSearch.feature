Feature: Search Box
Background: Admin is on the Manage Class page after login
 Given Admin is on home page after Login
 When Admin clicks the Class Navigation bar in the Header     
 Given Admin is on the Manage Class page  
 
    Scenario: Search class by Batch Name
    When Admin enter the Batch Name in search textbox
    Then Admin should see Class details are searched by Batch Name

    Scenario: Search class by Class topic
    When Admin enter the Class topic in search textbox
    Then Admin should see Class details are searched by Class topic

    Scenario: Search class by Staff Name
    When Admin enter the Staff Name in search textbox
    Then Admin should see Class details are searched by Staff name