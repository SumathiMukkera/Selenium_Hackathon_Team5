Feature: Home functionality

    Scenario: Verify LMS title
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see LMS -Learning management system as title

    Scenario: Verify LMS title alignment
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then LMS title should be on the top left corner of page

    Scenario: Validate navigation bar text
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see correct spelling in navigation bar text

    Scenario: Validate LMS title has correct spelling and space
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see correct spelling and space in LMS title

    Scenario: Validate alignment for navigation bar
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see the navigation bar text on the top right side

    Scenario: Validate navigation bar order 1st home
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see home in the 1st place

    Scenario: Validate navigation bar order 2nd Program
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see program in the 2nd place

    Scenario: Validate navigation bar order 3rd batch
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see batch in the 3rd place

    Scenario: Validate navigation bar order 4th class
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see class in the 4th place

    Scenario: validate navigation bar order 5th logout
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see logout in the 5th place

    Scenario: verify pie-chart presence
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see piechart

    Scenario: Verify user details
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see welcome message with user name and role

    Scenario: Verify bar chart
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see bar chart for Active and inactive user

    Scenario: Verify user count
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see user count Note : count includes Active and inactive

    Scenario: Verify staff count
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see staff count Note : count includes Active and inactive

    Scenario: verify program count                                                                                                                                                                                                                                                                   
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see Program count Note : count includes Active and inactive                                                                                                                                                                                                                                            

    Scenario: Verify batch count
    Given Admin is on login Page
    Then Admin should see batch couNote : count includes Active and inactive                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
                                  
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see staff table with pagination icons

    Scenario: Verify staff data page split
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see 5 staff data in a page

    Scenario: verify previous page icon disable
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then admin should see previous page icon disabled

    Scenario: verify first page icon disabled
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then admin should see first page icon disabled

