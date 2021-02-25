Feature: Demo Site various Login Attempts
  I want to login a user successfully
  
  Scenario Outline: Title of your scenario outline
    Given that I can access "<Domain>"
    When I select Add User tab
    And I Enter Credentials of User "<Name>" and Password "<Password>" and submit
    And I Select Login tab
    And I enter Credentials of created user "<Name>" and Password "<Password>" and submit
    Then Check if Login was successful

    Examples: 
      | Name  | Password | Domain  |
      | James |     root | www.thedemosite.co.uk |
      | Mary |     pass | www.thedemosite.co.uk |
      | Lewis |     pass1 | www.thedemosite.co.uk |
