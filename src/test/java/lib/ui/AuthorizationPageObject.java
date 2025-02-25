package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
//    LOGIN_BUTTON = "xpath://a[contains(@class, 'cdx-button') and contains(@class, 'cdx-button--fake-button') and span[text()='Log in']]",
    LOGIN_BUTTON = "xpath://a[normalize-space(span)='Log in']",

    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "xpath://button[@id='wpLoginAttempt']",
    SKIP_PASSWORD_CHANGE_BUTTON = "css:button#skipReset",
    CAPTCHA = "xpath://div[contains(@class, 'cdx-label')]//span[text()='Retype new password:']";


    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() throws InterruptedException {
        Thread.sleep(3);
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button!", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button!", 5);
    }

    public void enterLoginData(String login, String password) {
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input!", 5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, login, "Cannot find and put a password to the password input!", 5);
    }

    public void submitForm() {
        this.waitForElementPresent(SUBMIT_BUTTON, "Cannot find and click submit auth button!", 5);
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button!", 5);
    }

    public void skipPasswordChange() {
        this.waitForElementPresent(SKIP_PASSWORD_CHANGE_BUTTON, "Cannot find skip button to proceed login!", 10);
        this.waitForElementAndClick(SKIP_PASSWORD_CHANGE_BUTTON, "Cannot find skip button to proceed login!", 10);
    }


}
