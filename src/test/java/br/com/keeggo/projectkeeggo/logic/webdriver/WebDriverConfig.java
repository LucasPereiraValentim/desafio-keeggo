package br.com.keeggo.projectkeeggo.logic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverConfig {
	
	public static WebDriver browser;
	
	public static WebDriverWait wait;
	
	public static void waitElementToBeClickable(By element, long timeOutInSeconds) {
		wait = new WebDriverWait(browser, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
}
