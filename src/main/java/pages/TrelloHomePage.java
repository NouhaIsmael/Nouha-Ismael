package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrelloHomePage {

    WebDriver driver ;

    public TrelloHomePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//div[@class='YVxoA9yoN2HeNo']")
    private  WebElement createIcon;

    @FindBy (xpath = "//span[@title='Nouha Ismael (nouhaismael2)']")
    private WebElement accountIcon;

    @FindBy (xpath = "//button[@data-test-id='header-member-menu-logout']")
    private WebElement logoutOption;

    public BoardListCardCreateDelete clickOnCreateIcon () {
        createIcon.click();
        return new BoardListCardCreateDelete(driver);
    }

    public void clickOnUserAccountIcon (){
        accountIcon.click();
    }

    public LogoutPage clickOnLogoutOption (){
        logoutOption.click();
        return new LogoutPage(driver);

    }



}

