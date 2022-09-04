package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Hooks extends BaseTest {

    private String screenshotdir = System.getProperty("user.dir")+"/test-output/screenshot";

    @AfterStep
    public void takeSS(Scenario scenario) throws IOException {
        scenario.attach(captureScreenshotBase64(),"Image/png","screenshot");
    }

    @Before
    public void setUpDriver(Scenario scenario) throws IOException {
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        if((new File(screenshotdir).exists()))
            FileUtils.cleanDirectory(new File(screenshotdir));
    }

    @After
    public void tearDownDriver(){
        driver.quit();
    }

    public String captureScreenshotBase64() throws IOException {
        String screenshotBase64 = null;
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);
        FileUtils.copyFile(src,new File(screenshotdir + "image_"+sDate+".png"));

        byte[] fileContent= FileUtils.readFileToByteArray(src);
        screenshotBase64 = "data:image/png;base64"+ Base64.getEncoder().encodeToString(fileContent);
        return screenshotBase64;
    }
}
