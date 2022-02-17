package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import br.com.keeggo.projectkeeggo.page.ProdutoPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;

public class ProdutoLogic {
	
	private ProdutoPage produtoPage;
	
	private ConfigEvidencia configEvidencia;
	
	public ProdutoLogic() {
		this.produtoPage = new ProdutoPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Seleciona um produto
	public void selecionarProduto() {
		final String msg = "\t\t\tLogs: ---- Seleciono um produto ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(this.produtoPage.getBySelecionaProduto(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.produtoPage.getBySelecionaProduto()).click();
	}
	
	// Adiciona um produto ao carrinho
	public void addProdutoCarrinho() {
		final String msg = "\t\t\tLogs: ---- Adiciono um produto ao carrinho ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(this.produtoPage.getByAddCarrinho(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.produtoPage.getByAddCarrinho()).click();
	}
	
	//Clica no Botão para redirecionar para o carrinho
	public void clicoBtnIrParaCarrinho() {
		final String msg = "\t\t\tLogs: ---- Clico para ir para o carrinho de compras ----";
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.produtoPage.getByBtnCheckoutCarrinho()).click();
	}
	
}
