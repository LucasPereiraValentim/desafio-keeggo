package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.page.ProdutoPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;

public class ProdutoLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeLogic.class);
	
	private ProdutoPage produtoPage;
	
	private ConfigEvidencia configEvidencia;
	
	public ProdutoLogic() {
		this.produtoPage = new ProdutoPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Seleciona um produto
	public void selecionarProduto() {
		String msg = "Seleciono um produto";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(this.produtoPage.getBySelecionaProduto(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.produtoPage.getBySelecionaProduto()).click();
	}
	
	// Adiciona um produto ao carrinho
	public void addProdutoCarrinho() {
		String msg = "Adiciono um produto ao carrinho";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(this.produtoPage.getByAddCarrinho(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.produtoPage.getByAddCarrinho()).click();
	}
	
	//Clica no Botão para redirecionar para o carrinho
	public void clicoBtnIrParaCarrinho() {
		String msg = "Clico para ir para o carrinho de compras";
		LOG.info(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.produtoPage.getByBtnCheckoutCarrinho()).click();
	}
	
}
