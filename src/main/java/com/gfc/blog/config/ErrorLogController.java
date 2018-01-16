package com.gfc.blog.config;

import com.alibaba.fastjson.JSONObject;
import com.gfc.blog.model.ErrorLog;
import com.gfc.blog.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/*springboot1.5.7版本在方法jsonErrorHandler上添加@ResponseBody会报错，
解决办法就是，在类GlobalExceptionHandler添加@RestController注解，即可解决*/
@ControllerAdvice
//public class ErrorLogController implements ErrorController{  继承errorController 也能实现
public class ErrorLogController {
    public static final String DEFAULT_ERROR_VIEW = "500";
    //public static final String NOTFOUND_ERROR_VIEW = "404";

    @Autowired
    ErrorLogService errorLogService;
    /*只能处理代码错误*/
    @ExceptionHandler(value = Exception.class)
    public  Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        //获取头信息 text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
        //System.out.println(req.getLocalAddr());  服务器ip
        //System.out.println(getIpAddress(req));

        //404 处理   会默认返回error.html   没生效
       /* if(e instanceof NoHandlerFoundException){//404错误
            ModelAndView mav = new ModelAndView(NOTFOUND_ERROR_VIEW);
            return mav;
        }*/

        ErrorLog errorLog = new ErrorLog();
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");//  TODO 获取登录用户
        if(user!=null){
            errorLog.setUsername("登录用户1");
        }else{
            errorLog.setUsername("访客");
        }

        errorLog.setUrl(req.getRequestURL().toString());//URL
        errorLog.setIp(getIpAddress(req));//IP
        errorLog.setException(e.getMessage());//getLocalizedMessage 一样
        errorLog.setOperateTime(new Date());//时间
        errorLog.setClassMethod(e.getStackTrace()[0]+"");

        //获取请求参数  将参数转为  string：string
        Map<String,String[]> map = req.getParameterMap();
        Map<String,String> mapTemp = new HashMap<String,String>();
        for (String str:map.keySet()) {
            mapTemp.put(str,map.get(str)[0]);
        }
        String jsonArgs = JSONObject.toJSONString(mapTemp);
        errorLog.setArgs(jsonArgs);
        /*保存日志   成功返回日志实体  带id*/
        errorLogService.save(errorLog);

        String header = req.getHeader("accept");
        if(isHtml(header)){//html
            return htmlReturn(req,e);
        }else{//ajax
            return jsonReturn(req,e);
        }
        /*HttpServletRequest 包括所有信息   jsessionId  和 cookie*/
        /*{"exception":{"cause":null,"stackTrace":[{"methodName":"homePage","fileName":"LoginController.java","lineNumber":13,"className":"com.gfc.blog.web.LoginController","nativeMethod":false},*/
    }

    /**
     * 判断是否是页面请求
     */
    private boolean isHtml(String header){
        /*String header = req.getHeader("content-type");
        String satr = req.getHeader("accept");
        Enumeration str3 = req.getHeaderNames();
        String agent = req.getHeader("User-Agent");
        String sta = req.getContentType();*/
        //获取头信息 text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
        String[] arr = header.split(",");
        if(arr.length>1&&"text/html".equals(arr[0])){
            return true;
        }else{//头信息错误
            return false;
        }
    }

    /**
     * JSON返回  使用MappingJackson2JsonView  类返回json
     */
    public Object jsonReturn(HttpServletRequest req,Exception e){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.getModel().put("result","error");
        mav.getModel().put("msg","错误代码："+e.getStackTrace()[0]+"。" +
                "请求路径："+req.getRequestURL()+"。错误信息："+e.getLocalizedMessage());
        return mav;
    }

    /**
     * HTML  ERROR 返回
     */
    public Object htmlReturn(HttpServletRequest req,Exception e){
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        Map<String,Object> map = mav.getModelMap();
        map.put("url",req.getRequestURL());
        map.put("exception",e.getStackTrace()[0]);
        map.put("errorMsg",e.getLocalizedMessage());//错误信息
        return mav;
    }
    /**
     * 获取ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
