package tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Test for articles")
public class ArticleTests extends CoreTestCase
{
    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("Compare article title with expected one")
    @Description("We open 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testCompareArticleTitle")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.clickByArticleWithTitleAndDescription("Java (programming language)", "Object-oriented programming language");

        String article_title = ArticlePageObject.getArticleTitle1();

//        ArticlePageObject.takeScreenshot("article_page");

        Assert.assertEquals(
                "We see unexpected title!",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("Swipe article to the footer")
    @Description("We open article and swipe it to the footer")
    @Step("Starting test testSwipeArticle")
    @Severity(value=SeverityLevel.MINOR)
    public void testSwipeArticle() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.clickByArticleWithTitleAndDescription("Java (programming language)", "Object-oriented programming language");

        ArticlePageObject.waitForTitleElement1();
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testAssertTitlePresent() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForSearchResult("Appium");
        SearchPageObject.clickByArticleWithTitleAndDescription("Appium", "Automation for Apps");
        ArticlePageObject.waitForTitleElement3();
        ArticlePageObject.assertTitlePresent();
    }
}
