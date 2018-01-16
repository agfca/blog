package com.gfc.blog.service;

import com.gfc.blog.domain.ErrorLogRepository;
import com.gfc.blog.model.ErrorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional// TODO  错误日志需要 -- 开启事务？？？
public class ErrorLogService {
    @Autowired
    ErrorLogRepository errorLogRepository;

    /** 保存日志信息  可返回带id的实体 */
    public void save(ErrorLog errorLog){
        errorLogRepository.save(errorLog);
    }

    //@Modifying  TODO  修改删除  需要该注解
}
