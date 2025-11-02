package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUI_OLD {

    private static int Wait_timeout = 10;

    public static void highlightElement(WebDriver driver, WebElement element) {

        String script = "arguments[0].style.border='3px solid red'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {

        String script = "arguments[0].style.border='3px solid " + color + "'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public static void clickElement(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(Wait_timeout));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();

    }

    public static void clickElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(Wait_timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public static void clickElement(WebDriver driver, By by, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();

    }

    public static void setText(WebDriver driver, By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(Wait_timeout));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(text);
    }

    public static void setText(WebDriver driver, WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(Wait_timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

}
