package br.com.keeggo.projectkeeggo.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverConfig {
	
	public static WebDriver browser;
	
	public static WebDriverWait wait;
	
	public static final String URL_HOME = "https://www.advantageonlineshopping.com/#/";
	
	
	public static void initDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriverConfig.browser = new ChromeDriver();
	}
	
	public static void navigateToURL() {
		WebDriverConfig.browser.navigate().to(URL_HOME);
	}
	
	public static void waitElementToBeClickable(By element, Duration duration) {
		wait = new WebDriverWait(browser, duration);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void waitElementToVisibility(By element, Duration duration) {
		wait = new WebDriverWait(browser, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void scroll(By byElement) {
		WebElement elementMove = browser.findElement(byElement);
		JavascriptExecutor jsScroll = (JavascriptExecutor) browser;
		jsScroll.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", elementMove);
	}
	
	public static void quitBrowser() {
		browser.quit();
	}
	
	
	
}
