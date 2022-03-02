@Login
Feature: Login

	#PWK = Projeto Web Keeggo
	@PWK_0002
	Scenario: Realizar login
		Given home clique no icone de login
		When preencho campos de login
		And clico no botao para entrar
		Then valido o login
