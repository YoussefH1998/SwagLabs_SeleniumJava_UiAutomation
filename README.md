# Project Title

[Swag Labs](https://www.saucedemo.com/) Web UI automation testing with selenium java designed in page object model design pattern.

## Prerequisites

Knowledge of Java, Selenium, Maven & Test NG

## Built With

- [Java](https://www.oracle.com/java/technologies/downloads/) - The programming language used
- [Selenium](https://www.selenium.dev/documentation/) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management
- [Test NG](https://testng.org/) - a testing framework for the Java programming language

## Running the tests

- To run these tests we should have any integrated development environment that can run java programs
- These tests are designed that they can all be run successively or each suite seperately or each test case seperately
- These tests consist of e2e tests folder which is responsible for running different user scenarios (standard user, locked_out_user, ....etc)

- These tests consist of testsuites for loginPage and productPage specifically which can test these pages seperately or can be used as regression cases if certain changes occured in these pages

## Test Execution Video Link

[Test Execution Video](https://drive.google.com/file/d/1Au571X0qKa9A1WN5LJE2oyDl78J-d8q2/view?usp=drive_link) - A video of test execution for all tests in the project

## Test Scenarios:-

| Test Scenario Description | Test Steps                                                                                                                                                                                                                                                                                                 | Expected Result                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | Actual Result |
| ------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------- |
| Standard User             | 1-Login with normal user credentials<br/>2- Sort product from Z to A <br/> 3-Add two products to shopping bag<br/> 4-Click on the shopping bag link<br/> 5-Click on checkout Button <br/> 6-Fill inormation (firstname, lastname, postalcode)<br/>7-Click on continue Button<br/> 8-Click on Finish button | 1-User should be logged in and navigated to products page<br/>2-User should see the products sorted as choosen <br/> 3-User see that products bag count is 2<br/> 4-User should be navigated to the cart page<br/> 5-User should be navigated to the checkout information page <br/> 6-User should see the data entered in the firstname,lastname,postal code written in their textfields <br/>7-User should be navigated to the final confirmation page seeing the total price as per expected when adding the products in the products page<br/> 8-User should see messages including the following Thank you & Your order has been dispatched | Passed        |
| Locked User               | 1-Enter locked user credentials <br> 2-Click on Login Button                                                                                                                                                                                                                                               | 1-Error message stating " Sorry, this user has been locked out." should pop up<br>2-User should stay at the login page                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | Passed        |
| Problem User              | 1-Enter problem user credentials <br> 2-Click on login button                                                                                                                                                                                                                                              | 1-User should be navigated to products page <br>2-User should see one image repeated in all products                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Passed        |
| Performance Glitch User   | 1-Login with performance glitch user credentials<br>2-Sort products Price low to high                                                                                                                                                                                                                      | 1-User should be navigated to products page but after delay (App should not crash) <br>2- User should see the products sorted as choosen but after delay (App should not crash)                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | Passed        |
| Error User                | 1-Login with error user credentials<br>2-Sort products from Z to A <br>3-Click ok for the alert that popped up <br> 4-Click on the shopping bag link<br/> 5-Click on checkout button <br> 6-Fill inormation for lastname                                                                                   | 1-User should be navigated to products page<br> 2-Alert box is popped up with message "Sorting is broken" <br>3-The alert box should be closed <br/> 4-User should be navigated to the cart page<br/> 5-User should be navigated to the checkout information page <br/> 6-User wont see text entered in the lastname field                                                                                                                                                                                                                                                                                                                       | Passed        |
| Viusal User               | Login with visual user credentials                                                                                                                                                                                                                                                                         | User should be naviated to the products page and will see a visualization issue that the shopping bag is not placed in its correct place                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | Passed        |

## Test Suites:-

## Login

| Test Case Description                            | Expected Result                                                                                           | Actual Result |
| ------------------------------------------------ | --------------------------------------------------------------------------------------------------------- | ------------- |
| User can write in username field                 | Text entered by user should be present in the user textboxt                                               | Passed        |
| User can write in password field                 | Text entered by user should be present in the password textboxt                                           | Passed        |
| User enter no username but enters password       | Error message should be displayed that "Password is required"                                             | Passed        |
| User enter username but does not enter password  | Error message should be displayed that "UserName is required"                                             | Passed        |
| User enter valid username and invalid password   | Error Message should be displayed that "UserName and Password do not match any combination in the system" | Passed        |
| User enter invalid username and valid password   | Error message should be displayed that "UserName and Password do not match any combination in the system" | Passed        |
| User enter invalid username and invalid password | Error message should be displayed that "UserName and Password do not match any combination in the system" | Passed        |
| User enter valid username and valid password     | User logged in successfully and user is navigated to the products page                                    | Passed        |

## Products

| Test Case Description                                                | Expected Result                                                      | Actual Result |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | ------------- |
| User can choose to sort products alphabetically from A to Z          | All products are sorted alphabetically in ascending order            | Passed        |
| User can choose to sort products alphabetically from Z to A          | All products are sorted alphabetically in descending order           | Passed        |
| User can choose to sort products according to price from low to high | All products are sorted according to their price in ascending order  | Passed        |
| User can choose to sort products according to price from high to low | All products are sorted according to their price in descending order | Passed        |
| User can add any product to cart                                     | The product should be added to the bag                               | Passed        |
| User can remove added product from cart                              | The product should be removed from the bag                           | Passed        |

## Author

**Youssef Hassan**
