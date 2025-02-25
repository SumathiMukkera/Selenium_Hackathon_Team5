Feature: Delete Multiple Class
Background: Admin is on the Manage Class page after login
 Given Admin is on home page after login
 When Admin clicks the Class Navigation bar in the Header     
 Given Admin is on the Manage Class page
 When Admin clicks any checkbox in the data table
 
    Scenario: Validate Common Delete button enabled after clicking on any checkbox
    Then Admin should see common delete option enabled under header Manage class

    Scenario: Validate multiple class deletion by selecting Single checkbox
    Given Admin is on Confirm Deletion alert box
    When Admin clicks <YES> button on the alert
    Then Admin should land on Manage class page and can see the selected class is deleted from the data table

    Scenario: Validate multiple class deletion by selecting Single check box
    Given Admin is on Confirm Deletion alert pop up
    When Admin clicks <NO> button on the alert
    Then Admin should land on Manage class page and can see the selected class is not deleted from the data table
    
    Scenario: Validate multiple class deletion by selecting Multiple check boxes
    Given Admin is on Confirm Deletion alert after clicks multiple check boxes
    When Admin clicks <YES> button on the alert
    Then Admin should land on Manage class page and can see the selected class are deleted from the data table
    
    Scenario: Validate multiple class deletion by selecting Multiple check boxes
    Given Admin is on Confirm Deletion alert box after clicks multiple check boxes
    When Admin clicks <NO> button on the alert
    Then Admin should land on Manage class page and can see the selected class are not deleted from the data table