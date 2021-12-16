package com.poortoys.examples;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReminderUtils {

	public static void displayTray() {
		try {
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
			TrayIcon trayIcon = new TrayIcon(image, "Alert");
			tray.add(trayIcon);
			trayIcon.displayMessage("Time sheet Alert", "Opening timesheet in browser", MessageType.INFO);
		} catch (Exception e) {
			System.out.println("Error in displayTray() : : "+e.getMessage());
		}

	}

	public static String readFile() {
		String data = null;
		try {
			File myObj = new File("D:\\WorkItems\\pass.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
			}
			myReader.close();
		} catch (Exception e) {
			System.out.println("Error in readFile() : : "+e.getMessage());
		}
		return data;
	}

	public static void doAction() {
		System.setProperty("webdriver.gecko.driver", "D:\\WorkItems\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://po.nestdigital.com/intranet/index");
		driver.findElement(By.name("username")).sendKeys("renjith.rajamma");
		driver.findElement(By.name("password")).sendKeys(readFile());
		WebElement searchbutton = driver.findElement(By.name("formbutton:ok"));
		searchbutton.click();
	}

}
