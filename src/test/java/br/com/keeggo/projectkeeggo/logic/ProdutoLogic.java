package br.com.keeggo.projectkeeggo.logic;

import org.openqa.selenium.WebDriver;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.ProdutoPage;

public class ProdutoLogic extends WebDriverConfig{
	
	private ProdutoPage produtoPage;
	
	private ConfigEvidencia configEvidencia;
	
	public ProdutoLogic(WebDriver browser) {
		super(browser);
		this.produtoPage = new ProdutoPage();
		this.configEvidencia = new ConfigEvidencia();
	}

	public void selecionarProduto() {
		final String msg = "\t\t\tLogs: ---- Seleciono um produto ----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.produtoPage.getByProduto(), 5);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.produtoPage.getByProduto()).click();
	}
	
	public void addProdutoCarrinho() {
		final String msg = "\t\t\tLogs: ---- Adiciono um produto ao carrinho ----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.produtoPage.getByAddCarrinho(), 5);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.produtoPage.getByAddCarrinho()).click();
	}
	
	public CarrinhoLogic clicoBtnIrParaCarrinho() {
		final String msg = "\t\t\tLogs: ---- Clico para ir para o carrinho de compras ----";
		System.out.println(msg);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.produtoPage.getByRedirecionarCarrinho()).click();
		return new CarrinhoLogic(super.browser);
	}
	
}
