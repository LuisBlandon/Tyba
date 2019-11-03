@Service 
Feature: Add Delete Book 
	As a user of the DW Application
  I want to be able to add a new book
  So that I can added

@Service 
Scenario Outline: Add Book 
	Given that the user add the following data to add new book 
		| Name   | Isbn   | Aisle   | Author   |
		| <Name> | <Isbn> | <Aisle> | <Author> |
	When the user perform the add book option 
	Then the add book action result will be "<Result>" and the message will be "<Message>" 
	
	Examples: 
		| Id | Scenario              | Name                               | Isbn   | Aisle    | Author    |   Result  | Message            |
		| 1  | happy path add book   | Learn Appium Automation with Java  | lbbczd | 9232112  | John foe  |   Success | successfully added |
		
@Service 
Scenario Outline: Delete Book 
	Given that the user want to delete book 
	When the user perform the delete book option 
	Then the delete book action result will be "<Result>" and the message will be "<Message>" 
	
	Examples: 
				| Id | Scenario                 |    Result  | Message                      |
				| 1  | happy path delete book   |   Success  | book is successfully deleted |
		