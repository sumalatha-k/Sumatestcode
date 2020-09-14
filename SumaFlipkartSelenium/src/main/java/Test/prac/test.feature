Feature: we are testing the flipkart application 
Scenario: testing the login page
  Given user is present on the login page
	When title of the page is Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!
	Then user enters username and password
	Then clicks on submit button
	Then user is at home page
	
	Scenario: to diplay iphone and store the details in file
  Given user is in the home page
	When user enter iphone in the search box and presses enter
	Then user creates a file
	And user stores details of all the iphoes having max price 40000 
	Then closes the file and the application
	