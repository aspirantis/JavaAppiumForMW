package tests;

import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListTests extends CoreTestCase
{
    @Test
    public void testSaveTwoArticlesToMyList() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get((AndroidDriver) driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.clickByArticleWithTitleAndDescription("Java (programming language)", "Object-oriented programming language");

        ArticlePageObject.waitForTitleElement1();
        String first_article_title = ArticlePageObject.getArticleTitle1();
        String name_of_reading_list = "My Reading List";
        ArticlePageObject.addArticleToMyListFirstTime(name_of_reading_list);
        ArticlePageObject.waitForTitleElement1();
        NavigationUI.returnToSearchFromArticle();

        //тут начался поиск второй статьи
        ArticlePageObject.searchFromArticle();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForSearchResult("Appium");
        SearchPageObject.clickByArticleWithTitleAndDescription("Appium", "Automation for Apps");
        ArticlePageObject.waitForTitleElement2();
        String second_article_title = ArticlePageObject.getArticleTitle2();
        Thread.sleep(5);
        ArticlePageObject.addArticleToMyList(name_of_reading_list);
        ArticlePageObject.waitForTitleElement2();
        MyListsPageObject.swipeByArticleToDelete(second_article_title);

    }
}
