@API
  Feature: Events
    Scenario: Login-Get-Register-Cancel
      When user sends a request for getting token
      When user makes a request and gets all Scheduled Events
      Then user register a scheduled event
      Then user cancel a registered event
      And User verifies that "You have canceled your attendance" message is in response
