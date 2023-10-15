**************************************************READ ME*************************************************


**********************************************************************************************************
Requirement Description

Project Name: Issues Module

Module: Issues

Date of creation: 11-08-2021
**********************************************************************************************************
Detailed Description:
1. Login to the mainspring website.
2. Select the Project Name: CFO_Onsite.
3. Go to Issues and Add Issues
4. Check Functionality of Mandatory Fields
5. Fill the Issues form with all Valid Details and Saving it
6. Fill the Issues form with a missing mandatory field and capture the alert

**********************************************************************************************************

Cohort: INTQEA21SD006 
Team: Team 5
Team Members: 

1)	920618	AnnamTejasree
2)	918275	Immadisetty Akhilandeswari
3)	919269	Naveen Prasath 
4)	920713	Rishika Reddy
5)	919036	Tungala Usha Rani

**********************************************************************************************************
----------------------------------------------------------------------------------------------------------
Folder structure :

Team5_Issues_INTQEA21SD006

BDDCucumberTest

~ src/main/java 
	- base   --> PageBaseClass ( Basic Operations in Automation )

	- pages  --> AddIssue      ( Adding Issue)
		 --> FillIssue     ( Filling Issue)
		 --> HomePage      ( Home Page of mainspring)
	         --> IssuesPage    ( Directs from homepage to issues Page)

        - utils  --> ExtentReport  (Generates Cucumber Maven Report Automatically)
		 --> DriverSetup   (Basic methods for invoking browser)
		 --> ExcelRead     (Reads data from Excel)
		 --> Screenshot    (Takes Screenshot)
		 --> ExtentReport Manager (External Extent Report Methods)
		 --> DateUtil      (Contains TimeStamp and currentTime methods)

~src/test/java   
	- Runner 		--> TestRunner (Runs the Scenarios in Feature File)
	- StepDefinitions       --> StepDefinition (Definitions for Gherkins in Feature File)

~src/main/resources 
 	- config.properties (Modifiable file containing URL and Browser)
	- IssuesFormData.xlsx (Contains data to fill in the Issues form)

~src/test/resoruces
	-Feature  --> Valid.feature (Scenario and Scenario Outline are present in Gherkins Language)

~Reports 
	-Cucumber Maven Report : report-feature-3888287459.html
	-Extent Report : Present in Current_Running_Time.html

~screenshots (Alert Handling Screenshots are present here) 

~target (contains Cucumber Generated Reports)

~test-output (automatically generated emailable testNG report)

~pom.xml (contains all the dependancies)

~testNG.xml (Execution file)

**********************************************************************************************************

Steps to execute :

1. testNG.xml -> Run as -> TestNG Suite

**********************************************************************************************************

Note:

1. After the Login page is opened, the user should enter the credentials and OTP to login to the site.
2. HTML reports is in : Reports
3. Check the screenshots of the application in : screenshots