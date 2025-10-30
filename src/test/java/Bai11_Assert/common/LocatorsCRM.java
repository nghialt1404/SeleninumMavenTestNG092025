package Bai11_Assert.common;

public class LocatorsCRM {
    // xpath trang Login
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[@type='submit']";
    public static String checkboxRememberMe = "//input[@id='remember']";
    public static String labelRememberMe = "//label[@for='remember']";

    public static String linkFgpw = "//a[normalize-space()=Forgot Password?]";
    public static String alertErrorMessage = "//div[contains(@class,'alert-danger')]";
    public static String alertEmailRequired = "//div[normalize-space()='The Email Address field is required.')]";
    public static String alertPasswordRequired = "//div[normalize-space()='The Password field is required.']";


    // Locators for Dashboard Page
    public static String menuDashboard = "//span[normalize-space()='Dashboard' and @class='menu-text']";
    public static String menuCustomers = "//span[normalize-space()='Customers' and @class='menu-text']";
    public static String menuContracts = "//span[normalize-space()='Contracts' and @class='menu-text']";
    public static String menuProjects = "//span[normalize-space()='Projects' and @class='menu-text']";
    public static String menuTasks = "//span[normalize-space()='Tasks' and @class='menu-text']";


    // Locators for Customers Page

    public static String buttonNewCustomer = "//a[normalize-space()='New Customer']";
    public static String buttonimportNewCustomer = "//a[normalize-space()='Import Customer']";
    public static String buttonContacts = "//a[normalize-space()='Contacts' and contains(@href,'all_contacts')]";
    public static String headerCustomerPage = "//span[normalize-space()='Customers Summary']";

    public static String inputSearchCustomer = "//div[@id='clients_filter']/descendant::input";
    public static String fristRowItemCustomer = "//table[@id='clients']//tbody/tr[1]/td[3]/a";


    // Locators for  New Customers Page

    public static String inputCompany = "//input[@id='company']";
    public static String inputVatNumber = "//input[@id='vat']";
    public static String inputphone = "//input[@id='phonenumber']";
    public static String inputWebsite = "//input[@id='website']";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputState = "//input[@id='state']";
    public static String inputCity = "//input[@id='city']";
    public static String inputZipcode = "//input[@id='zip']";


    public static String dropdownGroup = "//button[contains(@data-id,'groups_in')]";
    public static String inputSearchGroup = "//button[contains(@data-id , 'groups_in')]/following-sibling::div//input[@type='search']";

    public static String dropdownCurrency = "//button[contains(@data-id , 'default_currency')]";
    public static String inputSearchCurrency = "//button[contains(@data-id , 'default_currency')]/following-sibling::div//input[@type='search']";

    public static String dropdownDefaultLanguage = "//button[contains(@data-id , 'default_language')]";
    public static String optionLanguageDynamic = "//span[normalize-space()='%s']"; //%s giá trị String, %d giá trị số

    public static String dropdownCountry = "//button[contains(@data-id,'country')]";
    public static String inputSearchCountry = "//button[contains(@data-id , 'country')]/following-sibling::div//input[@type='search']";

    public static String buttonSaveandCreatecontact = "//button[normalize-space() ='Save and create contact']";
    public static String buttonSave = "//div[@id='profile-save-section']/descendant::button[normalize-space()='Save']";

    // Locators for  Project Page
    public static String buttonNewProject = "//a[normalize-space()='New Project']";
    public static String buttonGantt = "//a[@data-title='Gantt']";
    public static String buttonReload = "///span[normalize-space()='Export']/following::button[@data-original-title = 'Reload']";
    public static String headerProjectPage = "//span[normalize-space()='Projects Summary']";

    public static String inputSearchProjectCustomer = "//div[@id='projects_filter']/descendant::input[@type='search']";

// Locators for  New Project Page

    public static String inputProjectName = "//input[@id='name']";
    public static String checkboxCalculateProgess = "//label[@for='progress_from_tasks']";


    public static String dropdownCustomer = "//button[contains(@data-id,'groups_in')]";
    public static String getSearchProjectCustomer = "//button[contains(@data-id , 'groups_in')]/following-sibling::div//input[@type='search']";
    public static String dropdownbillingType = "//button[contains(@data-id , 'billing_type')]";
    public static String dropdownStatus = "//button[contains(@data-id , 'status')]";

    public static String inputRateperHour = "//input[@id='project_rate_per_hour']";
    public static String inputEstimatedHour = "//input[@id='estimated_hours']";

    public static String inputStartDate = "//input[@id='start_date']";
    public static String inputDealine = "//input[@id='deadline']";

    public static String checkboxSendProject = "//label[@for='send_created_email']";
    public static String buttonSaveProject = "//div[@id='profile-save-section']//button[normalize-space()='Save']";

    public static String selectxpathLanguage(String language) {
        String xpathLanguage = "//span[normalize-space()='" + language + "']";
        return xpathLanguage;
    }
}
