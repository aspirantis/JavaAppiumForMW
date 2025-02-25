package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject
{
    protected static String
        NAVIGATE_UP,
        OPEN_NAVIGATION,
        MY_LISTS_LINK;


    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        } else {
            System.out.println("Method openNavigation do nothinf gor platform " + Platform.getInstance().getPlatformVar());
        }
    }


    public void returnToSearchFromArticle() {
        this.waitForElementAndClick(
                NAVIGATE_UP,
                "Cannot find return button!",
                5);
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(MY_LISTS_LINK, "Cannot find navigation button to my lists!", 5);
        }

        this.waitForElementAndClick(MY_LISTS_LINK, "Cannot find navigation button to my lists!", 5);
    }


}
