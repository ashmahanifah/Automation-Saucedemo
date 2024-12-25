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





