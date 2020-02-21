# Project Name
AutomationPracticeShop

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [Inspiration](#inspiration)

## General info
There is a fake-store website for training automation tests. My goal is building a framework using Java and Selenium WebDriver. Besides, I use Page Object Model. Each page has a class in the PageObjects folder. Also, I use Selenium Grid to configure browsers version and their instances.

## Screenshots
![Example screenshot](./img/screenshot.png)

## Technologies
* Java
* Selenium WebDriver - version 3.141.59
* JUnit - version 5.3.2

## Setup
1. Open folder 'Selenium Server'
2. Run file 'hubstart'
3. Run file 'nodestart'
4. After, you can start tests.

## Code Examples
 @Test
    public void addOneProductAndNotAcceptTerms() {
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