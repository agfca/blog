package com.gfc.blog.service;

import com.gfc.blog.domain.ArticleRepository;
import com.gfc.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    /*新增article*/
    public boolean save(Article article){
        articleRepository.save(article);
        if(article.getId()==null) return false;
        return true;
    }

    /*根据id查询article*/
    public Article findById(Integer articleId){
        return  articleRepository.findOne(articleId);
    }

}
