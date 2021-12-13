@API
Feature: Sample feature to demonstrate backbase API functionality


  Scenario Outline: Verify user is able to validate the backbase API response
   
   Given User authenticates the API request with USERNAME and PASSWORD
   When User create a new article
   Then User read the new article
   When User update the new article
   Then User delete the new article   
   
Examples:
| Title                     | Description       | Body 	                              | TagList                  |
| How to train your team    | Ever wonder how?  | You have to believe in Automation   |   ["magic", "cool"]      |



  Scenario Outline: Verify user is able to validate the backbase API response for comments to an article
   
   Given User authenticates the API request with USERNAME and PASSWORD
   When User create a new article
   Then User add comments to an article
   Then User read comments from an article
   Then User delete comments for an article   
   
Examples:
| Title                     | Description       | Body 	                              | TagList                  |
| How to train your team    | Ever wonder how?  | You have to believe in Automation   |   ["magic", "cool"]      |


  Scenario Outline: Verify user is able to select favorite article
   
   Given User authenticates the API request with USERNAME and PASSWORD
   When User create a new article
   Then User opted for favourite article
   Then User opted for unfavourite article   
   
Examples:
| Title                     | Description       | Body 	                              | TagList                  |
| How to train your team    | Ever wonder how?  | You have to believe in Automation   |   ["magic", "cool"]      |

  Scenario Outline: Verify User profile
  
   #pass parameter user name here
   Given Get User Profile
   Then Follow User
   Then Unfollow User   
   
Examples:
| Title                     | Description       | Body 	                              | TagList                  |
| How to train your team    | Ever wonder how?  | You have to believe in Automation   |   ["magic", "cool"]      |

