# Project Name
AutomationPracticeShop

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)

## General info
There is a fake-store website for training automation tests. My goal is building a framework using Java and Selenium WebDriver. Besides, I use Page Object Model. Each page has a class in the PageObjects folder. Also, I use Selenium Grid to configure browsers version and their instances.

## Screenshots
![Example screenshot](./img/screenshots/screenshot.png)

## Technologies
* Java
* Selenium WebDriver - version 3.141.59
* JUnit - version 5.3.2

## Setup

First method:
1. Clone project repository from GitHub:
git clone https://github.com/igor27g/AutomationPracticeShop.git
2. Open folder with project
3. Open command line
4. Write mvn -version in command line
5. Write mvn install
Tests should run.

Second method:
1. Clone project repository from GitHub:
git clone https://github.com/igor27g/AutomationPracticeShop.git
2. Open folder with project
3. Open project using Intellij
4. Run tests using Intellij

## Code Examples
 @Test
 
    public void addOneProductAndNotAcceptTerms() 
    {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShippingPage shippingPage = homePage.addProductToCart().clickAddToCartButton().confirmSummary()
                .logIn(email, password)
                .buttonProccedClick()
                .NotAcceptTermsAndButtonProccedClick();
        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals("You must agree to the terms of service before continuing."
                        , shippingPage.getTextAlert(), "Wrong text alert")
        );
        
    }

## Status
Project is: _in progress_

## Contact
https://www.linkedin.com/in/igor-grabowski/
