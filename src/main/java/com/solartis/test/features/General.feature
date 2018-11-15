@General
Feature: Login Profile
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Scenario: Successful login
 	When Raja "raja" buttonl
 	And Raja "raja1" messagel
 	And Raja "raja 2" page onl URL "raja3"
 	Then Raja "raja 4" withl "raja 5"
 

  Scenario Outline: Failed login using wrong credentials
 	When Raja "<username>" buttonl
 	And Raja "<warning>" messagel
 	And Raja "<username>" page onl URL "<password>"
 	Then Raja "<username>" withl "<password>"
    Examples:
      | username    | password   | warning                           |
      | Test        | !23        | Incorrect credentials. Try again! |
      | Tset        | 123        | Incorrect credentials. Try again! |
      | Tset        | !23        | Incorrect credentials. Try again! |
      | Test        |            | Please enter password.            |
      |             | 123        | Please enter username.            |
      |             |            | Please enter your credentials.    |