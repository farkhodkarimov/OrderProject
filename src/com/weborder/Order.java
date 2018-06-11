package com.weborder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
		"../../Documents/selenium dependencies/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Order")).click();
		
		// generate random number between 1 - 100
		String rn = "" + ((int)(Math.random() * ((100 - 1) + 1)) + 1);
		
		//driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
		// delete 0 (zero)
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(rn);
		
		char rl = (char) ('A' + Math.random() * ('Z'-'A' + 1));
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " +  rl + " Smith");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Craigdell Rd");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Pittsburg");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Pennsylvania");
		
		String rz = "";
		for (int i = 0; i < 5; i++) {
			rz += ((int)(Math.random() * ((9 - 0) + 1)) + 0);
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(rz);
		
		//11
		String rc = "" + ((int)(Math.random() * ((2 - 0) + 1)) + 0);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + rc)).click();
		//12

		if (rc.equals("0")) {
			String rcn = "4";
			for (int i = 0; i < 15; i++) {
				rcn += ((int)(Math.random() * ((9 - 0) + 1)) + 0);	
			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(rcn);
		} else if (rc.equals("1")) {
			String rcn = "5";
			for (int i = 0; i < 15; i++) {
				rcn += ((int)(Math.random() * ((9 - 0) + 1)) + 0);	
			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(rcn);
		} else {
			String rcn = "3";
			for (int i = 0; i < 14; i++) {
				rcn += ((int)(Math.random() * ((9 - 0) + 1)) + 0);	
			}
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(rcn);
		}
		
		//13
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("10/20");
		
		//14
		driver.findElement(By.linkText("Process")).click();
		
		//15
		Thread.sleep(2000);
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
