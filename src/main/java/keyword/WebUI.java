package keyword;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUI {

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

}
