/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.smvc.service.impl;

import com.poolborges.example.smvc.model.Article;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Borges
 */
public class ArticleService {
    
    
    public Article findById(String id){
    
        return new Article("ID-1", "Titulo do artigo", "Autor do Artigo", new Date(), "", "");
    }
    
    public List<Article> getAll(){
    
        
        List<Article> lis = new ArrayList<Article>();
        
        for(int i=1; i<=20; i++) {
            lis.add(new Article("ID-"+i, "Artigo-"+i, "Autor do Artigo", new Date(), "Sumario ..."+i, "Conteudo ..."+i));
        }
        return lis;
    }
}
