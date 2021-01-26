@FergusonTests
 Feature: Ferguson Testing
 
 @FergTest1
 Scenario: Introduce Ferguson Homepage
 Given open browser
 And click on item
 Then close browser
 
 
 @FergTest2
 Scenario: Browse for toilet cleaner
 Given opens browser
 And clicks on tools
 And gets shop by industry list
 And Types toilet cleaner
 Then Take picture of first item and close browser
 
 
 @FergTest3
 Scenario: Create account for thermstat and checkout
 Given open the browser
 And Click on Register button
 And Register account
 Then browser close
 
 @FergTest4
 Scenario: Go to Appliances,select Microwave and checkout
 Given Open the appliance link
 And Click Microwave Link
 And Add Microwave to cart
 Then Go to checkout 
 