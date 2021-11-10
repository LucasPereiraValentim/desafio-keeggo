package br.com.keeggo.projectkeeggo.logic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.keeggo.projectkeeggo.page.CadastroPage;

public class WebDriverConfig {
	
	protected WebDriver browser;
	
	protected WebDriverWait wait;
	
	protected WebDriverConfig(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		if (browser == null ) {
			this.browser = new ChromeDriver();
			this.browser.navigate().to(CadastroPage.URL_HOME);
		} else {
			this.browser = browser;
		}	
}
	
	public void waitElementToBeClickable(By element, long timeOutInSeconds) {
		this.wait = new WebDriverWait(browser, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void fecharBrowser() {
		this.browser.quit();
	}
	
}
