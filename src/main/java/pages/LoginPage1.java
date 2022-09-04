package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage1 {
    WebDriver driver;

    public LoginPage1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);}
    @FindBy (xpath = "//input[@id='user']")
    private WebElement userEmail;

    @FindBy (xpath = "//input[@id='login']")
    private WebElement addAtlassian;

    public void enterUserEmail (String email){
        userEmail.sendKeys(email);
    }
    public LoginPage2 clickOnLoginWithAtlassianButton (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //addAtlassian.click();
        wait.until(ExpectedConditions.visibilityOf(addAtlassian));
        addAtlassian.click();

        return new LoginPage2(driver);
    }


}
