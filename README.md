# projeto-autorizador
* O que foi feito:
  - Desenvolvido sistema de controle de regra de autorização, com os campos: procedimentos, idade, sexo e ativo.
  - Foi usado MAVEN, o banco POSTGRESS, desenvolvido em JAVA e armazenado no GIT.
  - Foi desenvolvido testes unitários com JUNIT.
  - O sistema busca as regras previamente cadastradas, e permite o cadastro de novas regras de autorização.
  
* Para rodar o sistema, será necessário:
  - Ter JDK instalado;
  - Instalar uma IDE (ex: Eclipse, IntelliJ);
  - Instalar o o banco postgres.
  
 * Orientação:
  - Após instalar o que é necessário, abrir o postgress e rodar os scripts contidos na pasta banco (raiz do git)
  - No script será criado a database (sistema-autorizador), criação da tabela e realizados inserção de alguns dados
  - Abrir a IDE, importar o projeto (importar como projeto MAVEN), e selecionar o projeto que foi feito o download.
  
  * OBS:
    - Os dados do banco estão na classe dao >> BASEDADOS.
    - Executar classe view >> PRINCIPAL.JAVA
