# com.coursera - Coursera Project

This repository contains a Selenium-based automation framework for testing web applications. The project is built using Java, TestNG, Maven, and other essential libraries. It includes features like test reporting, logging, and data-driven testing.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Logging](#logging)
- [Screenshots](#screenshots)
- [Dependencies](#dependencies)
- [Contributing](#contributing)

---

## Project Structure

The project follows a standard Maven structure:

```
com.coursera
│
├── pom.xml
│
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── coursera
│   │               ├── utils
│   │               └── listeners
│   │
│   └── test
│       ├── java
│       │   └── com
│       │       └── coursera
│       │           ├── testCases
│       │           └── pageObjects
│       │
│       └── resources
│           ├── testData
│           └── config
│
└── reports
    ├── extentReports
    └── test-output
```

- `pom.xml`: Maven configuration file.
- `src/main/java`: Contains Java source files.
- `src/test/java`: Contains test cases and page object classes.
- `src/test/resources`: Contains test data and configuration files.
- `reports`: Generated test reports.

---

## Features

### 1. **Page Object Model (POM)**
   - The project uses the Page Object Model design pattern to separate test logic from UI interactions.
   - All page-related actions are encapsulated in `pageObjects` classes.

### 2. **Data-Driven Testing**
   - Test data is stored in Excel files located in the `testData/` folder.
   - Apache POI is used to read and write Excel files.

### 3. **Logging**
   - Log4j is used for logging test execution details.
   - Logs are stored in the `logs/automation.log` file.

### 4. **Test Reporting**
   - TestNG generates default reports in the `test-output/` folder.
   - ExtentReports is used for detailed and visually appealing HTML reports, stored in the `reports/` folder.

### 5. **Screenshots**
   - Screenshots are captured for failed test cases and stored in the `screenshots/` folder.

### 6. **Parallel Execution**
   - TestNG allows parallel execution of test cases, configured in the `testng.xml` file.

---

## Setup Instructions

### Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- A modern web browser (e.g., Chrome)
- ChromeDriver (compatible with your browser version)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/com.coursera.git
   cd com.coursera
   ```
2. Install dependencies:
   ```bash
   mvn install
   ```
3. Configure your browser and WebDriver.
4. Update test data in the `testData/` folder as needed.

---

## Running Tests

To run the tests, use the following command:

```bash
mvn test
```

This will execute all test cases defined in the `testCases` package.

### Running a Specific Test
To run a specific test class, use the following command:

```bash
mvn -Dtest=TestClassName test
```

Replace `TestClassName` with the name of your test class.

---

## Test Reports

TestNG generates default XML and HTML reports in the `test-output/` folder. Additionally, ExtentReports generates detailed HTML reports, which can be found in the `reports/` folder.

---

## Logging

Log4j is used for logging throughout the test execution. The log file is located at `logs/automation.log`. You can configure the logging level and format in the `log4j2.xml` configuration file.

---

## Screenshots

Screenshots are automatically captured for failed test cases and stored in the `screenshots/` folder. The screenshot file name includes the test case name and the timestamp of the failure.

---

## Dependencies

The project uses the following key dependencies:

- **Selenium WebDriver**: For browser automation.
- **TestNG**: For test configuration and reporting.
- **Maven**: For project build and dependency management.
- **Apache POI**: For reading and writing Excel files.
- **Log4j**: For logging test execution details.
- **ExtentReports**: For generating detailed HTML test reports.

You can find the complete list of dependencies in the `pom.xml` file.

---

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/YourFeature`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Submit a pull request.

Please ensure that your code adheres to the existing coding standards and includes appropriate tests.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgements

- [Selenium](https://www.selenium.dev/)
- [TestNG](https://testng.org/doc/index.html)
- [Maven](https://maven.apache.org/)
- [Apache POI](https://poi.apache.org/)
- [Log4j](https://logging.apache.org/log4j/2.x/)
- [ExtentReports](https://extentreports.com/docs/versions/5/java/)

---

