package com.weborder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderCopy {
	
	public static String rn() {
		String rn = "";
		for (int i = 0; i < 15; i++) {
			rn += ((int)(Math.random() * ((9 - 0) + 1)) + 0);	
		}
		return rn;
	}
	
	public static String rn(String str) {
		return ((int)(Math.random() * ((100 - 1) + 1)) + 1) + " " + str;
	}
	
	public static char mn() {
		return (char) ('A' + Math.random() * ('Z'-'A' + 1));
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
		"../../Documents/selenium dependencies/drivers/chromedriver");
				
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		Thread.sleep(2000);

		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Order")).click();

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(rn("").trim());

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " +  mn() + " Smith");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(rn("Craigdell rd"));
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Pittsburg");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Pennsylvania");

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(rn().substring(0, 5));

		String rc = "" + ((int)(Math.random() * ((2 - 0) + 1)) + 0);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + rc)).click();

		if (rc.equals("0")) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+rn());
		} else if (rc.equals("1")) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+rn());
		} else {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+rn().substring(1));
		}

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("10/20");
		Thread.sleep(3000);

		driver.findElement(By.linkText("Process")).click();

		String expected = "New order has been successfully added.";
		String text = driver.findElement(By.tagName("body")).getText();
		if (text.contains(expected)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
			System.out.println("Expected:\t" + expected);
		}

	}

}
