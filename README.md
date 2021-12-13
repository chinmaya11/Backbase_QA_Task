# BACKBASE API/UI Test Automation - Interview project

Following project is used as an interview evaluation tool. 
It consists of a common API and web UI test automation stack:

- Java 8
- Selenium 3.141.59
- Cucumber 5.6.0
- TestNG 7.1
- Maven 3.6
- RestAssured 4.3

## Installation

Please make sure you have the following tools setup in your local environment:

#### Java 8

- JDK 8 https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- JAVA_HOME environment variable should be set and point to JDK 8

#### Maven

Please make use you have maven 3 installed and available in your command line.
There are many ways to install maven locally:

- download [Maven](https://maven.apache.org/download.cgi) and add to PATH
- MAC: [Homebrew maven formula](https://formulae.brew.sh/formula/maven)
- Windows: [Chocolatey maven package](https://chocolatey.org/packages/maven)

You can verify the proper installation by executing the following command:
```bash
mvn --version
```

#### Verify local environment and execute test

This project contains some sample API as well as UI tests, which can be executed with the following command:
```bash

#### Execute test in GUI mode

To run the BackbaseWEBFeature.feature GUI Smoke tests, which can be executed with the following command:
```bash
mvn test -Dcucumber.options.tags="@Smoke"
```

#### Execute test in headless mode
This project contains some sample UI tests, which can be executed in headless mode being passed while executing a maven goal with the following command:
```bash
mvn test -Dcucumber.options.tags="@Smoke" "-Drunmode=headless"
```

#### Execute API test
Set tag value as tags = { "@API" } in runner class to run API test cases, There is a single TestNG tests runner located in [com.backbase.ta](src/test/java/com/backbase/ta/RunCucumberTest.java) Cucumber options are defined on there.
This project contains some sample API tests, which can be executed in being passed while executing a maven goal with the following command:
```bash
mvn test -Dcucumber.options.tags="@api" "-Drunmode=api"
```

And the result should be as follows:
```bash
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:07 min
[INFO] Finished at: 2019-12-05T15:09:53+01:00
[INFO] ------------------------------------------------------------------------
```

In case of any issues please go though installation guide above or check the Troubleshooting section.

## Project structure

#### Feature files

Gherkin feature files are located in the [resources/features](src/test/resources/features) directory.

#### Step classes

Cucumber steps definitions are located in [com.backbase.ta.steps](src/test/java/com/backbase/ta/steps) package.

#### Page Object Model

Pages and components definition can be found under [com.backbase.ta.pages](src/test/java/com/backbase/ta/pages) package.

#### Utility classes

Utility classes/enums (e.g. WebDriverFactory) can be found under [com.backbase.ta.utils](src/test/java/com/backbase/ta/utils) package.

#### TestNG runner

There is a single TestNG tests runner located in [com.backbase.ta](src/test/java/com/backbase/ta/RunCucumberTest.java) Cucumber options are defined on there.

#### Supported reporting

- XML: target/cucumber-report.xml
- JSON: target/cucumber-report.json
- cukes: target/cukes/index.html