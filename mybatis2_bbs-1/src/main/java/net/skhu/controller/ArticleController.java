package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Article;
import net.skhu.mapper.ArticleMapper;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired ArticleMapper articleMapper;
  

    @RequestMapping("list")
    public String list(Model model) {
        List<Article> articles = articleMapper.findAll();
        model.addAttribute("articles", articles);
        return "article/list";
    }

}