# language: pt

@TesteBuscaLupa
Funcionalidade: Consulta de produtos por barra de pesquisa.

@TesteDeSucesso
Cenario: Teste de consulta de produto por barra de pesquisa
	Dado que o usuario tenha entrado no app e digitado o nome do produto desejado na barra de pesquisa
		Quando clicar em pesquisar
    	E ele selecionar o produto desejado
    Entao checar se o produto selecionado foi encontrado
  
@TesteDeFalha  
Cenario: Teste de consulta de produto inexistente por barra de pesquisa
	Dado que o usuario tenha entrado no app e digitado o nome do produto inexistente no banco na barra de pesquisa
		Quando pesquisar o produto inexistente
    	Entao checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado