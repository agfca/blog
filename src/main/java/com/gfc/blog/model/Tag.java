package com.gfc.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 文章标签
 */
@Entity
@Table(name="tag")
public class Tag implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String tagName;          //标签名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
