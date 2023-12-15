Feature: Scheduled events

  Background: Events

    Given user navigates to home page
    When user clicks on the login module
    And user enters seller's username and password
    And user clicks on the login button


    Scenario:As a user, I should be able see "Scheduled events", "Registered events" and "Attended Events" title when I clicked Events module on the side bar.
      When user clicks on the Events module on the side bar
    Then verify that "Scheduled events", "Registered events" and "Attended Events" titles are visible and clickable
  When user clicks on the Scheduled events,
    Then verify that related page is opened and sees all the scheduled events







#
#    1- "Scheduled events", "Registered events" and "Attended Events" titles should be visible and clickable
#    2- After clicking the "Scheduled events", related page is visible
#
#
#    6- In the Scheduled events cart, title, date, time, attendee limit, available seat, fee and location should be visible
#    7- In the Scheduled events cart, "Registered" button should be visible and clickable
#    8- When I clicked on the Register button then "Event Registration" page is opened




