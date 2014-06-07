package br.com.fiap.rest;

import java.io.IOException;
import java.util.List;

import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jaxb.JaxbRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import br.com.fiap.agenda.Agenda;
import br.com.fiap.agenda.Contato;
import br.com.fiap.dao.ContatoDAO;

/**
 * Implementa um "ServerResource" da Agenda (conjunto de Contatos).
 */
public class AgendaResource extends ServerResource {

    /**
     * DAO de persistencia do bean Contato
     */
    private ContatoDAO contatoDAO = new ContatoDAO();

    /**
     * Permite o metodo POST.
     *
     * @return true
     */
    public boolean allowPost() {
        return true;
    }

    /**
     * Metodo POST: Adiciona um Contato na agenda.
     *
     * @param repContato Representacao em XML do contato
     * @return Representacao em TEXT_PLAIN.
     */
    @Post("xml")
    public Representation inserir(Representation repContato) {

        Representation result = null;

        try {
            /* cria uma instancia de "JAXB Representation", para transformar o
             * xml recebido em um objeto Contato */
            JaxbRepresentation<Contato> jaxbRep =
                    new JaxbRepresentation<Contato>(repContato, Contato.class);

            /* obtem o objeto Contato a partir do xml postado */
            Contato contato = jaxbRep.getObject();
            /* zera o id, pois vai inserir um novo contato */
            contato.setId(0);

            /* insere o Contato atraves do DAO */
            if (contatoDAO.inserir(contato)) {

                setStatus(Status.SUCCESS_CREATED);
                result = new StringRepresentation("Contato Adicionado.",
                        MediaType.TEXT_PLAIN);

            } else {
                setStatus(Status.SERVER_ERROR_INTERNAL);
            }

        } catch (IOException e) {

            System.err.println(e.getLocalizedMessage());
            setStatus(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY);
        }

        return result;
    }

    /**
     * Metodo GET: Lista os Contatos da agenda.
     *
     * @return Representacao em XML da Agenda.
     */
    @Get("xml")
    public Representation listar() {

        /* obtem a lista de contatos */
        List<Contato> contatos = contatoDAO.listar();

        if (contatos == null || contatos.size() < 1) {
            return null;
        }

        /* preenche um objeto Agenda com a lista */
        Agenda agenda = new Agenda();
        agenda.setContatos(contatos);

        /* cria uma instancia de "JAXB Representation", para transformar o
         * objeto Agenda em um xml */
        JaxbRepresentation<Agenda> representation =
                new JaxbRepresentation<Agenda>(agenda);
        representation.setFormattedOutput(true);

        return representation;
    }
}
