Feature: google search

  Scenario Outline: title testing
    Given open "<browser-name>" browser
    When i launch "http://www.google.co.in" site
    Then title should be "Google"
    When i entered a value and verify title
      | word         |
      | abdul kalam  |
      | steve jobs   |
      | thomas kutty |
      | mithali      |
    And close site

    Examples: 
      | browser-name |
      | chrome       |
      | firefox      |
