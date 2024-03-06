package baseTest;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    public Page page;

    Properties prop;
    public Logger logger;




    @BeforeClass
    public void setUpBrowser() {
        prop = new Properties();
        logger = LogManager.getLogger(this.getClass());
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        logger.info("Opening the browser");

    }

    @AfterClass
    public void closeBrowser() {

        playwright.close();
    }

    public Properties init_prop() throws IOException {
        FileInputStream ip = new FileInputStream("C:\\Users\\delltest03\\POM_DEMO_ARMAN\\src\\main\\resources\\config.properties");
        prop = new Properties();
        prop.load(ip);
        return prop;

    }

}
