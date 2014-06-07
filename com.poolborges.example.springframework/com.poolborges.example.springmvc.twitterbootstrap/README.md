# Exemplo Spring MVC, Twitter Bootstrap

Este é um projecto web e foi testado no Tomcat 7.0.40

Faz uso de:

* Spring-MVC 3
* JavaServer Pages(JSP)
* JavaServer Pages Standard Tag Library(JSTL), Expression Language(EL)
* Twitter Bootstrap


## Referencias

Java EE 5 API (Servlet 2.5, JSP 2.1, EL 2.1, JSTL 1.2)
Java EE 6 API (Servlet 3.0, JSP 2.2, EL 2.2)

(Que Versão do Tomcat Usar)[http://tomcat.apache.org/whichversion.html]
* Apache Tomcat 7.x  TEM (Servlet 3.0, JSP 2.2, EL 2.2)
* Apache Tomcat 6.x TEM (Servlet 2.5 and JSP 2.1), Não tem incluido (JSTL, EL)


* http://publib.boulder.ibm.com/infocenter/ieduasst/v1r1m0/index.jsp?topic=/com.ibm.iea.was_v8/was/8.0/ProgramingModel/WASV8_Servlet_JSP_EL/player.html

JSTL
* (JSTL Oficial Site)[http://jstl.java.net/]
* (JSTL 1.1 Javadoc)[http://docs.oracle.com/cd/E17802_01/products/products/jsp/jstl/1.1/docs/tlddocs/index.html]
* (Biblioteca Padrão de Tags JSP)[http://www.dsc.ufcg.edu.br/~jacques/cursos/daca/html/jstl/jstl.htm]
* (Use JSTL in your Web Application)[http://www.mularien.com/blog/2008/04/24/how-to-reference-and-use-jstl-in-your-web-application/]
* (JSTL Quick Reference)[http://bellsouthpwp.net/b/i/billsigg/jstl-quick-reference.pdf]
* (Version matching of JSP, JSTL and Servlet)[http://tech.zhenhua.info/2009/01/version-matching-of-jsp-jstl-and.html]
* (Servlet, JSP, JSTL, JSF and EL Compatibility)[http://3rdstage.blogspot.pt/2011/07/servlet-jsp-jstl-el-and-jsf.html]
* (http://www.herongyang.com/jsp/jstl.html)[http://www.herongyang.com/jsp/jstl.html]

EL
* ((EL Oficial Site))[http://uel.java.net/getStarted.html]

JSP - 



## Documentação

* JSTL(MAVEN)
  * API  - javax.servlet.jsp.jstl	javax.servlet.jsp.jstl-api	1.2.1
  * IMPL - org.glassfish.web	javax.servlet.jsp.jstl	1.2.1


## Ambiente Desenvolvimento

Este projecto faz uso do maven para gestão de dependencias das "libs" usadas no projecto.
Foi utilizado o IDE netbeans, pois possui integrado o maven, não sendo necessario instalar o maven separadamente

* Netbeans 7.2 + Maven 
* Tomcat 7.0.29
  * Se configurar o tomcat no netbeans podera executar "run/build" sobre o projecto ira compilar e testar automaticamente no tomcat

## License

See LICENSE.txt


## Changelog

See CHANGELOG.txt
