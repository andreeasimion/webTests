# Miro Sign up tests

Tools:

- Serenity - good reporting
- Cucumber
- Selenium WebDrive
- Romankh3 - image-comparison

## Java SDK

Compatible with Java 11

## Build tool

Gradle 6.7.1

## Plugins needed

- Cucumber for Java
- Gherkin
- Lombok

## Run tests

```
gradle clean test -Dcucumber.filter.tags="@Smoke"
```

## Reporting

The Serenity test report can be found here: `target/site/serenity/index.html`.
The report is generated after the tests finished running

Notes:
- Base URL is configured in the `serenity.conf` file;
- Only chrome driver has been configured
- More scenarios could have been automated, but I selected a few of them.
