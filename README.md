# TemplateFrontend
 
Automation Template Frontend With Java, Selenium, POM (Page Object Model) and SerenityBDD.

## Developer

    Mts. Ing. Raúl Mauricio Portillo Muñoz - QA Automation.

## Installation

### Steps for clone the repository
1. On [GitHub.com](https://github.com/), navigate to the repository home page **"TemplateFrontend by Ral1996"**.
2. Repository home page [TemplateFrontend](https://github.com/Ral1996/TemplateFrontend).
3. Above the list of files, click **<> Code**.
4. Copy the repository URL. 
   1. To clone the repository with **HTTPS**, under **"HTTPS"**, click. 
   2. To clone the repository using an **SSH key**, including a certificate issued by your organization's **SSH certification authority**, click SSH , and then click . 
   3. To clone a repository using **GitHub CLI**, click GitHub CLI , then click.
5. Open Git Bash. 
6. Change the current working directory to the location where you want to clone the directory. 
7. Type `git clone` and paste the URL you copied earlier.

   `git clone https://github.com/Ral1996/TemplateFrontend.git`
8. Press Enter to create the local clone.

   ```bash
   $ git clone https://github.com/Ral1996/TemplateFrontend.git
   > Cloning into Ral1996...
   > remote: Counting objects: 10, done.
   > remote: Compressing objects: 100% (8/8), done.
   > remove: Total 10 (delta 1), reused 10 (delta 1)
   > Unpacking objects: 100% (10/10), done.
   ```
   
### Required to run project on your desktop

1. Download and install [JDK Development Kit 21.0.2](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.msi).
2. Download and install [Apache Maven 3.9.6](https://dlcdn.apache.org/maven/maven-3/3.9.6/source/apache-maven-3.9.6-src.zip).
3. Configure environment variables on your device.
4. Download and install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC/).
5. Install plugins on IntelliJ IDEA **"Cucumber for JAVA"**.
6. Open project in IntelliJ IDEA **"TemplateDashboard"**.

## Run Automation Tests

1. Open window **"Maven"**.
2. Click in terminal icon.
3. Run anything test in a command line:
   1. For Chrome: `mvn clean verify -Denvironment=stage -Dwebdriver.driver=chrome serenity:aggregate`
   2. For Edge: `mvn clean verify -Denvironment=stage -Dwebdriver.driver=edge serenity:aggregate`
   3. For Firefox: `mvn clean verify -Denvironment=stage -Dwebdriver.driver=firefox serenity:aggregate`

**Important:** This project content four files ".properties", for config environments, for example "prod, preprod, stage and dev",
for this case, we have defined configurations for a file "config-stage.properties", the others files not have configs inside.

## Struct project

```
   ├── TemplateFrontend
      ├── drivers
      │   ├── chromedriver.exe
      ├── src
      │   ├── main
      │   ├── test
      │        ├── java
      │              ├── com.ral1996.sv
      │                    ├── asserts
      │                          ├── WebAssert.java
      │                    ├── browsers
      │                          ├── Saucelabs.java
      │                    ├── pages
      │                          ├── LoginPage.java
      │                    ├── steps
      │                          ├── LoginSteps.java
      │                    ├── utilities
      │                          ├── ConfigReader.java
      │                          ├── ProgramConstants.java
      │                    ├── RunnerTest.java
      │        ├── resources
      │              ├── features
      │                    ├── Login
      │                          ├── Login.feature
      │              ├── config-develop.properties
      │              ├── config-preprod.properties
      │              ├── config-prod.properties
      │              ├── config-stage.properties
      │              ├── serenity.conf
      ├── target
      ├── pom.xml
      ├── README.md
      ├── LICENSE
      ├── .gitattributes
      └── .gitignore
```

## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.
