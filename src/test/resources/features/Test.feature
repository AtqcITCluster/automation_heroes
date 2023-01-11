Feature: Testing

  @TestCase
    @automated
  Scenario Outline: Verify login functionality
    Given "<home_page>" is opened
    When user writes "<login>" and "<password>"
    Then verify user is logged in
    Examples:
      | home_page | login | password |
      |           |       |          |