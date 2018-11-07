package com.poolborges.example.xstream;

import com.thoughtworks.xstream.XStream;

/**
 *
 * @author Borges
 */
public class TestXStream {
    public static void main(String[] args) {

        Blog teamBlog = new Blog(new Author("Andrea Lubrano"));
        teamBlog.add(new Entry("Titulo Noticia","Conteudo da noticia."));
        teamBlog.add(new Entry("Tutorial XStream","Isto é um tutorial sobre XStream!"));

        XStream xstream = new XStream();
        System.out.println(xstream.toXML(teamBlog));

}
}
