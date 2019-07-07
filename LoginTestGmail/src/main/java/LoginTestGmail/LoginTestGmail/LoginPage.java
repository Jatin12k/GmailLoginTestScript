package LoginTestGmail.LoginTestGmail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** This class contains page objects and action methods of Login Page **/
public class LoginPage {
	
	private WebDriver driver;
	
	/*// Git Hub Elements
	By userNameField = By.id("login_field");
	By passwordField = By.id("password");
	By nextButton = By.xpath("//input[@name='commit']");*/
	
    // Element for Logout
	By profileImage = By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[1]/div[4]/header[1]/div[2]/div[3]/div[1]/div[2]/div[1]/a[1]/span[1]");
	By logoutButton = By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[1]/div[4]/header[1]/div[2]/div[5]/div[4]/div[2]/a[1]");
	
	// Elements for Login Page 
	By userNameField = By.id("identifierId");
	By passwordField = By.xpath("//input[@name='password']");
	
	// Next Button
    By nextButton = By.xpath("//span[contains(text(),'Next')]");
    
    public LoginPage(WebDriver driver){
        this.driver = driver;   
        }
    
    // Enter the User name
    public void typeUsername(String userName){
    	driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(userName);
    }

    // Enter the password 
    public void typePassword(String password) throws InterruptedException{
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    	driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click on Next button
    public void clickOnNextButton(){
        driver.findElement(nextButton).click();
    }
    
    public void loginToGmail(String url, String username, String password) throws InterruptedException, IOException{
    	this.openGmailLoginPage(url);
        this.typeUsername(username);
        this.clickOnNextButton(); 
        this.typePassword(password);
        this.clickOnNextButton();        
    }
    
    public void openGmailLoginPage(String url) throws IOException {
    	driver.navigate().to(url);
    		
    	}
    
    public void logOut() {
    	driver.findElement(profileImage).click();
    	driver.findElement(logoutButton).click();
    }
    
    }
