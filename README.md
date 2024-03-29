# Sample Mobile Framework

## Instroduction

## Prerequisites
1. Install Node.js
2. Set up the Android SDK.
3. Clone the project and navigate to its root directory.

### Steps for running test:
1. Install Appium
    ```bash
    npm install -g appium
    appium driver install uiautomator2 
    ```
2. Launch Android emulator(Tests executed `Pixel_6`)
3. mvn clean install
4. Reports can be found in `extent-reports/extent-report.html`

### Main stack:
1. Appium (mobile app automation)
2. TestNG (Test Framework)
3. Extent Report (Reporting)
4. SpringBoot (Dependency Injection)

#### Limitation
1. Parallel execution not supported(requires minor tweaking in Driver Capabilities)
2. No Video Artifacts
