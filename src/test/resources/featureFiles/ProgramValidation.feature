Feature: Program functionality

Background: 
Given Admin is on home page after Login
    
    @v1
    Scenario: Verify that Admin is able to navigate to Program page
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program page
    
    @v2
    Scenario: Verify Logout displayed in menu bar
    When Admin clicks Program on the navigation bar
    Then Admin should see Logout in menu bar
    
    @v3
    Scenario: Verify heading in menu bar
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading "LMS - Learning Management System"

    @v4
    Scenario: Verify other pages name displayed in menu bar
    When Admin clicks Program on the navigation bar
    Then Admin should see the page names as in order "Home Program Batch Class"
   
    @v5
    Scenario: Verify heading in manage program
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading as "Manage Program"
    
    @v6
    Scenario: Verify view details of programs
    When Admin clicks Program on the navigation bar
    Then Admin should able to see Program name, description, and status for each program

    @v7 
    Scenario: Verify the Multiple Delete button state
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled

    @v8
    Scenario: Verify the Search button
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar displayed with text as "Search..."
   
    @v9
    Scenario: Verify column header name of data table
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as "Program Name, Program Description, Program Status, Edit / Delete"

    @v10
    Scenario: Verify checkbox default state beside Program Name column header
    When Admin clicks Program on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header

    @v11
    Scenario: Verify checkboxes default state beside each Program names in the data table
    When Admin clicks Program on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name 
    @v12
    Scenario: Verify Sort icon in manage program
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

    @v13
    Scenario: Verify edit and delete icon in manage program
    When Admin clicks Program on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table

    @v14
    Scenario: Verify pagination icons below data table in manage program
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table. x- starting record number on that pagey-ending record number on that pagez-Total number of records

    @v15
    Scenario: Verify footer message in manage program
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as In total there are z programs.z- Total number of records
 
 
   




 

