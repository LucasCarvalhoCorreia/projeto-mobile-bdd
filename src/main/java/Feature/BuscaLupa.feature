# language: pt

@TesteBuscaLupa
Funcionalidade: Consulta de produtos por barra de pesquisa.

Contexto: 
	Dado que o usuario tenha entrado no app e clicado na barra de pesquisa
		Quando ele digitar e pesquisar o nome do produto desejado

@TesteDeSucesso
Cenario: Teste de consulta de produto por barra de pesquisa
    E ele selecionar o produto desejado
    	Entao checar se o produto selecionado foi encontrado
  
@TesteDeFalha  
Cenario: Teste de consulta de produto inexistente por barra de pesquisa
    	Entao checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado