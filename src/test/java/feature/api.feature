Feature: Test Automation REST API

  @api
  Scenario: Test Get List data
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test create new user
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users
    Then validation status code is equals 201
    Then validation response body post create new users
    Then validation response json with JSONSchema "post_create_new_user.json"

  @api
  Scenario: Test create new user with incorrect value to input
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users with invalid input
    Then validation status code for incorrect input is equals 422
    Then validation response body for incorrect input contains "can't be blank"

  @api
  Scenario: Test create new user with invalid email format
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users with invalid email
    Then validation status code for incorrect input is equals 422
    Then validation response body for invalid email contains "is invalid"

  @api
  Scenario: Test update user
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users
    Then validation status code is equals 201
    Then validation response body post create new users
    Then hit api update data user
    Then validation status code is equals 200
    Then validation response body update user

  @api
  Scenario: Test delete user
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users
    Then validation status code is equals 201
    Then validation response body post create new users
    Then hit api delete user
    Then validation status code is equals 204

  @api
  Scenario: Test delete user with non-existing or deleted ID
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new users
    Then validation status code is equals 201
    Then validation response body post create new users
    Then hit api delete user
    Then validation status code is equals 204
    Then hit api delete user
    Then validation status code is equals 404
    Then validation response body contains "Resource not found"





