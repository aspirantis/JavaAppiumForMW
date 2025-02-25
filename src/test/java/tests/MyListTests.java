package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.mobile_web.MWNavigationUI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyListTests extends CoreTestCase
    {
        private static final String
            login = "learnqa",
            password = "123qweASD";


    @Test
    @Features(value={@Feature(value="Save artilces to the reading list")})
    @DisplayName("Save two articles in reading list of the app")
    @Description("Save 'Java (programming language)' and 'Appium' articles to the reading list")
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    @Severity(value=SeverityLevel.NORMAL)
    public void testSaveTwoArticlesToMyListAndDeleteOneAfter() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        SearchPageObject.initSearchInputMW();
        SearchPageObject.typeSearchLineMW("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.clickByArticleWithSubString("Java (programming language)");

        ArticlePageObject.waitForTitleElement1();
        String first_article_title = ArticlePageObject.getArticleTitle1();
        String name_of_reading_list = "My Reading List";

        if (lib.Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyListFirstTime(name_of_reading_list);
        } else if (lib.Platform.getInstance().isMW()) {
            ArticlePageObject.addArticleToMySaved();
        }

        if (lib.Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Thread.sleep(5);
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            Auth.skipPasswordChange();

            ArticlePageObject.waitForTitleElement1();
            assertEquals("We are not on the same page after login!", first_article_title, ArticlePageObject.getArticleTitle1());

            ArticlePageObject.addArticleToMySaved();
        }

        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        if (lib.Platform.getInstance().isAndroid()){
            MyListsPageObject.openReadingListByName(name_of_reading_list);
        }

        MyListsPageObject.swipeByArticleToDelete(first_article_title);

        //тут начался поиск второй статьи
        SearchPageObject.initSearchInputMW();
        SearchPageObject.typeSearchLineMW("Appium");
        SearchPageObject.waitForSearchResult("Appium");
        SearchPageObject.clickByArticleWithSubString("Appium");

        ArticlePageObject.waitForTitleElement2();
        String second_article_title = ArticlePageObject.getArticleTitle2();

        if (lib.Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyListFirstTime(name_of_reading_list);
        } else if (lib.Platform.getInstance().isMW()) {
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.waitForTitleElement2();

        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        ArticlePageObject.waitForTitleElement1();
        ArticlePageObject.waitForTitleElement2();
        MyListsPageObject.swipeByArticleToDelete(second_article_title);
    }

        @Test
        public void testSaveThreeArticles() throws InterruptedException
        {
            SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
            ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

            SearchPageObject.initSearchInputMW();
            SearchPageObject.typeSearchLineMW("Java");
            SearchPageObject.waitForSearchResult("Java (programming language)");
            SearchPageObject.clickByArticleWithSubString("Java (programming language)");

            ArticlePageObject.waitForTitleElement1();
            String first_article_title = ArticlePageObject.getArticleTitle1();
            String name_of_reading_list = "My Reading List";

            if (lib.Platform.getInstance().isAndroid()) {
                ArticlePageObject.addArticleToMyListFirstTime(name_of_reading_list);
            } else if (lib.Platform.getInstance().isMW()) {
                ArticlePageObject.addArticleToMySaved();
            }

            if (lib.Platform.getInstance().isMW()) {
                AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
                Auth.clickAuthButton();
                Thread.sleep(5);
                Auth.enterLoginData(login, password);
                Auth.submitForm();
//                Auth.skipPasswordChange();

                ArticlePageObject.waitForTitleElement1();
                assertEquals("We are not on the same page after login!", first_article_title, ArticlePageObject.getArticleTitle1());

                ArticlePageObject.addArticleToMySaved();
            }

            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();

            if (lib.Platform.getInstance().isAndroid()){
                MyListsPageObject.openReadingListByName(name_of_reading_list);
            }

            MyListsPageObject.swipeByArticleToDelete(first_article_title);

            //тут начался поиск второй статьи
            SearchPageObject.initSearchInputMW();
            SearchPageObject.typeSearchLineMW("Appium");
            SearchPageObject.waitForSearchResult("Appium");
            SearchPageObject.clickByArticleWithSubString("Appium");

            ArticlePageObject.waitForTitleElement2();
            String second_article_title = ArticlePageObject.getArticleTitle2();

            if (lib.Platform.getInstance().isAndroid()) {
                ArticlePageObject.addArticleToMyListFirstTime(name_of_reading_list);
            } else if (lib.Platform.getInstance().isMW()) {
                ArticlePageObject.addArticleToMySaved();
            }

            ArticlePageObject.waitForTitleElement2();

            //тут начался поиск третьей статьи
            SearchPageObject.initSearchInputMW();
            SearchPageObject.typeSearchLineMW("Selenium");
            SearchPageObject.waitForSearchResult("Selenium");
            SearchPageObject.clickByArticleWithSubString("Selenium");

            ArticlePageObject.waitForTitleElement3();
            String third_article_title = ArticlePageObject.getArticleTitle3();

            if (lib.Platform.getInstance().isAndroid()) {
                ArticlePageObject.addArticleToMyListFirstTime(name_of_reading_list);
            } else if (lib.Platform.getInstance().isMW()) {
                ArticlePageObject.addArticleToMySaved();
            }

            ArticlePageObject.waitForTitleElement3();


            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();

            ArticlePageObject.waitForTitleElement1();
            ArticlePageObject.waitForTitleElement2();
            ArticlePageObject.waitForTitleElement3();
        }
}
