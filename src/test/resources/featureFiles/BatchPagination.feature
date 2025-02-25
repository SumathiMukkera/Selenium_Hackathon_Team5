Feature: Batch Pagination

Background: Admin is on the batch page
  	Given Admin is on home page after Login

    Scenario: Validate next page link
    Given Admin is on the batch page
    When Admin clicks next page link on the data table
    Then Admin should see the Next page

    Scenario: validate last page link
    Given Admin is on the batch page
    When Admin clicks last page link on the data table
    Then Admin should see the last page link with next page link disabled on the table

    Scenario: validate the previous page link
    Given Admin is on the batch page
    When Admin clicks next page link on the data table
        And Admin clicks previous page link on the data table
    Then Admin should see the previous page on the table

    Scenario: validate the first page link
    Given Admin is on the batch page
    When Admin clicks last page link on the data table
        And Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table