Feature: Google Search


  Scenario Outline: Google searching by button action
    Given User is on Google web side
    When User introduces the required criteria "<query>"
    And user clicks on Google Search button
    Then The system redirects to search page
    Examples:
      | query   |
      | front10 |
      | cuba    |


  Scenario Outline: Google searching by button ENTER click
    Given User is on Google web side
    When User introduces the required criteria "<query>"
    And user performs ENTER click
    Then The system redirects to search page
    Examples:
      | query   |
      | front10 |
      | cuba    |

  Scenario Outline: Google search results validation
    Given User is on Google web side
    When User introduces the required criteria "<query>"
    And user clicks on Google Search button
    Then the result match with the criteria introduced
    Examples:
      | query        |
      | cuba front10 |
      | cuba         |


  Scenario Outline: Validate link href
    Given User is on Google web side
    When User introduces the required criteria "<query>"
    And user clicks on Google Search button
    And user select one of the link result
    Then browser will redirect to new url
    Examples:
      | query        |
      | history front10 |