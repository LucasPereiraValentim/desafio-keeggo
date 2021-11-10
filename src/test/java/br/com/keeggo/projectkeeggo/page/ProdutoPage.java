package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

public class ProdutoPage {
	
	private final By bySelecionaProduto = By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[1]/img");
	
	private final By byAddCarrinho = By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[4]/button");
	
	private final By byBtnCheckoutCarrinho = By.xpath("//*[@id=\"checkOutPopUp\"]");
	
	public static final String TEXT_NAME_BTN_CHEKOUT = "CHECKOUT";
	
	public By getByProduto() {
		return bySelecionaProduto;
	}

	public By getByAddCarrinho() {
		return byAddCarrinho;
	}
	
	public By getByRedirecionarCarrinho() {
		return byBtnCheckoutCarrinho;
	}
}
