 Feature: Testing trello features

  @smokeTest @regression
  Scenario Outline: open users page successfully

    Given user navigates to trello website
    When  user enters valid username "<username>"
    And   user click on login as atlassian button
    When  user enters valid password "<password>"
    And   user clicks on login button
    When  user click on create board icon
    And   user click on chosen color
    And   user enter board name "<boardName>"
    And   user click on create button
    Then  board is created successfully
    #When  user click on add list label
    And   user enter list title "<listName>"
    And   user click on add list button
    Then  list is created successfully
    When  user click on add card label
    And   user enter card name "<cardName>"
    And   user click on add card button
    Then  card is added successfully
    When  user move to the named card element
    And   user click on edit icon
    And   user choose archive card option
    Then  card is deleted successfully
    When  user click on list ellipsis
    And   user choose archive list option
    Then  list is deleted successfully
    When  user hover Over board element name
    And   user click On Ellipsis Icon inside the board name label
    And   user choose cLose board
    And   user click On Close Board Pop Up window
    And   user click On Permanently Delete Link
    And   user click On Delete Button
    Then  board is deleted successfully

    Examples:
    |username |password |boardName| listName |cardName|
    |email    |password    |boardName | listName | cardName|



