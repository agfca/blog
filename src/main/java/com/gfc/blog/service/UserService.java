package com.gfc.blog.service;

import com.gfc.blog.domain.UserRepository;
import com.gfc.blog.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;
    /**新增用户*/
    public boolean save(UserEntity userEntity){
        System.out.println(userEntity.getId()==null);
        userEntity = userRepository.save(userEntity);
        if(userEntity.getId()==null) return false;
        return true;
    }

    /**查询用户*/
    public UserEntity findByName(String username){
        return  userRepository.findByUsername(username);
    }

}
