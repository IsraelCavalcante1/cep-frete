Feature: Shipping Cost Calculation

  Scenario: Calculate shipping cost for state in Southeast region
    Given the state is "SP"
    When I calculate the shipping cost
    Then the shipping cost should be 7.85

  Scenario: Calculate shipping cost for state not in any region
    Given the state is "AC"
    When I calculate the shipping cost
    Then the shipping cost should be 20.83

