package br.com.keeggo.projectkeeggo.logic;

import org.openqa.selenium.WebDriver;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.CarrinhoPage;

public class CarrinhoLogic extends WebDriverConfig{

	private CarrinhoPage carrinhoPage;
	
	private ConfigEvidencia configEvidencia;
	
	public CarrinhoLogic(WebDriver browser) {
		super(browser);
		this.carrinhoPage = new CarrinhoPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Verifica se encontra os elementos para validar
	public boolean isAddCarrinho() {
			final String msg = "\t\t\tLogs: ---- Valido Carrinho ----";
			System.out.println(msg);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.configEvidencia.gerarScreenshot(super.browser);
			this.configEvidencia.fecharPdf();
			String qtdItensNumber = super.browser.findElement(this.carrinhoPage.getByItensCarrinho()).getText().substring(0, 1)
					.replace(" ", "");
			int qtdItensCarrinho = Integer.valueOf(qtdItensNumber);
			return qtdItensCarrinho >= 1;
		
	}
	
	// Botão para remover produto do carrinho de compras
	public void clickBtnRemoveProduto() {
		final String msg = "\t\t\tLogs: ---- Clico em \"Remove\" para remover produto do carrinho de compras ----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.carrinhoPage.getByBtnRemove(), 30);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.carrinhoPage.getByBtnRemove()).click();
	}
	
	// Verifica se encontra os elementos para validar
	public boolean isRemoveCarrinho() {
		final String msg = "\t\t\tLogs: ---- Valido Carrinho ----";
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		this.configEvidencia.fecharPdf();
		return super.browser.findElement(this.carrinhoPage.getBtMsgCarrinho()).getText().equals(CarrinhoPage.MSG_CARRINHO);
	
}
	
	

}
