package cucumber.users;

import cucumber.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage1;

import java.time.Duration;

public class TrelloCreateBoardtStepDefinition extends BaseTest {
    @Given("user navigates to trello website")
    public void user_navigates_to_trello_website() throws InterruptedException {
        driver.get(properties.getProperty("trelloWebsite"));
    }
    @When("user enters valid username {string}")
    public void userEntersValidUsername(String email) {
        loginPage1 = new LoginPage1(driver);
        loginPage1.enterUserEmail(properties.getProperty("email"));
    }
    @And("user click on login as atlassian button")
    public void userClickOnLoginAsAtlassianButton() {
        loginPage2 = loginPage1.clickOnLoginWithAtlassianButton();
    }
    @When("user enters valid password {string}")
    public void userEntersValidPassword(String password) throws InterruptedException {
        loginPage2.enterPassword(properties.getProperty("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        trelloHomePage = loginPage2.clickOnLoginButton();
    }

    @When("user click on create board icon")
    public void userClickOnCreateBoardButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        trelloPages = trelloHomePage.clickOnCreateIcon();
        trelloPages.chooseCreateBoard();
    }

    @And("user click on chosen color")
    public void userClickOnChosenColor() {
        trelloPages.chooseBoardColor();
    }

    @And("user enter board name {string}")
    public void userEnterBoardName(String boardName) {
        trelloPages.enterBoardName(properties.getProperty("boardName"));
    }

    @When("user click on create button")
    public void user_click_on_create_button() {
     trelloPages.clickOnCreateButton();
    }
    @Then("board is created successfully")
    public void boardIsCreatedSuccessfully() {
        Assert.assertTrue(trelloPages.getBoardName().isDisplayed());
    }

   // @When("user click on add list label")
    //public void userClickOnAddListLabel() {
      //  trelloPages.clickOnAddListLabel();}
    @And("user enter list title {string}")
    public void userEnterListTitle(String listTitle) {
        trelloPages.enterListTitle(properties.getProperty("listName"));
    }
    @And("user click on add list button")
    public void userClickOnAddListButton() {
        trelloPages.clickOnAddListButton();
    }
    @Then("list is created successfully")
    public void listIsCreatedSuccessfully() {
        Assert.assertTrue(trelloPages.getListName().isDisplayed());
    }


    @When("user click on add card label")
    public void userClickOnAddCardLabel() {
        trelloPages.clickOnAddCard ();
    }

    @And("user enter card name {string}")
    public void userEnterCardName(String cardTitle) {
        trelloPages.enterCardTitle (properties.getProperty("cardName"));
    }

    @And("user click on add card button")
    public void userClickOnAddCardButton() {
        trelloPages.clickOnAddCardButton();
    }

    @Then("card is added successfully")
    public void cardIsAddedSuccessfully() {
        Assert.assertTrue(trelloPages.getCardTitle().isDisplayed());
    }


    @When("user move to the named card element")
    public void userMoveToTheNamedCardElement() {
        trelloPages.moveToNamedCardElement();
    }

    @And("user click on edit icon")
    public void userClickOnEditIcon() {
        trelloPages.clickOnEditIcon();

    }

    @And("user choose archive card option")
    public void userChooseArchiveCardOption() {
        trelloPages.chooseArchiveOption();
    }
    @Then("card is deleted successfully")
    public void cardIsDeletedSuccessfully() {
        Assert.assertTrue(trelloPages.getCardText().isDisplayed());
    }
    @When("user click on list ellipsis")
    public void userClickOnListEllipsis() {
        trelloPages.clickOnListEllipsis();
    }
    @And("user choose archive list option")
    public void userChooseArchiveListOption() {
        trelloPages.chooseArchiveListOption();
    }
    @Then("list is deleted successfully")
    public void listIsDeletedSuccessfully() {
        Assert.assertTrue(trelloPages.getDeletedList().isDisplayed());
    }

    @When("user hover Over board element name")
    public void userHoverOverBoardElementName() {
        trelloPages.hoverOverEllipsisIcon();
    }

    @And("user click On Ellipsis Icon inside the board name label")
    public void userClickOnEllipsisIconInsideTheBoardNameLabel() {
        trelloPages.clickOnEllipsisIcon();
    }

    @And("user choose cLose board")
    public void userChooseCLoseBoard() {
        trelloPages.chooseCLoseBoard();
    }

    @And("user click On Close Board Pop Up window")
    public void userClickOnCloseBoardPopUpWindow() {
        trelloPages.clickOnCloseBoardPopUp();
    }

    @And("user click On Permanently Delete Link")
    public void userClickOnPermanentlyDeleteLink() {
        trelloPages.clickOnPermanentlyDeleteLink();
    }

    @And("user click On Delete Button")
    public void userClickOnDeleteButton() {
        trelloPages.clickOnDeleteButton();
    }

    @Then("board is deleted successfully")
    public void boardIsDeletedSuccessfully() {
        Assert.assertTrue(trelloPages.getDeletedBoardName().isDisplayed());
    }
}
