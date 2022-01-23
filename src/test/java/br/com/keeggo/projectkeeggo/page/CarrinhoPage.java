package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class CarrinhoPage {
	
	private final By byItensCarrinho = By.cssSelector("#userCart > span");
	
	private final By byBtnRemove = By.xpath("//a[@class='remove red ng-scope']");
	
	private final By btMsgCarrinho = By.xpath("//label[@class='roboto-bold ng-scope']");

	public static final String MSG_CARRINHO = "Your shopping cart is empty";

	
}
