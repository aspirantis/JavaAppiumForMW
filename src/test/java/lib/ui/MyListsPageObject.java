package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObject extends MainPageObject
{
    protected static String
        READING_LIST_TPL,
        ARTICLE_BY_TITLE_TPL,
        REMOVE_FROM_SAVED_BUTTON,
        STAR_ICON_EMPTY;

    private static String getReadingListXpathByName(String name_of_reading_list)
    {
        return READING_LIST_TPL.replace("{READING_LIST_NAME}", name_of_reading_list);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    private static String getSavedReadingListXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }


    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openReadingListByName(String name_of_reading_list)
    {
        String readingListNameXpath = getReadingListXpathByName(name_of_reading_list);
        this.waitForElementAndClick(
//                ("xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='" + name_of_reading_list + "']"),
                readingListNameXpath,
                "Cannot find created reading list!" + name_of_reading_list,
                5);
    }

    public void swipeByArticleToDelete(String article_title) throws InterruptedException
    {
        String articleXpath = getReadingListXpathByName(article_title);
        this.waitForArticleToAppearByTitle(article_title);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(
                    articleXpath,
                    "Cannot find saved article!",
                    5);
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator, "Cannot click button to remove article from saved", 10);
        }

        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitleAndStar(article_title);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String articleXpath = getReadingListXpathByName(article_title);
        this.waitForElementPresent((articleXpath),"Cannot find saved article by title " + article_title, 15);
    }


    public void waitForArticleToDisappearByTitleAndStar(String article_title)
    {
        String articleXpath = getReadingListXpathByName(article_title);
        this.waitForElementNotPresent((articleXpath),"Saved article still present with title " + article_title, 15);
        this.waitForElementPresent(STAR_ICON_EMPTY, "Cannot find add button in reading list!", 5);
    }


}
