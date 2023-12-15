Feature: Scheduled events

  Background: Events

    Given user navigates to home page
    When user clicks on the login module
    And user enters seller's username and password
    And user clicks on the login button


  Scenario:As a user, I should be able see "Scheduled events", "Registered events" and "Attended Events" title when I clicked Events module on the side bar.
    And user enters zipCode and clicks Go button
    When user clicks on the Events module on the side bar
    Then verify that "Scheduled Events", "Registered Events" and "Attended Events" titles are visible and clickable
    When user clicks on the Scheduled events,
    Then verify that related page is opened and  all the scheduled events are displayed
    And verify that In the Scheduled events cart, headers are visible
    And verify that In the Scheduled events cart, all modules are visible
      | Date           |
      | Time           |
      | Attendee Limit |
      | Available Seat |
      | Fee            |
      | Location       |

    And verify that In the Scheduled events cart, Registered button should be visible and clickable
    When I clicked on the Register button
    Then verify that Event Registration cart is opened







