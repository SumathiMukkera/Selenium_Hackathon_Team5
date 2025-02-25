Feature: Class functionality
Background: Admin Is on the home page after login
 Given Admin is on home page after Login
 When Admin clicks the Class Navigation bar in the Header

    Scenario: Validating the class manage page
    Then Admin should land on the Manage class page

    Scenario: Validating the Header in the Manage class page
    Then Admin should see the "Manage Class" Header

    Scenario: Validating Search bar in class page
    Then Admin should see the Search Bar in Manage class page

    Scenario: Validating the data table headers in the class page
    Then Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit/Delete

    Scenario: Validating the text and pagination icon in the classpage
    Then Admin should see the "Showing x to y of z entries" and enabled pagination controls under the data table

    Scenario: Validate the sort icon of all the field in datatable
    Then Admin should see the Sort icon of all the field in the datatable.

    Scenario: Validating the Delete button under the Manage class
    Then Admin should see the Delete button under the Manage class page header.

    Scenario: Validate the total no of classes in manage class page
    Then Admin should see Total no of classes in below of the data table.


