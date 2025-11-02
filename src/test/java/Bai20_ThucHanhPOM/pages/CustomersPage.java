package Bai20_ThucHanhPOM.pages;

import keyword.WebUI_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomersPage extends BasePage {

    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Locators Element trang Customers Page
    private By headerCustomersPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By labelTotalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputphone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputZipcode = By.xpath("//input[@id='zip']");


    private By dropdownGroup = By.xpath("//button[contains(@data-id,'groups_in')]");
    private By inputSearchGroup = By.xpath("//button[contains(@data-id , 'groups_in')]/following-sibling::div//input[@type='search']");

    private By dropdownCurrency = By.xpath("//button[contains(@data-id , 'default_currency')]");
    private By inputSearchCurrency = By.xpath("//button[contains(@data-id , 'default_currency')]/following-sibling::div//input[@type='search']");

    private By dropdownDefaultLanguage = By.xpath("//button[contains(@data-id , 'default_language')]");
    private By optionLanguageVietnamese = By.xpath("//span[normalize-space() = 'Vietnamese'");
    //private By optionLanguageDynamic = By.xpath("//span[normalize-space()='%s']"); //%s giá trị String, %d giá trị số

    private By dropdownCountry = By.xpath("//button[contains(@data-id,'country')]");
    private By inputSearchCountry = By.xpath("//button[contains(@data-id , 'country')]/following-sibling::div//input[@type='search']");

    private By buttonSaveandCreatecontact = By.xpath("//button[normalize-space() ='Save and create contact']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']/descendant::button[normalize-space()='Save']");

    private By alertmessage = By.xpath("//div[@id='alert_float_1']//span[@class='alert-title']");

    // Phương thức của trang Customer Page

    public void selectLanguage(String language) {
        WebUI_OLD.clickElement(driver, dropdownDefaultLanguage);
        String xpathLanguage = "//span[normalize-space()='" + language + "']";
        System.out.println("Selecting language:" + language);
        WebUI_OLD.clickElement(driver, By.xpath(xpathLanguage));

    }

    public void verifyCustomersPageDisplayed() {

        boolean CustomersPageIsDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(headerCustomersPage));
            CustomersPageIsDisplayed = driver.findElement(headerCustomersPage).isDisplayed();
        } catch (Exception e) {
            CustomersPageIsDisplayed = false;
        }
        Assert.assertTrue(CustomersPageIsDisplayed, "Customers Page is not display");
    }

    public void clickMenuCustomersPage() {
        WebUI_OLD.clickElement(driver, menuCustomers);
    }

    public void clickAddNewCustomer() {
        WebUI_OLD.clickElement(driver, buttonAddNewCustomer);
    }

    public void fillDataNewCustomer(String company, String group, String currency, String language, String country) {

        WebUI_OLD.setText(driver, inputCompany, company);
        WebUI_OLD.setText(driver, inputVatNumber, "1404");
        WebUI_OLD.setText(driver, inputphone, "0948432746");
        WebUI_OLD.setText(driver, inputWebsite, "https//anhtester.com");
        WebUI_OLD.setText(driver, inputAddress, "190 Hàng Đẫy");
        WebUI_OLD.setText(driver, inputCity, "Hà Nội");
        WebUI_OLD.setText(driver, inputState, "Hà Nội");
        WebUI_OLD.setText(driver, inputZipcode, "700000");

        // Select Group

        WebUI_OLD.clickElement(driver, dropdownGroup);
        WebUI_OLD.setText(driver, inputSearchGroup, group);
        WebUI_OLD.clickElement(driver, By.xpath("//a[@id='bs-select-1-245' and normalize-space()='" + group + "']"));
        WebUI_OLD.clickElement(driver, dropdownGroup);

        // Select Currency

        WebUI_OLD.clickElement(driver, dropdownCurrency);
        WebUI_OLD.setText(driver, inputSearchCurrency, currency);
        WebUI_OLD.clickElement(driver, By.xpath("//span[contains(text(),'" + currency + "')]"));

        // Select Language

        selectLanguage(language);

        // Select  country
        WebUI_OLD.clickElement(driver, dropdownCountry);
        WebUI_OLD.setText(driver, inputSearchCountry, country);
        WebUI_OLD.clickElement(driver, By.xpath("//span[normalize-space()='" + country + "']"));

        WebUI_OLD.clickElement(driver, buttonSave);

    }

    public void verifyAddNewCustomerSuccess() {

        boolean isAlertDisplay = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(alertmessage));
            isAlertDisplay = driver.findElement(alertmessage).isDisplayed();
        } catch (Exception e) {
            isAlertDisplay = false;
        }
        Assert.assertTrue(isAlertDisplay, "Alert Message is not display");

        String alertText = driver.findElement(alertmessage).getText();
        System.out.println("Alert Messgase: " + alertText);
        Assert.assertEquals(alertText, "Customer added successfully.", "Alert Message does not math expected");
    }

    public void verifyCustomerDetails(String company, String group, String currency, String language, String country) {
        String companyValue = driver.findElement(inputCompany).getAttribute("value");
        System.out.println("Company Value: " + companyValue);
        Assert.assertEquals(companyValue, company, "Company value not match");

        String vatValue = driver.findElement(inputVatNumber).getAttribute("value");
        System.out.println("Vat Value: " + vatValue);
        Assert.assertEquals(vatValue, "1404", "Vat value not match");

        String phoneValue = driver.findElement(inputphone).getAttribute("value");
        System.out.println("Phone Value: " + phoneValue);
        Assert.assertEquals(phoneValue, "0909420454", "Phone value not match");

        String websiteValue = driver.findElement(inputWebsite).getAttribute("value");
        System.out.println("Website Value: " + websiteValue);
        Assert.assertEquals(websiteValue, "https//anhtester.com", "Website value not match");
        // giá trị nào nằm trong thẻ input thì phải xài getAtribute, còn nằm trong thẻ khác thì dùng getText


    }


}
