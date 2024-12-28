
# Automation Test Framework

This repository contains an automation test framework that includes both Web UI and API testing using Cucumber and Java. The tests are structured in a way that separates the Web and API tests into different packages, following the best practices for modular test automation.

## Overview

This project demonstrates how to implement a test automation framework that:
- Contains both Web UI and API tests. The Web UI tests are built for the SauceDemo website, while the API tests utilize the GoRest API.
- Uses the Gherkin format for writing test cases.
- Implements Cucumber for test execution.
- Separates the Web and API tests into distinct packages.
- Uses Gradle for build automation.
- Integrates with GitHub Actions to run tests on certain events like pull requests.
- Generates HTML and JSON reports using Cucumber.

## Tools and Libraries Used

- **Cucumber**: A testing framework that supports behavior-driven development (BDD) and uses Gherkin for writing test scenarios.
- **Selenium WebDriver**: A tool for automating web browsers, used for the Web UI tests.
- **RestAssured**: A Java library for testing RESTful APIs, used for the API tests.
- **Gradle**: A build automation tool that defines tasks for running tests.
- **GitHub Actions**: A CI/CD tool used to automate the execution of tests on certain events like pull requests.
- **JUnit**: A testing framework for Java used to run the tests.
- **Cucumber Reports**: Generates HTML and JSON reports for test execution.

## Project Structure

The project is organized into this main following structure:

```
src/test/
├── java/
│   ├── feature/
│   │   ├── api.feature
│   │   └── web.feature
│   ├── helper/
│   │   ├── Endpoint
│   │   ├── Models
│   │   └── Utility
│   ├── pages/
│   │   ├── ApiPage
│   │   └── WebPage
│   ├── runner/
│   │   └── TestRunner
│   └── stepDef/
│       ├── ApiStep
│       ├── Hooks
│       └── WebStep
├── resources/
│   └── JSONSchemaData/
│       ├── get_list_users_normal.json
│       └── post_create_new_user.json
├── build.gradle
└── .github/
    └── workflows/
        └── test-automation.yml

```

- **feature**: Contains the Gherkin `.feature` files to define both API and Web UI test scenarios.
    - Api.feature: Defines the test scenarios for API testing.
    - Web.feature: Defines the test scenarios for Web UI testing.
- **helper**: Contains utility and helper classes used across the project.
    - Endpoint: Stores API endpoint URLs.
    - Models: Contains data models used for API testing.
    - Utility: Provides general-purpose utility functions, such as JSON file handling or configurations.
- **pages**: Contains Page Object Model (POM) class for Web UI and API testing.
- **runner**: Contains configurations for running the tests
- **stepDef**: Contains Step Definitions for the Gherkin test scenarios.
    - ApiStep: Implements the steps for API testing.
    - Hooks: Contains setup and teardown configurations (e.g., Before and After hooks).
    - WebStep: Implements the steps for Web UI testing.
- **resources**: Contains supporting files for testing, such as test data for JSON schemas.
- **build.gradle**: Gradle build file that defines tasks for running Cucumber tests.
- **.github/workflows**: Contains the GitHub Actions workflow configuration.

## Gradle Tasks

The following Gradle tasks are defined to run the tests:

**Execute Tests**:
   ```bash
   ./gradlew cucumber
   ```

## Cucumber Reports

The framework generates two types of reports:
1. **HTML Report**: Located in `reports/cucumber-report.html` after tests are executed.
2. **JSON Report**: Located in `reports/cucumber-report.json`.

## GitHub Actions Workflow

The repository includes a GitHub Actions workflow that runs the tests on two events:
1. **Manual Trigger**: You can manually trigger the tests through the GitHub Actions UI.
2. **Pull Request**: The tests will automatically run when a pull request is made to the repository.

The workflow is defined in `.github/workflows/test-automation.yml`.

## How to Run the Tests

To run the tests locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/Automation-Saucedemo.git
   cd Automation-Saucedemo
   ```

2. **Build the Project**:
   Run the following Gradle command to build the project:
   ```bash
   ./gradlew build
   ```

3. **Run the Tests**:
   To run all tests:
   ```bash
   ./gradlew cucumber
   ```

4. **Check the Reports**:
   After the tests run, the reports will be available in:
   - `reports/cucumber-report.html` (HTML report)
   - `reports/cucumber-report.json` (JSON report)
