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

public class ChangeAppConditionTests extends CoreTestCase
{
    @Test
    @Features(value={@Feature(value="Change of application conditions")})
    @DisplayName("Change screen orientation on search results screen")
    @Description("Rotate 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    @Severity(value=SeverityLevel.MINOR)
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
        Assert.assertEquals(
                "Article title have been change after screen rotation!",
                title_before_rotation,
                title_after_rotation);
        this.rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle1();
        Assert.assertEquals(
                "Article title have been change after screen rotation!",
                title_before_rotation,
                title_after_second_rotation);
    }

    @Test
    @Features(value={@Feature(value="Change of application conditions")})
    @DisplayName("Move application in background mode after searching of article")
    @Description("Background mode for app after searching of 'Java (programming language) article")
    @Step("Starting test testSearchTestArticleInBackground")
    @Severity(value=SeverityLevel.MINOR)
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
