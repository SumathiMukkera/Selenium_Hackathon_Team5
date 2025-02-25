 Feature: Program Pagination 
 
Background: Verify that Admin is able to navigate to Program page
 Given Admin is on home page after Login
 When Admin click program button 

 @testdocker
 Scenario: Verify Admin is able to click Next page link
    Given Admin is on Program page
    When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has Next active link

    Scenario: Verify Admin is able to click Last page link
    Given Admin is on Program page
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled
    
    @testlastpage
    Scenario: Verify Admin is able to click Previous page link
    Given Admin is on last page of Program page table
    When Admin clicks Previous page link
    Then Admin should see the previous page record on the table with pagination has previous page link

    Scenario: Verify Admin is able to click First page link
    Given Admin is on Previous Program page
    When Admin clicks First page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

    Scenario: Verify pagination when there are no records
     Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should not see any pagination icons and message "No records found"

    Scenario: Verify pagination when there are less than 5 records
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see pagination icons disabled
