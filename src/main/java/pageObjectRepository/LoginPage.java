package pageObjectRepository;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilitities.ConfigReader;
import utilitities.ExcelDataReader;

public class LoginPage {

        private WebDriver driver;

        public LoginPage(WebDriver Driver) {

            this.driver = Driver;
        }

        // Locators

        private By loginHeader = By.xpath("//p[text()='Please login to LMS application']");
        private By userLabel = By.xpath("//span[text()='User']");
        private By userField = By.xpath("//input[@id='username']");
        private By userAstrek = By.xpath("//label[@id='mat-form-field-label-1']//span[2]");
        private By passwordLabel = By.xpath("//span[text()='Password']");
        private By passwordFiled = By.xpath("//input[@id = 'password']");
        private By passwordAstrek = By.xpath("//label[@id='mat-form-field-label-3']//span[2]");
        private By LoginButton = By.xpath("//button[@id='login']");
        private By selectRoleLabel = By.xpath("//span[text()='Select the role']");
        private By selectRoleDropdown = By.xpath("//mat-select[@id='mat-select-0']");
        private By Selectroledropdownitems = By.xpath("//span[@class='mat-option-text']");
        private By SelectroleArrow = By.xpath("//div[@class='mat-select-arrow ng-tns-c161-3']");
        private By Usernamealert = By.xpath("//mat-error[contains(text() , 'user name')]");
        private By Passwordalert = By.xpath("//mat-error[contains(text() , ' Please enter your password ')]");
        private By InvalidURLalertmessage = By.className("message__title");
        private By Iframe = By.xpath("//iframe[1]");//By.tagName("iframe")
        private By Loginform = By.xpath("//mat-card[@class='mat-card mat-focus-indicator']");
        private By adminselection = By.xpath("//span[text()=' Admin ']");

        private static Properties prop;
        private String filePath ="C:\\Users\\rakhy\\Selenium_Hackathon\\SeleniumHackathon_Feb25\\src\\test\\resources\\testData\\Logindata.xlsx";

        private ExcelDataReader reader = new ExcelDataReader();

        public String getpagetitle() {

            return driver.getTitle();

        }

        public void invalidurl() {

            prop = ConfigReader.initializeprop();
            String invalidurl = prop.getProperty("invalidurl");
            driver.get(invalidurl);

        }

        public String getinvalidurlalert() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(Iframe));
            driver.switchTo().frame(iframe);

            // Step 3: Find the element and extract the text
            WebElement messageElement = driver.findElement(InvalidURLalertmessage);
            String messageText = messageElement.getText();
            return messageText;


        }

        public  int getBrokenLinks() throws IOException {

            String url = driver.getCurrentUrl();

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Get response code
            int responseCode = connection.getResponseCode();
            return responseCode;

        }

        public String getusernamelabel() {

            return driver.findElement(userLabel).getText();

        }

        public String getPasswordlabel() {

            return driver.findElement(passwordLabel).getText();

        }


        public List<String> applicationText() throws TesseractException, IOException {
            List<String> linesList = new ArrayList<>();
            try {
                String tessDataPath = "C:\\Users\\rakhy\\Selenium_Hackathon\\SeleniumHackathon_Feb25\\src\\test\\resources\\tessdata";

                // Path to the image file
                String path = "C:\\Users\\rakhy\\Selenium_Hackathon\\SeleniumHackathon_Feb25\\src\\test\\resources\\Testdataforpng\\LMS-logo.jpg";
                File imageFile = new File(path);
                if (!imageFile.exists()) {
                    throw new RuntimeException("Image file not found at: "+ path );
                }

                // Initialize Tesseract
                ITesseract tesseract1 = new Tesseract();
                tesseract1.setDatapath(tessDataPath);
                // Perform OCR
                System.out.println("Starting OCR...");
                String result = tesseract1.doOCR(imageFile);
                //System.out.println(result);
                System.out.println("OCR completed.");

                // Process the result
                result = result.replaceAll("[^a-zA-Z0-9\\s]", "").trim();
                String[] lines = result.split("\n");

                for (String line : lines) {
                    linesList.add(line.trim());
                }

                return linesList; // Return the list of lines
            } catch (TesseractException e) {
                e.printStackTrace();
                linesList.add("Error: " + e.getMessage()); // Add error message to the list
                return linesList;
            }
        }

        public String getLoginHeader() {

            return driver.findElement(loginHeader).getText();

        }

        public Boolean userfieldspresent() {

            return driver.findElement(userField).isDisplayed();

        }

        public Boolean passwordfieldpresent() {

            return driver.findElement(passwordFiled).isDisplayed();
        }

        public String userreqired() {

            return driver.findElement(userAstrek).getText();
        }

        public String passwordrequired() {
            return driver.findElement(passwordAstrek).getText();
        }

        public Boolean Dropdowndisplay() {

            return driver.findElement(selectRoleDropdown).isDisplayed();
        }

        public String dropdownLabel() {

            return driver.findElement(selectRoleLabel).getText();

        }

        public List<String> dropdownitems() {
            driver.findElement(SelectroleArrow).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Selectroledropdownitems));
            List<WebElement> options = driver.findElements(Selectroledropdownitems);
            List<String> optionTexts = new ArrayList<>();
            for(  WebElement option : options)
            {
                optionTexts.add(option.getText());
            }

            //	        	        return options.stream()
