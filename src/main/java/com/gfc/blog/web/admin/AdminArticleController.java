package com.gfc.blog.web.admin;

import com.gfc.blog.model.Article;
import com.gfc.blog.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value="admin新增文章页面  GET-POST TODO", notes="")
    @GetMapping({"/new"})
    @ResponseBody
    public Article articlePage (ModelMap map){
        Article article = new Article();
        article.setAuthor("admin");
        articleService.save(article);
        return articleService.findById(article.getId());
        //return "blog/article";
    }

}
