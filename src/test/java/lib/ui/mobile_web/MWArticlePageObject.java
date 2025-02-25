package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
{
    static {
        TITLE1 = "xpath://h1[@id='firstHeading']//span[text()='Java (programming language)']";
        TITLE2 = "xpath://h1[@id='firstHeading']//span[text()='Appium']";
        TITLE3 = "xpath://h1[@id='firstHeading']//span[text()='Selenium (software']";



        FOOTER_ELEMENT = "css:footer";

//        SAVE_BUTTON = "css:button#searchIcon";
//        ADD_TO_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        ADD_TO_LIST_BUTTON = "xpath://a[@id='ca-watch' and contains(@class, 'cdx-button') and contains(@class, " +
                "'menu__item--page-actions-watch') and span[text()='Watch']]";


        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";

        INPUT_READING_LIST_NAME = "css:button#searchIcon";
        INPUT_READING_LIST_DESCRIPTION = "css:button#searchIcon";
        OK_BUTTON = "css:button#searchIcon";
        VIEW_LIST = "css:button#searchIcon";
        SEARCH_FROM_ARTICLE = "css:button#searchIcon";

        CLOSE_ARTICLE_BUTTON = "";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
