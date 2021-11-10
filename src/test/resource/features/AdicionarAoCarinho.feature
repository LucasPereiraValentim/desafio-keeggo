@AdicionarAoCarinho
Feature: Cadastro
	
	#PWK = Projeto Web Keeggo
	@PWK_0003 
	Scenario: Deveria adicionar um produto ao carrinho com suceso
		Given home clique no icone de login redirecionar
		Then preencho campos de login
		And clico no btn de logar
		Then seleciono uma categoria
		Given lista de produto selecine um produto
		When adiciono o produto ao carrinho de compras
		And Clico no botão para ir para o carrinho
		Then valido se foi adicionado ao carrinho
