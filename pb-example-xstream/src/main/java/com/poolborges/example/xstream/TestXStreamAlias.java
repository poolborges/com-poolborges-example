package com.poolborges.example.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.*;

/**
 *
 * @author Borges
 */
public class TestXStreamAlias {

    public static void main(String[] args) {

        Blog blog = new Blog(new Author("Autor Apelido"));
        blog.add(new Entry("O primeiro", "Esta é a primeira noticia do blog"));
        blog.add(new Entry("O segundo", "Esta é a segunda noticia do blog!"));

        imprimirXml(blog);
        
        gerarXmlSemAlias(blog);
        
        gerarXmlComAlias(blog);
        
        lerXmlComAlias();
    }

    /**
     * Imprimi na consola o XML
     *
     * @param blog
     */
    private static void imprimirXml(Blog blog) {
        
        System.out.println("========== IMPRIMIR xml");
        
        XStream xstream = new XStream();
        
        xstream.aliasField("autor", Blog.class, "writer");
        xstream.alias("jornal", Blog.class); //definir alias
        xstream.alias("noticia", Entry.class);
        xstream.addImplicitCollection(Blog.class, "entries");

        System.out.println(xstream.toXML(blog));
    }

    /**
     * Ler o XML de um ficheiro
     */
    private static void lerXmlComAlias() {
        
        System.out.println("========== LER XmlComAlias.xml");
        FileReader reader = null;
        try {

            reader = new FileReader("XmlComAlias.xml");
        } catch (FileNotFoundException e) {
        }

        XStream xStream = new XStream(new DomDriver());
        xStream.alias("jornal", Blog.class);
        xStream.alias("noticia", Entry.class);
        xStream.addImplicitCollection(Blog.class, "entries");

        Blog contato = (Blog) xStream.fromXML(reader);

        System.out.println(contato.toString());
    }

    /**
     * Guarda Conteudo num ficheiro
     *
     * @param documento
     * @param file
     */
    private static void saveFile(String documento, String file) {
        File path = new File("" + file);
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.println(
                    "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>");
            writer.println(documento);
            writer.flush();
            writer.close();
            System.out.println("Guardado o ficheiro: "+file);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     * Gera XML com Tags "package"
     *
     * @param blog
     */
    public static void gerarXmlSemAlias(Blog blog) {

        XStream xStream = new XStream(new DomDriver());

        String documento = xStream.toXML(blog);
        saveFile(documento, "XmlSemAlias.xml");
    }

    /**
     * Gera XML com Tags "alias"
     *
     * @param blog
     */
    private static void gerarXmlComAlias(Blog blog) {

        XStream xStream = new XStream(new DomDriver());

        xStream.alias("jornal", Blog.class);
        xStream.alias("noticia", Entry.class);

        //ira ocultar a tag entries
        xStream.addImplicitCollection(Blog.class, "entries"); 

        String documento = xStream.toXML(blog);
        saveFile(xStream.toXML(blog), "XmlComAlias.xml");
    }
}
