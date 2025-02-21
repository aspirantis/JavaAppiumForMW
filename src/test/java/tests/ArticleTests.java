package tests;

import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class ArticleTests extends CoreTestCase
{

    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.clickByArticleWithTitleAndDescription("Java (programming language)", "Object-oriented programming language");
//        тексты для тестов:
//        "Object-oriented programming language"
//        "Automation"
        String article_title = ArticlePageObject.getArticleTitle1();

        assertEquals(
                "We see unexpected title!",
                "Java (programming language)",
                article_title
        );
    }

    @Test
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
