Feature: Consult Address by CEP

  Scenario: Consult an address by a valid CEP
    Given a CEP "01001000"
    When I consult the address
    Then the response should contain the address data and shipping cost

  Scenario: Consult an address by an invalid CEP
    Given an invalid CEP "12345678"
    When I consult the address
    Then an exception should be thrown
