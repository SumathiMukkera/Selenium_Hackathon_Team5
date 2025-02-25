@login
Feature: Login  Page Verification 

Scenario: Verify Admin is able to land on login page
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should land on the login page

Scenario: Verify Admin is able to land on home page with invalid URL
Given The browser is open
When   Admin gives the invalid LMS portal URL
Then   Admin should receive application error

Scenario: Verify for broken link
Given The browser is open
When Admin gives the correct LMS portal URL
Then HTTP response >= 400. then the link is broken

Scenario: Verify the text spelling in the page 
Given The browser is open
When  Admin gives the correct LMS portal URL
Then Admin should see correct spellings in all fields 

Scenario: Verify application name
Given The browser is open 
When Admin gives the correct LMS portal URL
Then Admin should see  LMS - Learning Management System

Scenario: Verify company name
Given The browser is open 
When Admin gives the correct LMS portal URL
Then Admin should see company name below the app name

Scenario: Validate sign in content
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see "Please login to LMS application"

Scenario: Verify text field is present
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see two text field

Scenario: Verify text on the first field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should "User" in the first text field

Scenario: Verify asterisk next to USER text 
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see asterisk mark symbol next to text for mandatory fields

Scenario: Verify text on the second field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should "Password" in the second text field

Scenario: Verify asterisk mark symbol next to password text
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see asterisk mark symbol next to password text

Scenario: Verify dropdown is present
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see one dropdown

Scenario: Verify placeholder in dropdown to select role
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see "Select the role" placeholder in dropdown

Scenario Outline: Verify dropdown option to select role
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see the following "<option1>", "<option2>", "<option3>" in the dropdown
Examples:
  | option1 | option2 | option3 |
  | Admin   | Staff   | Student |
      
Scenario: Verify the alignment input field for the login
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see input field on the centre of the page

Scenario: verify Login button is present
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see login button 

Scenario: Verify input descriptive text in user field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see user in gray color

Scenario: Verify input descriptive text in password field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see password in gray color