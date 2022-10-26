Feature: accessing all the main modules of the app.

  User Story: As a user, I should be accessing all the main modules of the app.

  Background:
    Given User is on Log In Page

    @wip
  Scenario: store and sales managers should view 8 module names.
    Given user enters user and password as store or sales manager, "storemanager51", "UserUser123"
    When User clicks on login button
    And User is on Home Page, expected title Dashboard
    And Verify user sees eight modules: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System
    Then user logs out

    @wip
  Scenario: drivers should view 4 module names
    Given User enters user and password, "user1", "UserUser123"
    When User clicks on login button
    And User is on Home Page, expected title Dashboard
    And drivers should view four module names: Expected module names: Fleet, Customers, Activities, System
    Then user logs out

