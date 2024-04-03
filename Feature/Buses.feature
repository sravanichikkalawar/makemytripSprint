Feature: MakeMyTrip 
Scenario: Select busses to book
Given I am on home page
When I select the busses
And I choose the Starting from "Hyderabad,Telangana" 
And I choose the destination To "Goa"
And I choose the date "15 Apr 2024"
And I click on the search button
Then I should see available buses

Scenario: Select the best bus
Given I am on home page
When I select the busses
And I choose the Starting from "Hyderabad,Telangana"
And I choose the destination To "Goa"
And I choose the date "15 Apr 2024"
And I click on the search button
And I select filter like Ac type 
And I select filter like Seat type
Then I should be able see the available busses 

Scenario: selecting pickup point
Given I am on home page
When I select the busses
And I choose the Starting from "Hyderabad,Telangana"
And I choose the destination To "Goa"
And I choose the date "15 Apr 2024"
And I click on the search button
And I select filter like Ac type 
And I select filter like Seat type
And I click pickup point as "Lakidikapul"
Then I should be able see the available busses according to preference

Scenario: select travel operater
Given I am on home page
When I select the busses
And I choose the Starting from "Hyderabad,Telangana"
And I choose the destination To "Goa"
And I choose the date "15 Apr 2024"
And I click on the search button
And I select filter like Ac type 
And I select filter like Seat type
And I click pickup point as "Lakidikapul"
And I click on travel operater as "IntrCity SmartBus" 
And I click on drop point as "Panjim"
Then I should see the buses from the travelers only


Scenario: Select Seats
Given I am on home page
When I select the busses
And I choose the Starting from "Hyderabad,Telanagana "
And I choose the destination To "Goa"
And I choose the date "15 Apr 2024"
And I click on the search button
And I select filter like Ac type
And I select filter like Seat type
And I click pickup point as "Lakidikapul"
And I click on travel operater as "IntrCity SmartBus" 
And I click on drop point as "Panjim"
And I click on select seats
Then I should see the seats available in bus




