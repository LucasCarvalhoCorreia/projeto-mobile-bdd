# Projeto-Appium-BDD

Projeto desenvolvido com o objetivo de testar conhecimentos em relação a desenvolvimento de testes de automação em TDD para dispositivos Mobile.

Conteúdo e descrições do projeto:

projeto-appium-bdd

  - src/main/java (pastas onde estão locaizados os pacotes do projeto.)
  
    - br.com.rsinet.hub_bdd.excel (Pacote responsável por agrupar as classes que vão manipular dados relacionados ao excel.)
      - Constantes.java
      - ExcelUtils.java
      - PegaMassa.java
      
    - br.com.rsinet.hub_bdd.extendReport (Pacote responsável por agrupar as classes que vão manipular dados relacionados ao Extend Report.)
      - ExtendReport.java
      - Prints.java
      
    - br.com.rsinet.hub_bdd.manager (Pacote responsável por agrupar as classes que vão manipular os drivers.)
      - DriverFactory.java
      - ScreenObjectManager.java
      - TestContext.java
      
    - br.com.rsinet.hub_bdd.screenObject (Pacote responsável por agrupar as classes que vão manipular os métodos relacionados as telas de teste.)
      - CadastroScreen.java
      - HomeScreen.java
      - PesquisaScreen.java
      
    - br.com.rsinet.hub_bdd.stepDefinitions (Pacote responsável por agrupar as classes que vão executar os passos de teste do cucumber.)
      - Cadastrar.java
      - ConsultaPorBarraDePesquisa.java
      - ConsultaPorCategoria.java
      - Hooks.java
      
    - br.com.rsinet.hub_bdd.testData (Pacote que contém a classe que contem a massa de dados.)
      - MassaDeDados.xlsx
      
    - br.com.rsinet.hub_bdd.testRunner (Pacote que contém a classe que roda todos os testes.)
      - TestRunner.java
      
    - Feature (Pacote responsável por agrupar as features que contém os stories de casos de testes.)
      - Cadastrar.feature
      - ConsultaPorBarraDePesquisa.feature
      - ConsultaPorCategoria.feature
    
  - configs (Pasta que contém o arquivo reponsável por configurar o extend report.)
    - extension-config.xml
  
  - target (Pasta que guarda os prints e o relatório do extend report.)
    - Reports.html
  
  - pom.xml (Arquivo responsável por baixar e orgnizar as dependências do maven.)
