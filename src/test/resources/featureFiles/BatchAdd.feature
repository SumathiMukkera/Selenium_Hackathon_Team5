Feature: Add New Batch
Background: Admin is on the Batch page
   Given User is on the login page
   And User enters valid credentials "sdetnumpyninja@gmail.com" and "Feb@2025"
   And User selects the Admin role
   And User clicks on login

   Scenario: Verify sub menu displayed in batch menu bar
      Given Admin is on the home page
      When Admin clicks "Batch" on the navigation bar
      Then Admin should see sub menu in menu bar as "Add New Batch"

    Scenario: Validate Admin able to click on the Add new Batch Option
      Given Admin is on the home page
      When Admin clicks on "Add New Batch" under the Batch menu bar
      Then Admin should see the Batch Details pop up window