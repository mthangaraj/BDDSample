@Fourth
Feature: To test espresso multi login

  Scenario: Test valid credential login with multiple test data
    Given Launch chrome dirver local_web_chrome.properties
    And login with multiple Username and Password
      |bdduser01|Espresso@1|
      |bdduser02|Espresso@1|
      |bdduser03|Espresso@1|
      |bdduser1|Espresso@1|
    Then Close chrome

