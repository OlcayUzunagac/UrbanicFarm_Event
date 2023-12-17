Feature: Attended Events

  Background: Events
    Given user navigates to home page
    When user clicks on the login module
    And user enters seller's username and password
    And user clicks on the login button

  @Attended
  Scenario:As a user, I should be able see "Scheduled events", "Registered events" and "Attended Events" title when I clicked Events module on the side bar.
    And user enters zipCode and clicks Go button
    When user clicks on the Events module on the side bar
    When user clicks on the Attended Events
    Then verify that related page is opened and  all the Attended Events are displayed
    And verify that in the Attended Events cart, headers are visible
    And verify that in the Attended Events cart, all modules are visible
      | Date           |
      | Time           |
      | Attendee Limit |
      | Location       |
      | Details        |
      | Fee            |