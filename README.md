![Contributors](https://img.shields.io/badge/-_Contributors-red.svg?logo=github&style=for-the-badge)

[![Földi Krizsán Ildikó](https://img.shields.io/badge/F%C3%B6ldi%20Krizs%C3%A1n%20Ildik%C3%B3-blue.svg?logo=github)](https://github.com/FoldiKrizsanIldiko)

![LinkedIn](https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555)

[![Static Badge](https://img.shields.io/badge/-_%20F%C3%B6ldi%20Krizs%C3%A1n%20Ildik%C3%B3-grey.svg?logo=linkedin&colorB=555)](https://www.linkedin.com/in/ildiko-foldi-krizsan/)

<br />
<div align="center">
     <img src="src/public/logo.png" alt="Logo">
<h3 align="center">Selenium Easy</h3>
  <p align="center">
Some text needed here
</p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>


## About The Project

<p>
This project is part of the testing curriculum at Codecool school and provides a step-by-step guide on writing tests correctly. 
Since the website has been discontinued, it must be accessed from the webArchive, which can slow down the process.
Due to the webArchive, one of the pages intended for testing was unavailable, so another page is used in the project.
The project is developed using the IntelliJ platform and leverages Selenium for browser automation.

We worked in two sprints. In the first sprint, we formulated, based on the provided user stories, the elements to be used in
the tests and how to validate the success or failure of the tests. 
Initially, I wrote the tests in a single file, which could be run together or separately. 
This file can be found in the early commits at the path: src/test/java/com/test/SeleniumEasyTest.java. 
Later, this file was deleted because in the second sprint, the tests were rewritten in a more transparent and reusable manner, 
following the PageFactory methodology.

Within the pageFactory folder, 5 page elements are enumerated along with their associated methods. 
Method names are crafted following the Keyword Driven Testing approach to ensure clarity for non-expert users.
The project includes several Data Driven Tests, with some of them stored in the resources folder as .csv files. 
Additionally, the Data Validator Test sources its input data from an Excel file.
The Select List Demo Test showcases a Parameterized Test utilizing Enum. 
The most commonly used assertions are demonstrated in the exercises. Importantly, the tests are designed to be fully independent of each other, 
allowing them to be executed individually or as a suite.

Each test class initializes its own browser instance and gracefully closes it upon completion. 
Any dynamically created elements during testing are properly disposed of once the test concludes.
</p>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
* ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
* ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
* ![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)
* ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Getting Started

Please follow next steps to run the tests.

### Installation

1. Clone the repo
```sh
   git clone https://github.com/FoldiKrizsanIldiko/SeleniumEasyTest3SI.git
   ```
1. install maven
2. download it from here : https://maven.apache.org/download.cgi
3. follow the instructions from this page: https://maven.apache.org/install.html
4. for setting the environment variable check this: 
, with simple pressing Run tab

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Usage
5. run the tests with
```
mvn test
```
6. or run tests one by one by declaring specify test
```
mvn test -Dtest=com/codecool/fkildiko/seleniumTest/test/pageFactoryTests/NavigationTest<change this with another test class>
```
7. if you have installed IntelliJ you can run tests easier
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contact

Project
Link: [https://https://github.com/FoldiKrizsanIldiko/SeleniumEasyTest3SI](https://github.com/FoldiKrizsanIldiko/FunFlags)

<p align="right">(<a href="#readme-top">back to top</a>)</p>