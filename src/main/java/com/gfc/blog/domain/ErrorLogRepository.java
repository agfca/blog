package com.gfc.blog.domain;

import com.gfc.blog.model.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ErrorLogRepository extends JpaRepository<ErrorLog,Integer>{
    /**根据用户查询错误日志*/
    @Query("select e from ErrorLog e where e.username=:username")
    List<ErrorLog> findByUsername(@Param("username")String username);
}
