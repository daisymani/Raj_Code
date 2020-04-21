Feature: Check the S2B login Functionality 

Scenario Outline: Login S2B Webpage and Select languages 
	Given User is StoB login page 
	When  User enter the username,groupid and password from excel "<testCaseID>" 
	Then  click the login button 
	
	Examples: 
		| testCaseID |
		| TC01       |
		
			
	