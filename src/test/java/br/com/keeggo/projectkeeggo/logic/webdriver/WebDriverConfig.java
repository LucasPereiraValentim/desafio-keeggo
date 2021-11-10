package br.com.keeggo.projectkeeggo.logic.webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;

public class WebDriverConfig {
	
	protected WebDriver browser;
	
//	private ConfigEvidencia configEvidencia;
	
	public WebDriverConfig(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		if (browser == null) {
			this.browser = new ChromeDriver();
			this.browser.navigate().to("https://www.advantageonlineshopping.com/#/");
		} else {
			this.browser = browser;
		}
		
	}
	
	protected void waitElement(By element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(this.browser, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void waitElementToBeClickable(By element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(this.browser, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void fecharBrowser() {
		this.browser.quit();
	}
	
}
