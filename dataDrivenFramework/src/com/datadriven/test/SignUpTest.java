package com.datadriven.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class SignUpTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karth\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        
        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407"); // enter url
		}

	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		return testdata.iterator();
	}
	
	
	@Test(dataProvider = "getTestData")
	public void signUpTest(String firstname, String lastName, String phone, String country, 
			String city, String email, String timeforcontact) {
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-1\']"));
		firstName.clear();
		firstName.sendKeys(firstname); // Creating WebElement variable is the best practice

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-2\']")).clear();
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-2\']")).sendKeys(lastName);

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-3\']")).clear();
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-3\']")).sendKeys(phone);

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-4\']")).clear();
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-4\']")).sendKeys(country);

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-5\']")).clear();
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-5\']")).sendKeys(city);

		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-6\']")).clear();
		driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-6\']")).sendKeys(email);

		Select select = new Select(driver.findElement(By.xpath("//*[@id=\'RESULT_RadioButton-9\']")));
		select.selectByVisibleText(timeforcontact);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
