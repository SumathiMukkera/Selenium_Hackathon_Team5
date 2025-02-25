Feature: Pagination
Background: Admin is on the Manage Class page after login
 Given Admin is on home page after login
 When Admin clicks the Class Navigation bar in the Header     
 Given Admin is on the Manage Class page  
 
    Scenario: Verify Next page link(>)
    When Admin clicks Next page link on the class table
    Then Admin should see the next page record on the table with Pagination has next active link enabled

    Scenario: Verify Last page link(>>)
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

    Scenario: Verify First page link(<)
    Given Admin is on last page of class table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link enabled

    Scenario: Verify Start page link(<<)
    Given Admin is on Previous class page
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled