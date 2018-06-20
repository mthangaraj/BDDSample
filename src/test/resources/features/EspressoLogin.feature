@third
Feature: To test espresso login

  Scenario: Test valid credential login
    Given Launch chrome browser local_web_chrome.properties
    When Fill Manual Form and verify the text Manual Form Submitted Successfully
    Then Close chrome driver