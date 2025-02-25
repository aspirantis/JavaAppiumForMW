package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject
{
    static {
        READING_LIST_TPL = "css:a.toggle-list-item__anchor.minerva-icon--watchlist";
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]/../../div[contains(@class,'watched')]";
        STAR_ICON_EMPTY = "xpath://a[contains(@class, 'watch-this-article') and @title='Add this page to your watchlist']";
    }

    public MWMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
