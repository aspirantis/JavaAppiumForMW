package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_SKIP_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:button#searchIcon";
        SEARCH_TEXT = "css:form>input[type='search']";
//        SEARCH_CLOSE_BUTTON = "css:button.cdx-button.cdx-button--size-large.cdx-button--weight-quiet.cdx-button--icon-only.cancel";
//                <button type="button" class="cdx-button cdx-button--size-medium cdx-button--weight-quiet cdx-button--icon-only clear" aria-hidden="true" style="">
        SEARCH_CLOSE_BUTTON = "css:button.cdx-button.cdx-button--size-medium.cdx-button--weight-quiet.cdx-button--icon-only.clear";

        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(normalize-space(text()), 'Object-oriented programming language')]";

        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']" +
                "/*[.//*[@resource-id='org.wikipedia:id/page_list_item_title' and normalize-space(@text)='{TITLE}'] " +
                "and .//*[@resource-id='org.wikipedia:id/page_list_item_description' and normalize-space(@text)='{DESCRIPTION}']]";

        SEARCH_RESULT_ELEMENT = "css:ul.mw-mf-page-list thumbs actionable>li.page-summary";
        SEARCH_EMPTY_RESULTS_ELEMENT = "css:p.without-results";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
