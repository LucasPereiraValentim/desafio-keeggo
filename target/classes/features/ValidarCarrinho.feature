@AdicionarAoCarinho
Feature: Cadastro
	
	#PWK = Projeto Web Keeggo
	@PWK_0003 
	Scenario: Deveria adicionar um produto ao carrinho com sucesso
		Given home clique no icone de login
		When preencho campos de login
		And clico no btn de logar
		When seleciono uma categoria
		And seleciono um produto
		When adiciono o produto ao carrinho de compras
		And Clico no botão para ir para o carrinho
		Then valido se foi adicionado ao carrinho
