@ValidarCadastro
Feature: Validar Cadastro
	
	#PWK = Projeto Web Keeggo
	@PWK_0001 
	Scenario: Deveria cadastrar um usuario com sucesso
		Given home clique btn para redicionar para login
		Then clique btn para redirecionar para criar novo usuario
		Then preencho os campos de cadastro
		And clico no checkbox de termos de privacidade
		And clico no botao de registrar novo usuario
		Then valido cadastro