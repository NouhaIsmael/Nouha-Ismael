package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardListCardCreateDelete {

    WebDriver driver;
    public BoardListCardCreateDelete(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);}
    @FindBy (xpath = "//button[@data-test-id='header-create-board-button']")
    private WebElement createBoard;
    @FindBy (xpath = "//button[@title='Purple']")
    private WebElement boardColor;
    @FindBy (xpath = "//input[@type='text']")
    private  WebElement boardName;
    @FindBy (xpath = "//button[contains(text(),'Create')]")
    private WebElement createButton;

    @FindBy (xpath = "//div[@id='content']//h1")
    private WebElement trelloIcon;
    @FindBy (xpath = "//span[@class='placeholder']")
    private WebElement addListLabel ;
    @FindBy (xpath = "//input[@placeholder='Enter list title…']")
    private WebElement listTitle;
    @FindBy (xpath = "//input[@value='Add list']")
    private WebElement addListButton;
    @FindBy (xpath = "//a[@class='open-card-composer js-open-card-composer']")
    private WebElement addACard;
    @FindBy (xpath = "//textarea[@placeholder='Enter a title for this card…']")
    private WebElement cardTitle;
    @FindBy (xpath = "//input[@value='Add card']")
    private WebElement addCardButton;
    @FindBy (xpath = "//button[@aria-label='Board actions menu']")

    private  WebElement EllipsisIcon;
    @FindBy (xpath = "//button[@title='Close board...']")
    private  WebElement closeBoard;
    @FindBy (xpath = "//button[normalize-space()='Close']") //button[normalize-space()='Close']
    private WebElement closeBoardPopUp;
    @FindBy (xpath = "//button[normalize-space()='Permanently delete board']")
    private  WebElement permanentlyDelete;
    @FindBy (xpath = "//button[normalize-space()='Delete']")
    private  WebElement deleteButton;
    @FindBy (xpath = "//span[@class='list-card-title js-card-name']")
    private  WebElement namedCard;
    @FindBy (xpath = "//span[@class='icon-sm icon-edit list-card-operation dark-hover js-open-quick-card-editor js-card-menu']")
    private WebElement editIcon;
    @FindBy (xpath = "//a[@class='quick-card-editor-buttons-item js-archive']")
    private WebElement archiveOption;
    @FindBy (xpath = "//a[@aria-label='List actions']")
    private WebElement listEllipsis;
    @FindBy (xpath = "//a[normalize-space()='Archive this list']" )
    private  WebElement archiveList;

    // Delete list inside board //

    public void clickOnListEllipsis (){
        listEllipsis.click();
    }

    public void chooseArchiveListOption (){
        JavascriptExecutor Scroll =(JavascriptExecutor)driver;
        Scroll.executeScript("arguments[0].scrollIntoView();",archiveList);
        archiveList.click();
    }

    public WebElement getDeletedList (){
        return listTitle;
    }

    // Delete Card inside list Methods //
    public void moveToNamedCardElement (){

        Actions builder = new Actions(driver);
        Action moveToElement = builder.moveToElement(namedCard).build();
        moveToElement.perform();
    }

    public void clickOnEditIcon (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(editIcon)).isDisplayed();
        editIcon.click();
    }

    public void chooseArchiveOption (){
        archiveOption.click();
    }

    public WebElement getCardText (){
        return namedCard;

        // will assert that the card field is empty and has no text.
    }

    // Delete Board Methods //

    public void hoverOverEllipsisIcon (){
        Actions builder = new Actions(driver);
        WebElement boardNameElement =
                driver.findElement(By.xpath("//a[normalize-space()='My Task Board']"));
        Action MoveMouseToElement = builder.moveToElement(boardNameElement).moveToElement(EllipsisIcon)
                .click().build();
        MoveMouseToElement.perform();
    }

    public void clickOnEllipsisIcon () {
        EllipsisIcon.click();
    }

    public void chooseCLoseBoard () {
        closeBoard.click();
    }

    public void clickOnCloseBoardPopUp ()
    {
        closeBoardPopUp.click();
    }

    public void clickOnPermanentlyDeleteLink (){
        permanentlyDelete.click();
    }

    public void clickOnDeleteButton (){
        deleteButton.click();
    }

    public WebElement getDeletedBoardName (){
        return boardName;
    }

    // Create card inside list Methods //

    public void clickOnAddCard (){
        addACard.click();
    }

    public void enterCardTitle (String cardtitle){
        cardTitle.sendKeys(cardtitle);
    }

    public void clickOnAddCardButton (){
        addCardButton.click();
    }

    public WebElement getCardTitle (){
        return cardTitle;
    }

    // Create List inside board Methods //
    public void clickOnAddListLabel(){
        addListLabel.click();
    }

    public void enterListTitle (String listitle){
        listTitle.sendKeys(listitle);
    }

    public void clickOnAddListButton (){
        addListButton.click();
    }

    public WebElement getListName (){
        return listTitle;
    }

    // Create Board Methods //
    public void chooseCreateBoard (){
        createBoard.click();
    }
    public void chooseBoardColor (){
        boardColor.click();
    }

    public void enterBoardName (String Name){
        boardName.sendKeys(Name);
    }

    public void clickOnCreateButton (){
        createButton.click();
    }

    public WebElement getBoardName (){

        return boardName;
    }


}
