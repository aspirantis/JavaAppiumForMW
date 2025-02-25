package tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    @Features(value={@Feature(value="Search")})
    @DisplayName("Search article by title")
    @Description("We open 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testSearch")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

//        SearchPageObject.waitForElementPresent("");
        SearchPageObject.initSearchInputMW();
        SearchPageObject.typeSearchLineMW("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    @Features(value={@Feature(value="Search")})
    @DisplayName("Cancel search article by title")
    @Description("We cancel search of article 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testCancelSearch")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInputMW();
        SearchPageObject.typeSearchLineMW("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCloseSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    @Features(value={@Feature(value="Search")})
    @DisplayName("Search article by title and description")
    @Description("Search of article by title 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testSearchByTitleAndDescription")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testSearchByTitleAndDescription()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInputMW();
        SearchPageObject.typeSearchLineMW("Java");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
    }

}
