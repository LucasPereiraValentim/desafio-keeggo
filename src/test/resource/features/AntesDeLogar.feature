@AntesDeLogar
Feature: Antes de Logar
	
	#PWK = Projeto Web Keeggo
	@PWK_0005
	Scenario: Não pode permitir logar com dados invalidos
		Given home clique no icone de login
		When preencho campos de com login com dados invalidos
		And clico no botão de entrar
		Then valido mensagem de erro ao logar
