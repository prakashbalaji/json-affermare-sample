Feature: Authors

  Background: :
    Given I setup data
    Then I start server

  Scenario: Verify collection for present of items
    Then I make a GET to "authors/all.json"
    Then I verify that the following authors are present
      | id  | name   |
      | 124 | Beck   |
      | 123 | Fowler |

  Scenario: Filter collection with one condition
    Then I make a GET to "authors/all.json"
    Then I filter the authors with "id" is "123"
      | id  | name   |
      | 123 | Fowler |

  Scenario: Filter collection with in clause
    Then I make a GET to "authors/all.json"
    Then I filter the authors with "id" in "123,124"
      | id  | name   |
      | 123 | Fowler |
      | 124 | Beck   |


  Scenario: Verify collection for items not present
    Then I make a GET to "authors/all.json"
    Then I verify that the following authors are not present
      | id  | name  |
      | 125 | Vijay |

  #TODO :Failing scenario
  #Scenario: Verify collection for items not present
  #  Then I make a GET to "authors/all.json"
  #  Then I verify that the following authors are not present
  #    | id  | name  |
  #    | 124 | Vijay |
  #    | 125 | Beck  |

  Scenario: Verify collection for empty set
    Then I make a GET to "authors/empty.json"
    Then I verify that no authors are present


  Scenario: Verify collection for count
    Then I make a GET to "authors/all.json"
    Then I verify that the number of authors are "2"

  Scenario: Verify a item
    Then I make a GET to "authors/123.json"
    Then I verify that the following author is present
      | id  | name   |
      | 123 | Fowler |


  Scenario: Verify a item with associated collection
    Then I make a GET to "authors/123.json"
    Then I verify that the following author is present
      | id  | name   |
      | 123 | Fowler |
    Then I verify that author has the following "phone_numbers"
      | type   | number    |
      | office | 987654321 |
      | home   | 123456789 |


  Scenario: Verify response code
    Then I make a GET to "authors/all.json"
    Then I verify that the status is "OK"

  Scenario: Verify Error response code
    Then I make a GET to "authors/error.json"
    Then I verify that the status is "PRECONDITION_FAILED"


  Scenario: Verify collection for the order of items
    Then I make a GET to "authors/all.json"
    Then I verify that the following authors are present in the same order
      | id  | name   |
      | 123 | Fowler |
      | 124 | Beck   |

  Scenario: Verify collection the list of values
    Then I make a GET to "authors/names.json"
    Then I verify the list of author names are present
      | Fowler |
      | Beck   |
    Then I make a GET to "authors/ids.json"
    Then I verify the list of author ids are present
      | 124 |
      | 123 |
    Then I verify the list of author ids are present in the same order
      | 123 |
      | 124 |

  Scenario: Verify the collection for filtered items
    Then I make a GET to "authors/filter.json" with params
      | name |
      | Beck |

    Then I verify that the following authors are present
      | id  | name |
      | 124 | Beck |

  Scenario: Verify the collection for multiple filtered
    Then I make a GET to "authors/multi_filter.json" with params
      | id  | name |
      | 124 | Beck |

    Then I verify that the following authors are present
      | id  | name |
      | 124 | Beck |

  Scenario: Verify the collection put request
    Then I make a PUT to "authors/put_no_data.json"

    Then I verify that the following authors are present
      | id  | name   |
      | 123 | Fowler |
      | 124 | Beck   |


  Scenario: Verify the collection put request with data
    Then I make a PUT to "authors/put.json" with data
      | {                       |
      | "id": 123,              |
      | "name": "Martin Fowler" |
      | }                       |

    Then I verify that the following authors are present
      | id  | name          |
      | 123 | Martin Fowler |
      | 124 | Beck          |


  Scenario: Verify the collection post request
    Then I make a POST to "authors/post_no_data.json"

    Then I verify that the following authors are present
      | id  | name   |
      | 123 | Fowler |
      | 124 | Beck   |


  Scenario: Verify the collection post request with data
    Then I make a POST to "authors/post.json" with data
      | {                       |
      | "id": 123,              |
      | "name": "Martin Fowler" |
      | }                       |

    Then I verify that the following authors are present
      | id  | name          |
      | 123 | Martin Fowler |


  Scenario: Verify the collection delete
    Then I make a DELETE to "authors/123.json"

    Then I verify that the following authors are present
      | id  | name   |
      | 124 | Beck   |


  #TODO: Empty list while expecting something should fail more meaningfully than array out of bounds
  #Scenario: Verify the collection for filtered items
  #  Then I make a GET to "authors/filter.json" with params
  #    | name |
  #    | beck |
  #
  #  Then I verify that the following authors are present
  #    | id  | name |
  #    | 124 | Beck |