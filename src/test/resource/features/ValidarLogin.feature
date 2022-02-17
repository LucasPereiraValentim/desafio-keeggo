@ValidarLogin
Feature: Login

	#PWK = Projeto Web Keeggo
	@PWK_0001
	Scenario: Deveria realizar login com sucesso
		Given home clique no icone de login
		When preencho campos de login
		And clico no btn de logar
		Then valido o login
