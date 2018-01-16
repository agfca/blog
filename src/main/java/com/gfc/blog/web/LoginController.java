package com.gfc.blog.web;

import com.gfc.blog.Constant.RoleConstant;
import com.gfc.blog.model.UserEntity;
import com.gfc.blog.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="主页index", notes="")
    @GetMapping({"/","/index","/home"})
    public String homePage (){
        return "blog/index";
    }

    @ApiOperation(value="登录页面", notes="")
    @GetMapping("/login")
    public String login (){
        return "login";
    }


    @ApiOperation(value="注册用户", notes="该api以后会只暴露给admin权限角色")
    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @ApiOperation(value="注册用户", notes="该api以后会只暴露给admin权限角色")
    @PostMapping("/register")
    public String doRegister(@RequestParam String username,@RequestParam String password,@RequestParam String nickname){
        //TODO  此处省略校验逻辑
        //"用户是否存在："
        if(exist(username))
            return "redirect:register?exist";//用户存在
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setNickname(nickname);
        userEntity.setCreateTime(new Date());
        encryptPassword(userEntity);//密码加密
        userEntity.setRoles(RoleConstant.ROLE_USER);//普通用户

        if (userService.save(userEntity))
            return "redirect:register?success";
        return "redirect:register?error";
    }

    @ApiOperation(value="登录跳转", notes="根据角色权限跳转 TODO")//TODO
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username",principal.getName());
        return "user/user";
    }

    /**判断用户是否存在*/
    private boolean exist(String username){
        UserEntity userEntity = userService.findByName(username);
        return (userEntity !=null);
    }

    /**加密密码*/
    private  void encryptPassword(UserEntity userEntity){
        String pwd = userEntity.getPassword();
        pwd = new BCryptPasswordEncoder().encode(pwd);
        userEntity.setPassword(pwd);
    }
}
