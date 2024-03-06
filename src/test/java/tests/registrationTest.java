package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.registrationPgae;

import java.io.IOException;
import java.util.Properties;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class registrationTest extends BaseTest {

    registrationPgae regpage;
    Properties prop;


    @Test
    public void enterRegistrationDetails() throws IOException {
        regpage = new registrationPgae(page);
        //String fname = prop.getProperty("firstname").trim();
        regpage.enterFirstName("Peter");
        regpage.enterLasttName("Parker");
        regpage.enterEmail("peter229@gmail.com");
        regpage.enterTelephone("12435645");
        regpage.enterPassword("123456");
        regpage.enterConfirmPassword("123456");
        regpage.selectCheckbox();
        String msg = regpage.clickOnContinueButton();

        Assert.assertEquals(msg,"Your Account Has Been Created!");
        //testng assertion
        //Assert.assertEquals(url,"https://naveenautomationlabs.com/opencart/index.php?route=account/success");

        page.waitForTimeout(3000);

    }

}
