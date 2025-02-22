package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject
{
    protected static String
        SEARCH_SKIP_ELEMENT,
        SEARCH_INPUT,
        SEARCH_TEXT,
        SEARCH_CLOSE_BUTTON,
        SEARCH_RESULT_BY_SUBSTRING_TPL,
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL,
        SEARCH_RESULT_ELEMENT,
        SEARCH_EMPTY_RESULTS_ELEMENT;


    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String title)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{TITLE}", title);
    }

    private static String getResultSearchElementByTitleAndDescription(String title, String description)
    {
        return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);
    }
    /* TEMPLATES METHODS */

    @Step("Initializing the search field")
    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_SKIP_ELEMENT, "Cannot find and click SKIP button!", 5);
        this.waitForElementAndClick(SEARCH_INPUT, "Cannot find and click search init element!", 5);
        this.waitForElementPresent(SEARCH_INPUT, "Cannot find search init element after clicking!", 5);
    }

    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CLOSE_BUTTON, "Cannot find search close button!", 5);
    }

    @Step("Waiting for search cancel button to disappear")
    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CLOSE_BUTTON, "Search close button is still present!", 5);
    }

    @Step("Clicking button to cancel search result")
    public void clickCloseSearch()
    {
        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON, "Cannot find and click search close button!", 5);
    }

    @Step("Typing '{search_line}' to the search line")
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_TEXT, search_line,"Cannot find and type into search input", 5);
    }

    @Step("Waiting for search results")
    public void waitForSearchResult(String title)
    {
        String search_result_xpath = getResultSearchElement(title);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + title, 5);
    }

    @Step("Waiting for search results and select an article by its title and description")
    public void waitForElementByTitleAndDescription(String title, String description)
    {
        String search_result_xpath = getResultSearchElementByTitleAndDescription(title, description);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title '"
                + title + "' and description '" + description + "'", 5);
    }

    public void clickByArticleWithSubString(String title)
    {
        String search_result_xpath = getResultSearchElement(title);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring ", 10);
    }

    @Step("Clicking on article, selected by title and description")
    public void clickByArticleWithTitleAndDescription(String title, String description)
    {
        String search_result_xpath = getResultSearchElementByTitleAndDescription(title, description);
        this.waitForElementAndClick(search_result_xpath, "Cannot click on article with title '"
                + title + "' and description '" + description + "', 5", 10);
    }

    public int getAmountOfFoundArticles() throws InterruptedException {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Can not find anything by the request", 5);

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULTS_ELEMENT, "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch() throws InterruptedException {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }
}
