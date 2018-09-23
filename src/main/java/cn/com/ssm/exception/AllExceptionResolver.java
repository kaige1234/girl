package cn.com.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
public class AllExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        CustomerException ce = null;
        if(e instanceof CustomerException){
            ce = (CustomerException) e;
        }else{
            e.printStackTrace();
            ce = new CustomerException("未知错误");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ce",ce);
        modelAndView.setViewName("/error");

        return modelAndView;
    }
}
