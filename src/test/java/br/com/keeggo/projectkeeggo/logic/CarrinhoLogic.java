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
	
	
	public boolean isAddCarrinho() {
			final String msg = "\t\t\tLogs: ---- Valido Carrinho ----";
			System.out.println(msg);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.configEvidencia.gerarScreenshot(super.browser);
			this.configEvidencia.fecharPdf();
			char qtdItensText = super.browser.findElement(this.carrinhoPage.getByItensCarrinho()).getText().charAt(0);
			int qtdItensCarrinho = Integer.valueOf(qtdItensText);
			return qtdItensCarrinho >= 1;
		
	}

}
