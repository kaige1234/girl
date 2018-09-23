package cn.com.ssm.controller.backend;

import cn.com.ssm.common.RedisCacheManager;
import cn.com.ssm.po.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
    @RequestMapping("/pc")
public class loginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(loginController.class);
    @Autowired
    private RedisCacheManager redisCacheManager;

    @RequestMapping(value = "/index")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }
    @RequestMapping(value = "/login")
    public String inLogin(HttpServletRequest request, HttpServletResponse response, Customer customer){
        LOGGER.info("userNmae="+customer.getUserName()+"----password="+customer.getPassword());
        if(!redisCacheManager.getStr("loginId").isEmpty()){

        }
        return "";
    }

}
