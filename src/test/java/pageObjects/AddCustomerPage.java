package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    public WebDriver ldriver;
    Select s;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }

        By lnkCustomer_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customer')][1]");
        By lnkCustomer_menu_item = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customer')]");

        By btnAddNew = By.xpath("//a[@class='btn btn-primary']");

        By txtEmail = By.xpath("//input[@id='Email']");
        By txtPass = By.xpath("//input[@id='Password']");
        By txtFirstName = By.xpath("//input[@id='FirstName']");
        By txtLastName = By.xpath("//input[@id='LastName']");
        By radioGenderFemale = By.xpath("//input[@id='Gender_Female']");
        By calendarDob = By.xpath("//input[@id='DateOfBirth']");
        By txtCompanyName = By.xpath("//input[@id='Company']");
        By isTaxExempt = By.xpath("//input[@id='IsTaxExempt']");
        By txtNewsLetter = By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/following-sibling::input");
        By txtNewsLetterOptions = By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[@data-offset-index='1']");
        By dropDownCustomerRolesInput = By.xpath("//input[@aria-labelledby='SelectedCustomerRoleIds_label']");
        By dropDownCustomerRoles = By.xpath("//select[@id='SelectedCustomerRoleIds']");
        By dropDownManagerOfVendor = By.xpath("//select[@id='VendorId']");
        By checkBoxActive = By.xpath("//input[@type='checkbox' and @id='Active']");
        By txtAreaAdminComment = By.xpath("//textarea[@id='AdminComment']");
        By buttonSave = By.xpath("//button[@type='submit' and @name='save']");
        By succesAlert = By.xpath("//div[@class='alert alert-success alert-dismissable']");

        //Actions to be performed create methods
        public String getPageTitle(){
            return ldriver.getTitle();
        }

        public void clickOnCustomerMenu(){
            ldriver.findElement(lnkCustomer_menu).click();
        }

        public void clickOnCustomerMenuItem(){
            ldriver.findElement(lnkCustomer_menu_item).click();
        }

        public void clickOnAddNew(){
            ldriver.findElement(btnAddNew).click();
        }

        public void setEmail(String email){
            ldriver.findElement(txtEmail).click();
            ldriver.findElement(txtEmail).sendKeys(email);
        }

        public void setEmail1(String email1){
            ldriver.findElement(txtEmail).click();
            ldriver.findElement(txtEmail).sendKeys(email1);
        }

        public void setPassword(String password){
            ldriver.findElement(txtPass).click();
            ldriver.findElement(txtPass).sendKeys(password);
        }

        public void setFirstName(String firstName){
            ldriver.findElement(txtFirstName).click();
            ldriver.findElement(txtFirstName).sendKeys(firstName);
        }

        public void setLastName(String lastName){
            ldriver.findElement(txtLastName).click();
            ldriver.findElement(txtLastName).sendKeys(lastName);
        }

        public void setGender(){
            ldriver.findElement(radioGenderFemale).click();
        }

        public void setDOB(String dob){
            ldriver.findElement(calendarDob).sendKeys(dob);
        }

        public void setCompanyName(String compName){
            ldriver.findElement(txtCompanyName).sendKeys(compName);
        }

        public void setTaxExempt(){
            ldriver.findElement(isTaxExempt).click();
        }

        public void setNewsLetter(){
            ldriver.findElement(txtNewsLetter).click();
            ldriver.findElement(txtNewsLetterOptions).click();
        }

        public void customerRole(String cusRole){
            ldriver.findElement(dropDownCustomerRolesInput).click();
            WebElement cusRoles = ldriver.findElement(dropDownCustomerRoles);
            new Select(cusRoles);
            s.selectByVisibleText(cusRole);

        }

    public void managerOfVendor(String manager){
        ldriver.findElement(dropDownManagerOfVendor).click();
        WebElement wbManager = ldriver.findElement(dropDownManagerOfVendor);
        new Select(wbManager);
        s.selectByVisibleText(manager);

    }

    public void active(){
        ldriver.findElement(checkBoxActive).click();
    }

    public void adminComment(String comment){
        ldriver.findElement(txtAreaAdminComment).sendKeys(comment);
    }

    public void save(){
        ldriver.findElement(buttonSave).click();
    }

    public String getSuccessfulText(){
        String msg = ldriver.findElement(succesAlert).getText();
        return msg;
    }

}
