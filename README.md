# clipboard-health-test-automation-framework

The Clipboard Health Test Automation Framework allows automating UI at scale. Easily automate Amazon Website Test.

#### Table of Contents
1.  [Description](#description)
2.  [Installation](#installation)
3.  [Usage](#usage)
4.  [Reporting Issues](#reporting-issues)
5.  [License](#license)

## <a id="description"></a>Description

Clipboard Health Test Automation Framework combines environment variables commonly available during CI/CD. This allows for defining specific type of browser that can be triggered during different stages of the CI/CD pipeline.

## <a id="installation"></a>Installation

```bash
git pull https://github.com/rafliputraa/clipboard-health-test-automation-framework.git
```

## <a id="usage"></a>Usage

Execute command with the following values:
*   Chrome
```bash
mvn test -Dbrowser=chrome
```
*   Firefox
```bash
mvn test -Dbrowser=firefox
```
*   Headless Chrome
```bash
mvn test -Dbrowser=chrome-headless
```
*   Headless Firefox
```bash
mvn test -Dbrowser=firefox-headless
```
*   Internet Explorer
```bash
mvn test -Dbrowser=internet-explorer
```

## <a id="reporting_issues"></a>Reporting Issues

Issues should be reported in the GitHub repo's issue tab. Include a link to it.

## <a id="license"></a>License

This is code is licensed under the Apache License 2.0. Full license is available [here](./LICENSE).
