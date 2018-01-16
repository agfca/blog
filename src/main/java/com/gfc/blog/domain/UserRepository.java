package com.gfc.blog.domain;

import com.gfc.blog.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
    /**根据姓名查询用户*/
    @Query("select e from UserEntity e where e.username=:username")
    UserEntity findByUsername(@Param("username") String username);
}
