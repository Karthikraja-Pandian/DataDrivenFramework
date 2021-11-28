package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {

		// webdriver code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karth\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407"); // enter url
		
		// get text data from excel
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\karth\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testdata\\FormTestData.xlsx");
        int rowCount = reader.getRowCount("RegTestData");
        
        reader.addColumn("RegTestData", "status");

        // parameterize code
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			System.out.println("==============");
			String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstname);

			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastname);

			String phone = reader.getCellData("RegTestData", "phone", rowNum);
			System.out.println(phone);

			String country = reader.getCellData("RegTestData", "country", rowNum);
			System.out.println(country);

			String city = reader.getCellData("RegTestData", "city", rowNum);
			System.out.println(city);

			String email = reader.getCellData("RegTestData", "email", rowNum);
			System.out.println(email);

			String timeforcontact = reader.getCellData("RegTestData", "timeforcontact", rowNum);
			System.out.println(timeforcontact);

			// Enter data
			WebElement firstName = driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-1\']"));
			firstName.clear();
			firstName.sendKeys(firstname); // Creating WebElement variable is the best practice

			driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-2\']")).clear();
			driver.findElement(By.xpath("//*[@id=\'RESULT_TextField-2\']")).sendKeys(lastname);

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
			
			reader.setCellData("RegTestData", "status", rowNum, "pass");
		}

	}

}
