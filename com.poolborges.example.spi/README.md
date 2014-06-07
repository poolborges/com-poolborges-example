# Service Provider Interface (SPI) 
* Interface - é uma maneira de definir uma API?
* Service Provider - é a implementação de uma API

## Exemplo de uso do SPI 

Por exemplo o JDBC é uma API para "trabalhar" com base de dados relacional. 
Talvez no futuro permita trabalhar com outros tipos de base de dados.

Por examplo para usar o MySQL é necessario 
* Colocar um ficheiro do tipo ".jar" na "classpath" 
* Escrever no codigo da aplicação o seguinte 

// Exemplo para carregar(em ingles load) o service provider que permite trabalhar com MySQL
Class.forName("com.mysql.jdbc.Driver"); 

Como é identificado o servider provider?
* Devera existir um ficheiro(descritor do "service")dentro do jar(META-INF/services/) que indica, que classe(dentro do jar) implementa que "Interface"
* Existe uma classe(Loader) que ira procurar em todos os jar presentes na classpath pelo ficheio mencionado acima. 
 


## Onde é usado o conceito de SPI no Java

* JDBC, JCE, JNDI, JAXP, JBI, Java Sound, Java Image I/O


## Mais sobre o Assunto

* http://docs.oracle.com/javase/tutorial/ext/basics/spi.html
* http://docs.oracle.com/javase/tutorial/sound/SPI-intro.html
* http://www.developer.com/java/article.php/3848881/Service-Provider-Interface-Creating-Extensible-Java-Applications.htm
* http://en.wikipedia.org/wiki/Service_provider_interface
