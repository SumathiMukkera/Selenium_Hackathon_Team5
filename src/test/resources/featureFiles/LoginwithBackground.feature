Feature: login page validation with background

Background:      
Given Admin gives the correct LMS portal URL

Scenario Outline: Validate login with valid data in all field
Given Admin is on login Page
When Admin enter valid data from excel "<sheetname>" and <rownumber> field and clicks login button 
Then Admin should land on home page 
Examples:
| sheetname  | rownumber  |
|  sheet1    |  2         |

Scenario Outline: Validate login with invalid data 
Given Admin is on login Page
When Admin enter invalid data from "<sheetname>" and <rownumber> and clicks login button 
Then Error message "Invalid username and password Please try again"
Examples:
| sheetname  | rownumber  |
|  sheet1    |  0         |
|  sheet1    |  1         |

Scenario: Validate login credentials with null user name 
Given Admin is on login Page
When Admin enter value only in password and clicks login button 
Then Error message" Please enter your user name"

Scenario: Validate login credentials with null password
Given Admin is on login Page
When Admin enter value only in user name and clicks login button 
Then Error message" Please enter your password "

Scenario: verify login button action through keyboard
Given Admin is on login Page
When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on home page

Scenario: verify login button action through mouse
Given Admin is on login Page
When Admin enter valid credentials  and clicks login button through mouse
Then Admin should land on home page