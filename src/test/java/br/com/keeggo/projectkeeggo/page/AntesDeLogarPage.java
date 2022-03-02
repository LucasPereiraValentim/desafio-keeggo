package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class AntesDeLogarPage {
	
	private final By byRedirecionaLogin = By.xpath("//a[@id='menuUserLink']");
	
	private final By byMsgErroLogar = By.xpath("//label[@id='signInResultMessage']");
	
}
