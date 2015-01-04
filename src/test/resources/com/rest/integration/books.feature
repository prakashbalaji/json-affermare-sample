Feature: Books

  Background: :
    Given I setup data
    Then I start server

  Scenario: Verify a sub item of a item
    Then I make a GET to "books/123.json"
    Then I verify that the json has the following "books"
      | isbn      | name                    |
      | abc123456 | Test driven development |
    Then I verify that book has a "author"
      | id  | name |
      | 124 | Beck |

  Scenario: Verify a empty object
    Then I make a GET to "books/empty.json"
    Then I verify that the json "book" is empty


  Scenario: Verify a object does not have keys
    Then I make a GET to "books/123.json"
    Then I verify that the json does not have the following "attributes"
      | tax |


  Scenario: Verify associated object along with main object
    Then I make a GET to "books/all.json"
    Then I verify that the json has the following "books"
      | isbn      | name                    | author.name |
      | abc123456 | Test driven development | Beck        |
      | def123456 | Refactoring             | Fowler      |