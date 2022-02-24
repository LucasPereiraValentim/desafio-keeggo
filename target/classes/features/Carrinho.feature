@Carrinho
Feature: Carrinho de compras
	
	#PWK = Projeto Web Keeggo
	@PWK_0003
	Scenario: Adicionar um produto ao carrinho
		Given home clique no icone de login
		When preencho campos de login
		And clico no btn de logar
		When seleciono uma categoria
		And seleciono um produto
		When adiciono o produto ao carrinho de compras
		And Clico no botão para ir para o carrinho
		Then valido se foi adicionado ao carrinho
		
		@PWK_0004
		Scenario: Remover produto do carrinho
			Given home clique no icone de login
			When preencho campos de login
			And clico no btn de logar
			When clico no icone de carrinho
			And clico em remover produto
			Then valido se foi removido
			
