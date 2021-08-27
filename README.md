# Miro Sign up tests

Tools:

- Serenity
- Cucumber
- Selenium WebDriver
- Romankh3

## Java SDK

Compatible with Java 11

## Build tool

Gradle 6.8

## Plugins needed

- Cucumber for Java
- Gherkin
- Lombok

## Run tests

```
gradle clean test -Dcucumber.filter.tags="@Smoke"
```

## Reporting

The Serenity test report can be found here: `/target/site/serenity/index.html`. The report is generated after the tests
finished running

Notes:

- Base URL is configured in the `serenity.conf` file;
- Only chrome driver has been configured
- The following scenarios could have been automated:
    - sign up and accept news and updates
    - check Accept terms pop-up when you select to log in with a 3rd party (compare pictures)
    - navigate to Log in page from Sign up
    - check more password errors/ warnings

* more fields validations could be checked at BE level (if exists)
    
    
