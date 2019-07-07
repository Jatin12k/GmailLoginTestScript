package LoginTestGmail.LoginTestGmail;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyLoginTest {
	
	LoginPage lPage;
	private WebDriver driver;
	
	String url = ExcelFileReader.getExcelData("URL", 1, 2);
	String un = ExcelFileReader.getExcelData("LoginCredentials", 1, 2);
	String pwd = ExcelFileReader.getExcelData("LoginCredentials", 1, 3);
	
	@BeforeTest(description="Opening firefox browser")
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "e:\\geckodriver.exe");
	    driver = new FirefoxDriver();
		}
	
	@Test(description="Login to Gmail with Valid Data")
	public void TC01_VerifyloginWithValidData() throws Exception{
		lPage = new LoginPage(driver);
		lPage.loginToGmail(url, un, pwd);
		String homePageTitle = ExcelFileReader.getExcelData("Titles", 2, 2);
		assertTrue(driver.getTitle().equals(homePageTitle));
	}
	
	@Test(description="Logout from application")
	public void TC02_VerifyLogOut() {
		lPage = new LoginPage(driver);
        lPage.logOut();
        String loginPageTitle = ExcelFileReader.getExcelData("Titles", 1, 2);
        assertTrue(driver.getTitle().contains(loginPageTitle));
	}
	
    @AfterTest(description="Close broser")
	public void closeBrowser() {
		driver.close();
	}
}

