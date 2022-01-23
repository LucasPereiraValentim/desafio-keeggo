package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class ProdutoPage {
	
	private final By bySelecionaProduto = By.xpath("//img[@id='15']");
	
	private final By byAddCarrinho = By.xpath("//button[@name='save_to_cart']");
	
	private final By byBtnCheckoutCarrinho = By.xpath("//button[@id='checkOutPopUp']");
	
	public static final String TEXT_NAME_BTN_CHEKOUT = "CHECKOUT";
}
