Feature: Search functionality for autohero app

  Scenario Outline: Verify search functionality working for filters.

    Given user in on homepage.
    When  user set filter '<FILTER_NAME>' to '<FILTER_VALUE>' for cars.
    And   sort page by '<SORT_BY>'.
    Then  all cars should be filtered by first registration '<FILTER_VALUE>'
    And   all cars are sorted by price descending.



    Examples:
      | FILTER_NAME      | FILTER_VALUE | SORT_BY        |
      | Erstzulassung ab | 2015         | Höchster Preis |
