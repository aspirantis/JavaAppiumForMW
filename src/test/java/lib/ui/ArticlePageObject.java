package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE1,
        TITLE2,
        TITLE3,
        FOOTER_ELEMENT,
        SAVE_BUTTON,
        ADD_TO_LIST_BUTTON,
        INPUT_READING_LIST_NAME,
        INPUT_READING_LIST_DESCRIPTION,
        OK_BUTTON,
        VIEW_LIST,
        SEARCH_FROM_ARTICLE;

    public ArticlePageObject(AndroidDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement1()
    {
        return this.waitForElementPresent((TITLE1),"Cannot find article title on page!",10);
    }

    public WebElement waitForTitleElement2()
    {
        return this.waitForElementPresent((TITLE2),"Cannot find article title on page!",10);
    }

    public WebElement waitForTitleElement3()
    {
        return this.waitForElementPresent((TITLE3),"Cannot find article title on page!",10);
    }

    public String getArticleTitle1()
    {
        WebElement titleElement = waitForTitleElement1();
        return titleElement.getText();
    }

    public String getArticleTitle2()
    {
        WebElement titleElement = waitForTitleElement2();
        return titleElement.getText();
    }

    public void swipeToFooter() throws InterruptedException
    {
        this.swipeUpToFindElement((FOOTER_ELEMENT), "Cannot find the end of srticle!", 20);
    }

    public void addArticleToMyListFirstTime(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find Save button!",
                5);

        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot find Add to reading list!",
                5);

        this.waitForElementAndSendKeys(
                INPUT_READING_LIST_NAME,
                "My Reading List",
                "Cannot enter name of the reading list!",
                5);

        this.waitForElementAndSendKeys(
                INPUT_READING_LIST_DESCRIPTION,
                "QA articles",
                "Cannot enter description of the reading list!",
                5);

        this.waitForElementAndClick(
                OK_BUTTON,
                "Can not press OK button!",
                5);

        this.waitForElementAndClick(
                VIEW_LIST,
                "Cannot find saved reading list!",
                5);
    }

    public void addArticleToMyList(String name_of_reading_list)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find Save button!",
                5);

        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot find Add to reading list!",
                5);

        this.openReadingListByName(name_of_reading_list);

        this.waitForElementAndClick(
                VIEW_LIST,
                "Cannot find saved reading list!",
                5);
    }

    public void searchFromArticle()
    {
        this.waitForElementAndClick(
                SEARCH_FROM_ARTICLE,
                "Cannot find search field!",
                5);
    }

    public void assertTitlePresent() throws InterruptedException
    {
        this.assertElementPresent((TITLE2), "There are several elements on page");
    }
}
