# OpenCart API Automation Framework (REST Assured)

This is a **REST Assured** based API Automation Framework for testing **OpenCart APIs**. The framework is designed with modularity and maintainability in mind, utilizing **TestNG**, **Maven**, and **Allure Reports**.

---

## Features

- REST Assured-based API automation
- Modular and layered architecture
- TestNG for test management
- Maven for build automation and dependency management
- Allure Reports for elegant test reporting
- Custom assertion utilities
- CI/CD friendly structure

---

## Project Structure

```
opencart-api-automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/                # Base classes (BaseTest, BaseClient)
│   │       ├── clients/             # API request logic (e.g., AuthClient, ProductClient)
│   │       ├── data/                # Payload builders / static data
│   │       └── utils/               # ConfigReader, AssertionUtils, etc.
│   └── test/
│       └── java/
│           ├── testcases/          # TestNG test classes
│           └── listeners/          # Test listeners for reporting/logging
│
├── config.properties                # Config values like base URL and tokens
├── testng.xml                       # TestNG suite configuration
├── pom.xml                          # Maven project and dependency file
└── README.md                        # Project documentation
```

---

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Allure command-line tool (`npm install -g allure-commandline`)
- Git and IDE (IntelliJ/Eclipse)

---

## testng.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCart API Test Suite" verbose="1" parallel="false">
  <test name="OpenCart API Tests">
    <packages>
      <package name="testcases"/>
    </packages>
  </test>
</suite>
```

---

## pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

  <modelVersion>4.0.0</modelVersion>
  <groupId>com.opencart</groupId>
  <artifactId>opencart-api-automation</artifactId>
  <version>1.0.0</version>
  <name>OpenCart API Automation</name>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>5.3.0</version>
    </dependency>
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>json-path</artifactId>
      <version>5.3.0</version>
    </dependency>
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.9.0</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>io.qameta.allure</groupId>
      <artifactId>allure-testng</artifactId>
      <version>2.24.0</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.17.0</version>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <source>11</source>
          <target>11</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.1.2</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
      </plugin>
      <plugin>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-maven</artifactId>
        <version>2.11.2</version>
      </plugin>
    </plugins>
  </build>
</project>
```

---

## How to Run Tests

```bash
mvn clean test
```

To run a specific test class:

```bash
mvn test -Dtest=ClassName
```

---

## Generate Allure Report

```bash
allure serve target/allure-results
```

Or:

```bash
allure generate target/allure-results --clean -o target/allure-report
```

---

## Sample APIs Covered

- Authentication (Token Generation, Login)
- Product APIs (CRUD Operations)
- Customer APIs (CRUD Operations)
- Order APIs (Order Processing, Status Updates)

---

## CI/CD Integration

This framework is CI-friendly and can be easily integrated with:

- Jenkins
- GitHub Actions
- GitLab CI
- Azure Pipelines

---

## Contribution

1. Fork the repo
2. Create a new branch (`feature/your-feature`)
3. Commit your changes
4. Push to the branch
5. Open a pull request

---

## License

This project is licensed under the [MIT License](LICENSE)

---

## Contact

**Author**: Your Name  
**Email**: your.email@example.com  
**LinkedIn**: [https://linkedin.com/in/yourname](https://linkedin.com/in/yourname)
