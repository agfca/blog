package com.gfc.blog.web;

import com.gfc.blog.Constant.RoleConstant;
import com.gfc.blog.model.Article;
import com.gfc.blog.model.UserEntity;
import com.gfc.blog.service.ArticleService;
import com.gfc.blog.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value="article页面，如果不存在则返回主页面", notes="")
    @GetMapping({"/article/{articleId}"})
    public Article articlePage (@PathVariable Integer articleId, ModelMap map){
        return articleService.findById(articleId);
        //return "blog/article";
    }

}
