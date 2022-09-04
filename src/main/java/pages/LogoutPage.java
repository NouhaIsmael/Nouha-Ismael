package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);}

    @FindBy (xpath = "//button[@id='logout-submit']")
   private WebElement logoutButton;

    @FindBy (xpath = "//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")
    private WebElement loginText;

    public void clickOnLogoutButton (){
        logoutButton.click();
    }

    public WebElement getLoginText (){
        return loginText;
    } // assert that user logged out successfully
}



