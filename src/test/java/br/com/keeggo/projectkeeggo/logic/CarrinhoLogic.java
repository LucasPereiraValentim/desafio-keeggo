package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.page.CarrinhoPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;

public class CarrinhoLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(AntesDeLogarLogic.class);

	private CarrinhoPage carrinhoPage;
	
	private ConfigEvidencia configEvidencia;
	
	public CarrinhoLogic() {
		this.carrinhoPage = new CarrinhoPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Verifica se encontra os elementos para validar
	public boolean isAddCarrinho() {
			String msg = "Válido Carrinho";
			LOG.info(msg);
			WebDriverConfig.waitElementToVisibility(this.carrinhoPage.getByItensCarrinho(), Duration.ofSeconds(50));
			this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
			this.configEvidencia.fecharPdf();
			String qtdItensNumber = WebDriverConfig.browser.findElement(this.carrinhoPage.getByItensCarrinho()).getText().substring(0, 1)
					.replace(" ", "");
			int qtdItensCarrinho = Integer.valueOf(qtdItensNumber);
			return qtdItensCarrinho >= 1;
		
	}
	
	// Botão para remover produto do carrinho de compras
	public void clickBtnRemoveProduto() {
		String msg = "Clico em \"Remove\" para remover produto do carrinho de compras";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(this.carrinhoPage.getByBtnRemove(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.carrinhoPage.getByBtnRemove()).click();
	}
	
	// Verifica se encontra os elementos para validar
	public boolean isRemoveCarrinho() {
		String msg = "Valido Carrinho";
		LOG.info(msg);
		WebDriverConfig.waitElementToVisibility(this.carrinhoPage.getBtMsgCarrinho(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		this.configEvidencia.fecharPdf();
		return WebDriverConfig.browser.findElement(this.carrinhoPage.getBtMsgCarrinho()).getText().equals(CarrinhoPage.MSG_CARRINHO);
	
}
	
	

}
