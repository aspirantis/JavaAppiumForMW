package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject
{
    protected static String
        NAVIGATE_UP;

    public NavigationUI(AndroidDriver driver)
    {
        super(driver);
    }

    public void returnToSearchFromArticle()
    {
        this.waitForElementAndClick(
                NAVIGATE_UP,
                "Cannot find return button!",
                5);
        }


}
