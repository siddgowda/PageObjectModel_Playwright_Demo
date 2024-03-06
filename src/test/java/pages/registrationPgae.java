package pages;

import com.microsoft.playwright.Page;

public class registrationPgae {

    // 1 Locators
    // 2 Actions
    // No Assertion

    Page page;

    //Constructor
    public registrationPgae(Page page) {
        this.page = page;
    }

    //Locators

    //Persoanl Details
    public String firsttName = "#input-firstname";
    public String lastName = "#input-lastname";
    public String email = "#input-email";
    public String telephone = "#input-telephone";

    //password
    public String password = "#input-password";
    public String confirmPassword = "#input-confirm";

    //Checkbox
    public String checkbox = "//input[@type='checkbox']";

    //button
    public String continueButton = "//input[@class='btn btn-primary']";

    //success message
    public String accountCreated = "//h1[text()='Your Account Has Been Created!']";

    //Actions ------------------------------

    //first name
    public void enterFirstName(String fname) {
        page.locator(firsttName).type(fname);
    }

    //Lastname
    public void enterLasttName(String lname) {
        page.locator(lastName).type(lname);
    }

    //email
    public void enterEmail(String mail) {
        page.locator(email).type(mail);
    }

    //telephone
    public void enterTelephone(String tele) {
        page.locator(telephone).type(tele);
    }

    //password
    public void enterPassword(String pwd) {
        page.locator(password).type(pwd);
    }

    //Confirm password
    public void enterConfirmPassword(String cpwd) {
        page.locator(confirmPassword).type(cpwd);
    }

    //Click on Checkbox
    public void selectCheckbox() {
        page.locator(checkbox).click();
        page.waitForTimeout(3000);

    }

    //Continue button
    public String clickOnContinueButton() {
        page.locator(continueButton).click();
        page.waitForTimeout(3000);

        //String url =  page.url();

        String scuccessMessage = page.locator(accountCreated).textContent();
        return scuccessMessage;

    }


    // https://naveenautomationlabs.com/opencart/index.php?route=account/success
}
