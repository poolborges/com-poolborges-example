/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.smvc.controller;

import com.poolborges.example.smvc.model.Article;
import com.poolborges.example.smvc.service.impl.ArticleService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Borges
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleService service;

    public ArticleController() {
        service = new ArticleService();
    }

    //article/1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    protected String showAticle(@PathVariable("id") String articleId, Model model) {
        
        Article article = service.findById(articleId);
        
        model.addAttribute("article", article);
        model.addAttribute("message", "Esta é a Home Page(views/home/index.jsp)");
        
        return "article/article_show";
    }
    
    @RequestMapping("")
    public String indexArticle(Model model) {

        List<Article> lis = service.getAll();
        
        model.addAttribute("articles", lis);
        
        model.addAttribute("message", "Esta é a Home Page(views/home/index.jsp)");
        
        return "article/article_list";
    }

    /**
     * Injected by Spring
     *
     * @param service
     */
    public void setArticleService(ArticleService service) {
        this.service = service;
    }
}
