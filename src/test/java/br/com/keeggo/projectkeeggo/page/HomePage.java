package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class HomePage {
	
	private final By byRedirecionaLogin = By.xpath("//a[@id='menuUserLink']");
	
}
