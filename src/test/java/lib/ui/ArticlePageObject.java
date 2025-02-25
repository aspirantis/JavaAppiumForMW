package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE1,
        TITLE2,
        TITLE3,
        FOOTER_ELEMENT,
        SAVE_BUTTON,
        ADD_TO_LIST_BUTTON,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        INPUT_READING_LIST_NAME,
        INPUT_READING_LIST_DESCRIPTION,
        OK_BUTTON,
        VIEW_LIST,
        SEARCH_FROM_ARTICLE,
        CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Waiting for title element1")
    public WebElement waitForTitleElement1() {
        return this.waitForElementPresent((TITLE1),"Cannot find article title on page!",10);
    }

    @Step("Waiting for title element2")
    public WebElement waitForTitleElement2() {
        return this.waitForElementPresent((TITLE2),"Cannot find article title on page!",10);
    }

    @Step("Waiting for title element3")
    public WebElement waitForTitleElement3() {
        return this.waitForElementPresent((TITLE3),"Cannot find article title on page!",10);
    }

    @Step("Waiting for title of article1")
    public String getArticleTitle1() {
        WebElement titleElement = waitForTitleElement1();
        screenshot(this.takeScreenshot("article1_title"));
        return titleElement.getText();
    }

    @Step("Waiting for title of article2")
    public String getArticleTitle2() {
        WebElement titleElement = waitForTitleElement2();
        screenshot(this.takeScreenshot("article2_title"));

        return titleElement.getText();
    }

    @Step("Waiting for title of article3")
    public String getArticleTitle3() {
        WebElement titleElement = waitForTitleElement3();
        screenshot(this.takeScreenshot("article3_title"));

        return titleElement.getText();
    }



    @Step("Swipe to the footer of article")
    public void swipeToFooter() throws InterruptedException {
        this.swipeUpToFindElement((FOOTER_ELEMENT), "Cannot find the end of article!", 20);
    }

    @Step("Add article to the reading list for the first time")
    public void addArticleToMyListFirstTime(String name_of_folder) {
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

    @Step("Add article to the reading list (regular action)")
    public void addArticleToMyList(String name_of_reading_list) {
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

    public void addArticleToMySaved() throws InterruptedException {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromMyListIfAdded();
        } this.waitForElementAndClick(ADD_TO_LIST_BUTTON, "Cannot find button to add an article in reading " +
                "list after removing it from this list before!", 5);
    }

    public void removeArticleFromMyListIfAdded() throws InterruptedException {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON, "Cannot click button to remove " +
                    "article from saved!", 2);
            this.waitForElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON, "Cannot find button to add article " +
                    "to saved list after removing from this list before! ", 5);
        }
    }

    @Step("Search content from article1")
    public void searchFromArticle() {
        this.waitForElementAndClick(
                SEARCH_FROM_ARTICLE,
                "Cannot find search field!",
                5);
    }

    @Step("Check on presence of the title og article")
    public void assertTitlePresent() throws InterruptedException {
        this.assertElementPresent((TITLE2), "There are several elements on page");
    }

    public void closeArticle() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot close article, cannot find X link!", 5);
        } else {
            System.out.println("Method closeArticle do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
}
