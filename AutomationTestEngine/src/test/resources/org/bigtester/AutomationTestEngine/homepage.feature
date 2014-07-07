Feature: Homepage Browsing

  Background: A homepage of bigtester.com
    Given a homepage I just navigate to

  Scenario: About sub-menu exists
    # Try to validate if the login form exists on homepage
    When I open About menu
    Then About sub-menu appears
