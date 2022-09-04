package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage2 {
    WebDriver driver;

    public LoginPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);}

    @FindBy(id = "password")
   private WebElement userPassword;

    @FindBy (xpath = "//button[@id='login-submit']//span[@class='css-19r5em7']")
    private WebElement loginButton;

    public void enterPassword (String password) throws InterruptedException {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(5000);
         Actions builder = new Actions(driver);
         Action moveToElement = builder.moveToElement(userPassword).click(userPassword).build();
         moveToElement.perform();

        //wait.until(ExpectedConditions.elementToBeClickable(userPassword));
        //    userPassword.click();
        userPassword.sendKeys(password);
    }
    public TrelloHomePage clickOnLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@id='login-submit']//span[@class='css-19r5em7']")));
        loginButton.click();
        return new TrelloHomePage (driver);
    }

}
