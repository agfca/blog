package com.gfc.blog.domain;

import com.gfc.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer>{
    /**根据  title 查询 article*/
    @Query("select e from Article e where e.title=:title")
    List<Article> findByTitle(@Param("title") String title);
}
