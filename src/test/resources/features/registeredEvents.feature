Feature: Registered Events

  Background: Events
    Given user navigates to home page
    When user clicks on the login module
    And user enters seller's username and password
    And user clicks on the login button

  @Register
  Scenario:As a user, I should be able see "Scheduled events", "Registered events" and "Attended Events" title when I clicked Events module on the side bar.
    And user enters zipCode and clicks Go button
    When user clicks on the Events module on the side bar
    When user clicks on the Registered Events
    Then verify that related page is opened and  all the Registered Events are displayed
    And verify that in the Registered Events cart, headers are visible
    And verify that in the Registered Events cart, all modules are visible
      | Date           |
      | Time           |
      | Attendee Limit |
      | Available Seat |
      | Fee            |
      | Location       |

    And verify that in the Registered Events cart, Cancel button should be visible and clickable
    When I clicked on the Cancel button
    Then user verify Yes and No button is visible and clickable
    When user clicks on the No button
    Then user verify cannot delete the Registered Events
    When user clicks on the Yes button
    Then user verify Registered Events deleted

      #Then verify that Event Registration cart is opened

