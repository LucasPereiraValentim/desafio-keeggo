@Cadastro
Feature: Cadastro
	
	#PWK = Projeto Web Keeggo
	@PWK_0001 
	Scenario: Deveria cadastrar um usuario com sucesso
		Given home clique no icone de login
		When clico no botao para redirecionar para tela de cadastro
		And preencho os campos de cadastro
		And clico no checkbox de termos de privacidade
		And clico no botao de registrar novo usuario
		Then valido cadastro