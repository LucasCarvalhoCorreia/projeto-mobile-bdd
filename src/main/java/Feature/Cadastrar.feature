# language: pt

@TesteDeCadastro
Funcionalidade: Cadastro de novo usuario.

Contexto: 
	Dado que o usuario tenha entrado no app e clicado na opcao de menu
		Quando Ele clicar no link de login
			E clicar no link de criar uma nova conta

@TesteDeSucesso
Cenario: Teste de cadastro de novo usuario
	Quando o usuario preencher o formulario de cadastro
		E clicar na caixa de receber ofertas
	Quando ele clicar no botao de registrar
		Entao verifica se o usuario esta logado
	
@TesteDeFalha
Cenario: Teste de Cadastro com confirmacao de senhas divergentes
	Quando o usuario preencher o formulario de cadastro com a confirmacao de senha diferente da senha
		Entao o usuario nao pode efetuar o registro
