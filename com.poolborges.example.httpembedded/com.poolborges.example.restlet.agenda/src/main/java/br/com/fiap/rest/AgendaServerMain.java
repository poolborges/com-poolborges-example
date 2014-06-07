package br.com.fiap.rest;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Classe Principal de um Servidor REST Agenda. 
 * Esta classe implementa um servidor standalone baseado em Restlet.
 */
public class AgendaServerMain {

	/** Porta TCP onde o servidor estara' escutando. */
	private final static int SERVER_TCP_PORT = 8888;
	
	/**
	 * Metodo principal da aplicacao do Servidor REST de Agenda.
	 * @param args Argumentos de linha de comando
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {

    	Component component = new Component();

    	component.getServers().add(Protocol.HTTP, SERVER_TCP_PORT);
        component.getDefaultHost().attach("/agenda",
        		new AgendaApplication());

        component.start();
    }

}
