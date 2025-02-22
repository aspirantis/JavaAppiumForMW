package lib.ui;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject
{
    private static final String
            READING_LIST_TPL = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='{READING_LIST_NAME}']";

    protected RemoteWebDriver driver;
    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, int timeOutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public boolean waitForElementNotPresent(String locator, String error_message, int timeOutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClick(String locator, String error_message, int timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, 10);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, int timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, 10);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String error_message, int timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        element.clear();
        return element;
    }

    public void assertElementHasText(String locator, String expected_text, String error_message, int timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
        String actual_text = element.getText();

        Assert.assertEquals(
                error_message,
                expected_text,
                actual_text);
    };

    public List<WebElement> waitForSeveralElementsPresent(String locator, String error_message, int timeOutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void swipeUp (int timeOfSwipe) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int start_x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start_x, start_y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), start_x, end_y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        Thread.sleep(5000);
    }

    public void swipeUpQuick () throws InterruptedException {
        swipeUp(200);
    }

    public void swipeUpToFindElement (String locator, String error_message, int timeOfSwipe) throws InterruptedException
    {
        By by = this.getLocatorByString(locator);
        while (driver.findElements(by).isEmpty())
        {
            swipeUpQuick();
        }
    }

    public void swipeElementToLeft (String locator, String error_message,int max_swipes) throws InterruptedException {
        WebElement element = waitForElementPresent(
               locator,
                error_message,
                10);

        int start_x = 1253;
        int start_y = 1145;
        int end_x = 42;
        int end_y = 1145;


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start_x, start_y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), end_x, end_y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        Thread.sleep(5000);
    }

    public int getAmountOfElements (String locator) throws InterruptedException
    {
        By by = this.getLocatorByString(locator);
        List<WebElement> elements = driver.findElements(by);
        return elements.size();

    }


    public void assertElementNotPresent (String locator, String error_message) throws InterruptedException {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + locator + "' supposed to be present.";
            throw new AssertionError(default_message + " " + error_message);}
    }

    public void assertElementPresent (String locator, String error_message) throws InterruptedException {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements == 0) {
            String default_message = "An element '" + locator + "' supposed to be not present.";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAttribute (String locator, String attribute, String error_message,long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, 10);
        return element.getAttribute(attribute);
    }

    private static String getReadingListXpathByName(String name_of_reading_list)
    {
        return READING_LIST_TPL.replace("{READING_LIST_NAME}", name_of_reading_list);
    }

    public void openReadingListByName(String name_of_reading_list)
    {
//        String readingListNameXpath = getReadingListXpathByName(name_of_reading_list);
        this.waitForElementAndClick(
                ("xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='" + name_of_reading_list + "']"),
//                READING_LIST_TPL,
                "Cannot find created reading list!",
                5);

//        String readingListXpath = READING_LIST_TPL.replace("{READING_LIST_NAME}", name_of_reading_list);
//        By readingListLocator = getLocatorByString(readingListXpath);
//
//        this.waitForElementAndClick(
//                String.valueOf(readingListLocator),
//                "Cannot find created reading list: " + name_of_reading_list,
//                5
//        );
    }

    private By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator " + locator_with_type);
        }
    }

    public String takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("This screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path) {
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }


}
