package com.gfc.blog.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户详细信息
 */
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;    //用户名
    private String avatar;      //图像src
    private String nickname;    //昵称
    private String phone;       //电话号码
    private String email;       //邮箱
    private String signature;   //个性签名
    private String address;      //地址
    private String announcement; //公告
    private String telegram;        //tg
    private String wechat;          //微信
    private String tencentQQ;       //qq

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getTencentQQ() {
        return tencentQQ;
    }

    public void setTencentQQ(String tencentQQ) {
        this.tencentQQ = tencentQQ;
    }
}
