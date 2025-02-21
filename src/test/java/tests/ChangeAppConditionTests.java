package tests;

import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase
{
    @Test
    public void testChangeScreenOrientationOnSearchResults() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.clickByArticleWithTitleAndDescription("Java (programming language)", "Object-oriented programming language");

        String title_before_rotation = ArticlePageObject.getArticleTitle1();

        this.rotateScreenLandscape();

        String title_after_rotation = ArticlePageObject.getArticleTitle1();
        assertEquals(
                "Article title have been change after screen rotation!",
                title_before_rotation,
                title_after_rotation);
        this.rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle1();
        assertEquals(
                "Article title have been change after screen rotation!",
                title_before_rotation,
                title_after_second_rotation);
    }

    @Test
    public void testSearchTestArticleInBackground() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");

        this.backgroundApp(2);

        SearchPageObject.waitForSearchResult("Java (programming language)");
    }
}
