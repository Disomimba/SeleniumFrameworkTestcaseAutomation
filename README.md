# Selenium WebDriver Automation Framework

## Group Members
* **Carranza, Yves Kylle Genesis C.**
* **Disomimba, Abdul Malik P.**
* **Rivera, Keneth James E.**

## Brief Project Description
This project is a robust Selenium Automation Framework designed to perform End-to-End (E2E) testing on the Automation Exercise website. The framework strictly implements the Page Object Model (POM) design pattern. It separates UI locators (Page Objects) from test logic (Page Events), ensuring the code is clean, readable, and highly maintainable. It includes 26 automated test cases covering registration, login, cart management, checkout, and contact form submissions.

## Technologies Used
* **Java:** Core programming language.
* **Selenium WebDriver:** For browser automation.
* **TestNG:** For test execution and assertions.
* **Maven:** For project building and dependency management.
* **ExtentReports:** For generating visual HTML test reports.

## Instructions on How to Set Up and Run the Project

### 1. Prerequisites
Ensure you have the following software installed on your computer:
* **Java Development Kit (JDK):** Version 21 (or Version 11 as configured in the pom.xml).
* **Maven:** To handle project dependencies.
* **IDE:** VS Code (with the "Extension Pack for Java" installed).
* **Git:** To clone the repository.
* **Google Chrome:** The browser where the tests will execute.

**System Variable Setup (Windows):**
* Add a new System Variable named `JAVA_HOME` with the value pointing to your JDK folder (e.g., `C:\Program Files\Java\jdk-21`).
* Add a new System Variable named `MAVEN_HOME` with the value pointing to your extracted Maven folder (e.g., `C:\Users\Edmundo Dela Cruz\Downloads\apache-maven-3.9.11-bin\apache-maven-3.9.11`).
* Edit the `Path` variable and add:
  * `%JAVA_HOME%\bin`
  * `%MAVEN_HOME%\bin`
* Open CMD and type `mvn --version` and `java --version` to test if they are working.

### 2. Clone the Repository
Open your terminal or command prompt and run the following command to clone the project to your local machine:
`git clone https://github.com/Disomimba/SeleniumFrameworkTestcaseAutomation.git`

### 3. Open the Project
1. Open VS Code.
2. Select **File > Open Folder** and choose the cloned project folder.
3. Ensure the project is recognized as a Maven Project so the IDE can resolve the dependencies listed in the `pom.xml`.

### 4. Install Dependencies
Once the project is loaded, Maven should automatically download the required libraries (Selenium, TestNG, ExtentReports, etc.).
* Allow the "Extension Pack for Java" in VS Code to load and resolve the `pom.xml` dependencies automatically.

### 5. Run the Automation
1. Click on the **Testing** icon (the flask symbol) in the left Activity Bar of VS Code.
2. In the Testing panel, expand the test tree: `seleniumdemoframework` > `regression` > `TestCases`.
3. **To run all tests:** Click the "Run Tests" (Play button) at the very top of the Testing panel, or hover over the `TestCases` class and click its play button.
4. **To run a single test:** Hover over an individual test (e.g., `tc_01_Register`) and click the play button next to it.
5. The browser will automatically launch, execute the automated steps, capture screenshots, and safely close.

### 6. View the Test Report
Once the execution is completely finished:
1. Refresh your project folder in VS Code.
2. Navigate to the automatically generated `Reports/` folder.
3. Open the folder corresponding to your browser run (e.g., `REGRESSION_CHROME`).
4. Right-click on the generated `_TESTING.html` file, select **Reveal in File Explorer** (or copy the path), and open it with a Web Browser to view your detailed test results and the attached screenshots.