//	                      .map(WebElement::getText)
//	                      .collect(Collectors.toList());
            return optionTexts ;


        }

        public boolean inputfields_centeralignment() {

            WebElement form = driver.findElement(Loginform);

            int formX = form.getLocation().getX();
            int formY = form.getLocation().getY();
            int formWidth = form.getSize().getWidth();
            int formHeight = form.getSize().getHeight();

            // Get the position and size of the browser window
            int windowWidth = driver.manage().window().getSize().getWidth();
            int windowHeight = driver.manage().window().getSize().getHeight();

            // Calculate the center of the form
            int formCenterX = formX + formWidth / 2;
            int formCenterY = formY + formHeight / 2;

            // Calculate the center of the browser window
            int windowCenterX = windowWidth / 2;
            int windowCenterY = windowHeight / 2;

            // Check if the form's center is aligned with the center of the window
            return formCenterX == windowCenterX && formCenterY == windowCenterY;

        }
        public boolean loginbutton() {

            return driver.findElement(LoginButton).isDisplayed();

        }

        public String getuserfieldcolor() {

            return driver.findElement(userField).getCssValue("color");

        }

        public String getPasswordcolor() {

            return driver.findElement(passwordFiled).getCssValue("color");

        }

        public void enterValidLogin(String username, String password) {

            driver.findElement(userField).sendKeys(username);
            driver.findElement(passwordFiled).sendKeys(password);

        }
        public void validLogin(String sheetName, int rowNumber) throws InvalidFormatException, IOException {

            List<Map<String, String>> excelData = reader.getData(filePath, sheetName);
            String Username = excelData.get(rowNumber).get("UserName");
            String Password = excelData.get(rowNumber).get("Password");
            enterValidLogin(Username , Password);
            selectrole();
            clicklogin();


        }

        public void clicklogin() {

            driver.findElement(LoginButton).click();
        }

        public void selectrole() {

            driver.findElement(SelectroleArrow).click();
            driver.findElement(adminselection).click();
        }

        public WebElement errormessage() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = null;
            errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
            return errorMessage ;

        }

        public void  enterusername() throws InvalidFormatException, IOException {
            String sheetname = "Sheet1";
            List<Map<String, String>> excelData = reader.getData(filePath, sheetname);
            String Username = excelData.get(2).get("UserName");
            String Password = "";
            enterValidLogin(Username , Password);
            selectrole();
            clicklogin();

        }
        public void  enterpassword() throws InvalidFormatException, IOException {
            String sheetname = "Sheet1";
            List<Map<String, String>> excelData = reader.getData(filePath, sheetname);
            String Password = excelData.get(2).get("Password");
            String username = "";
            enterValidLogin(username ,Password);
            selectrole();
            clicklogin();
        }

        public String getuserrequiredmesg() {

            return driver.findElement(Usernamealert).getText();

        }

        public String getpasswordrequiredmsg() {

            return driver.findElement(Passwordalert).getText();

        }

        public void validloginwithfunctions() throws InvalidFormatException, IOException {

            String sheetname = "Sheet1";
            List<Map<String, String>> excelData = reader.getData(filePath, sheetname);
            String Username = excelData.get(2).get("UserName");
            String Password = excelData.get(2).get("password");
            selectrole();

        }
        public void enterkeys() {

            driver.findElement(LoginButton).sendKeys(Keys.ENTER);
        }

        public void useActions() {
            Actions actions = new Actions(driver);

            // Find the element to hover over
            WebElement elementToHover = driver.findElement(LoginButton);

            // Perform hover action
            actions.moveToElement(elementToHover).perform();
        }

    public void navigateToLoginPage() {
        driver.get("https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login");
    }

    // Below function for Batch functionality, will be removed shortly by Rajasri
    
    public void enterCredentials(String userName, String password) {
        WebElement userNameText = driver.findElement(By.id("username"));
        WebElement passwordText = driver.findElement(By.id("password"));

        userNameText.sendKeys(userName);
        passwordText.sendKeys(password);
    }

    public void selectAdminRole() {
        driver.findElement(By.id("mat-select-0")).click();
        driver.findElement(By.id("mat-option-0")).click();
    }

    public void login() {
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
    }
        
}