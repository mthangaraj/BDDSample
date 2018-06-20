@first
Feature: To test whatsapp registration

  Scenario: Test with accepting the terms and condition
    Given Launch the whatsapp application local_android_apk.properties
    When Accept the T&C and proceed registration
    Then Close the driver
