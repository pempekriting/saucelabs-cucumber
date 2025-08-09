# Saucelabs Cucumber Automation Project

This project is a sample automation framework for mobile testing using Appium, Cucumber, Selenium, and TestNG. It demonstrates best practices for structuring automated tests, page objects, and hooks for Android applications.

## Features
- Mobile automation with Appium (Android)
- BDD test scenarios using Cucumber
- Page Object Model for maintainable test code
- TestNG integration for test execution
- Allure reporting for rich test results
- Faker library for test data generation

## Project Structure
```
src/
  main/java/org/saucelabs/
    constants/         # Project constants
    context/           # Test context management
    driver/            # Driver setup (Android)
    pages/             # Page Object classes
  test/java/
    hooks/             # Cucumber hooks
    runner/            # Test runner
    steps/             # Step definitions
  resources/
    apk/               # Test APKs
    features/          # Cucumber feature files
```

## Getting Started
### Prerequisites
- Java 18+
- Maven 3.6+
- Android emulator/device

### Setup
1. Clone the repository:
   ```sh
   git clone <repo-url>
   cd saucelabs-cucumber
   ```
2. Start the Appium server locally and install the UIAutomator2 driver:
   - Make sure you have Appium installed. If not, install it using:
     ```sh
     npm install -g appium
     ```
   - Start the Appium server:
     ```sh
     appium
     ```
   - Install the UIAutomator2 driver (required for Android automation):
     ```sh
     appium driver install uiautomator2
     ```
   - Configure your Android device/emulator and place the APK in `src/test/resources/apk/`.
   - Ensure your device/emulator is running and accessible by Appium.
3. Install dependencies:
   ```sh
   mvn clean install
   ```

### Running Tests
Run all tests with Maven:
```sh
mvn test
```

## Evidence Recording

[Video](https://drive.google.com/drive/folders/1SWglgixa5DsJti6LuJCnJcoH0rfWEx0l?usp=sharing)

### Test Reports
- **Allure Report:**
  After running tests, generate the Allure report:
  ```sh
  mvn allure:serve
  ```
- **Cucumber Report:**
  See HTML/JSON/XML reports in `target/cucumber-report/`.

## Customization
- Update device/emulator configuration in driver classes.
- Add new feature files in `src/test/resources/features/`.
- Extend page objects for new screens.
