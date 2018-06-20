@fifth
Feature: To test login of muster application

  Scenario: Test with accepting the terms and condition
    Given Launch the muster application local_ios_ipa.properties
    When Accept the TC and click proceed button
    Then Close the muster driver
