Feature: Filling Issues Module With Valid Details;

Scenario: User Login to Application
	Given Browser is Invoked 
	Then User goes to https://pratesting.cognizant.com
	Then User Enter credentials to Sign in

Scenario: Navigation to CFO_Onsite Page Scenario
	Given Application Page Title is mainspring
	Then User Navigate to menu icon
	Then User Navigate to CFO_Onsite section and click
	When Application Page Title is Project Details :CFO_Onsite
	Then User Navigate to MONITOR section
	Then User Navigate to Issues Module and click
	Given Application Page Title is Issues List
	Then User Navigate to Add Issue icon and click	
	Then User Checks Save Button is Enabled 
	Then User Checks Save and Add Button is Enabled
	Then User Checks Description limit 
	Then User Checks Save Button is Enabled after filling
	Then User Checks IssueCatagory
	Then User Checks DueDate Limit 
	And User clicks Save button and check for alerts
	Then Handle Alerts
	Then User Checks Return Button 

Scenario: Navigation to CFO_Onsite Page Scenario
	Then User fills all the fields in the Issue Form
	And User clicks Save button 
    Then User Navigate to Add Issue icon and click for second time
	
Scenario Outline: User fill Issues form without filling mandatory details
	When Application Page Title is Issue Details :
	Then User Enter Name "<Name>"
	Then User Enter Select Issue Category "<Issue_Category>"
	Then User Enter Select Responsibility "<Responsibility>"
	Then User Enter Select Severity "<Severity>"
	Then User Enter Select Priority "<Priority>"
	Then User Enter Select Due Date "<Due_Date>"
	Then User Enter Select Issue Type "<Issue_Type>"
	Then User Enter Reported By "<Reported_By>"
	And User clicks Save button and check for alerts
	Then Handle Alerts
	
	Examples: 
      | Name | Issue_Category | Responsibility | Severity | Priority | Due_Date | Issue_Type | Reported_By |
      | Tester1 |	Internal | Tungala Usha Rani | --None-- | High |	15-Aug-2021	| Commercial | Tester |
      | Tester2 |	External | Immadisetty Akhilandeswari | Superficial | --None-- |	15-Aug-2022	| Commercial | Tester |
      | Tester3 |	External | Annam Tejasree | Major | Low | 25-Dec-2021 | Network | |
      | Tester4 | --None-- | Naveen Prasath | Minor | Medium | 19-Oct-2020 | Hardware | Tester |
      | Tester5 |	Internal | --None-- | Major | Low | 27-Aug-2020 | Design | Tester |

Scenario: Close the Browser
	Then Close the Browser


	
