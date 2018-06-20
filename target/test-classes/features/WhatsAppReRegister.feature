@second
Feature: To test re-registration

  Scenario: Test with re-register
    Given Launch app local_android_apk.properties
    When Accept t&c and verify the text for Successfully navigated
    Then terminate the driver
