Feature: The entrance of a test case

  Background: run a test case with bigtester Automation Test Engine
    Given a predefined test case Spring context xml file

  Scenario: start and run the test
    # Try to validate if the login form exists on homepage
    When run the test
    Then generate a test case report
