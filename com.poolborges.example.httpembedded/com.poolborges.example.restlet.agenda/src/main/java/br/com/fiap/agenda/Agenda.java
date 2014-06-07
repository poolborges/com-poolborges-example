package br.com.fiap.agenda;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe bean que representa uma Agenda (lista de Contatos).
 */
@XmlRootElement(name="contatos")
public class Agenda {

	private List<Contato> contatos;

	@XmlElement(name="contato")
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
}
