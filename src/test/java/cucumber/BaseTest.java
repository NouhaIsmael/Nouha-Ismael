package cucumber;

import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    private String userDir = System.getProperty("user.dir");
    protected Properties properties= readProperties("trellodata");
    protected String url = properties.getProperty("trelloWebsite");
    protected static LoginPage1 loginPage1;
    protected static LoginPage2 loginPage2;
    protected static BoardListCardCreateDelete trelloPages;
    protected static LogoutPage logoutPage;
    protected static TrelloHomePage trelloHomePage;


    public Properties readProperties(String name) {
        Properties prop = System.getProperties();
        FileInputStream fis = null;
        File file = null;

        try {
            file = new File(userDir+"/resources/"+name+".properties");
            fis = new FileInputStream(file);
            prop.load(fis);
            fis.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return prop;

    }



}
