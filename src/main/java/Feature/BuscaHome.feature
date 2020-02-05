# language: pt

@TesteBuscaHome
Funcionalidade: Pesquisa de produtos por categoria.

Contexto: 
	Dado que o usuario tenha entrado no app e efetue o login
    Quando ele selecionar a categoria do produto desejado
    	E clicar no produto desejado

@TesteDeSucesso
Cenario: Teste de pesquisa de produto por categoria
    Entao verifica se o produto correto foi selecionado 
  
@TesteDeFalha  
Cenario: Teste de compra de produto acima da quantidade permitida no carrinho de compras
    Quando ele alterar a quantidade de produtos para compra acima do aceitavel no carrinho
    	E clicar no botao de adicionar produto ao carrinho
    	E clicar no carrinho de compras
    		Entao checar se a quantidade de produtos solicitada corresponde a quantidade no carrinho