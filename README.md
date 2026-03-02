# GULP Selenium RestAssured Java

This repository contains an automated UI testing framework built with Selenium WebDriver and RestAssured for API testing. It uses Maven as its build tool and TestNG as the test runner. The project appears to focus on login and search functionality with page object models and a driver factory.

## Repository Structure

```
externalJson.json
pom.xml
sample.json
testng.xml
src/
    main/
        java/
            com/selenium/
                pages/        # Page object classes (DashboardPage, LoginPage, SearchPage)
                utils/        # Utility classes (DriverFactory)
    test/
        java/
            com/selenium/tests/  # Test classes (BaseTest, LoginTests)

target/                    # Maven build output
```

## Prerequisites

- Java 8 or higher
- Maven 3.x
- Internet connection to download dependencies and WebDriver binaries

## Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd GULPSeleniumRestAssuredJava
   ```

2. **Run Maven build**
   ```bash
   mvn clean install
   ```
   This will compile the code, run the tests, and package any artifacts.

3. **Execute tests**
   ```bash
   mvn test
   ```
   TestNG configuration is defined in `testng.xml`. You can adjust suites or add parameters as needed.

### 🛠️ Running with a custom configuration file
By default the tests load `config.properties` from the working directory. You can override
this file at runtime by supplying the `configFile` system property to Maven. This allows
switching environments (dev/qa/stage/etc.) without changing source code.

```bash
# example: use a specific properties file anywhere on disk
mvn "-DconfigFile=C:\Users\swath\GULPSeleniumRestAssuredJava\config.properties" test
```

You may also supply additional `-D` properties to override individual values, e.g.:

```bash
mvn "-DconfigFile=src/test/resources/myenv.properties" -Durl=http://example.com test
```

## Test Reports

After running tests, TestNG reports are generated under `target/surefire-reports/`. The HTML report can be opened in a browser:
```
open target/surefire-reports/index.html
```

## Configuration Files

- `testng.xml` – TestNG suite configuration
- `externalJson.json`, `sample.json` – examples of external data used in tests (likely JSON payloads)

## Adding New Tests

1. Create a new page object in `src/main/java/com/selenium/pages`.
2. Add any required utilities to `src/main/java/com/selenium/utils`.
3. Write your test class in `src/test/java/com/selenium/tests` extending `BaseTest`.
4. Update `testng.xml` to include your new test class or suite.

## Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin feature/my-feature`)
5. Open a pull request

## License

This project is licensed under the MIT License. See the `LICENSE` file for details (or add one as needed).

---

*Created on March 2, 2026.*