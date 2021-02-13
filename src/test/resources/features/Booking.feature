Feature: Booking API

  Scenario: Create a new booking
    Given Booking API is active
    When I POST a create booking
    Then I see response has 200 status code
    And I verify booking request response as per booking model

  Scenario: Create a booking for multiple customers
    Given Booking API is active
    When I POST a create booking API for multiple users
      | firstname | lastname | totalprice | depositpaid | additionalneeds |
      | Test      | Customer |        100 | true        | Lunch           |
      | Test      | Customer |        250 | false       | Dinner          |
    Then the response has following response code
      | code |
      |  200 |
      |  200 |

  Scenario: Delete a booking
    Given Booking API is active
    When I DELETE a booking
    Then I see response has 201 status code
    When getting the same booking with Id
    Then I see response has 404 status code

  Scenario Outline: Update a booking in the API
    Given Booking API is active
    When I UPDATE a booking
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <additionalneeds> |
    Then I see response has <code> status code
    And I verify booking request response as per booking model

    Examples: 
      | firstname | lastname | totalprice | depositpaid | additionalneeds | code |
      | Lease     | Plan     |        100 | true        | Lunch           | 200  |