Feature: accessing all the main modules of the app.

  User Story: As a user, I should be accessing all the main modules of the app.

  Scenario: store and sales managers should view 8 module names.
    Given User is on home page
    When User enters user and pass as salesmanager or storemanager
    And User clicks on login button
    Then Verify user sees 8 modules: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System

  Scenario: drivers should view 4 module names
    Given User is on home page
    When User enters user and pass as salesmanager or storemanager
    And User clicks on login button
