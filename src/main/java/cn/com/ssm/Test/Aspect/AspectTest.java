package cn.com.ssm.Test.Aspect;

import cn.com.ssm.Test.Aspect.Service.Order;
import cn.com.ssm.Test.Aspect.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AspectTest {
    public static void main(String[] args){
        ClassPathResource classPathResource = new ClassPathResource("\\spring\\spring_bean.xml");
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("\\spring\\spring_bean.xml");
       //ApplicationContext ctx = new FileSystemXmlApplicationContext("E:\\IdeaWorkSpaces\\spring\\src\\main\\resources\\spring\\spring_bean.xml");
        UserService userService = applicationContext.getBean("userService",UserService.class);
        AspectClass aspectClass = applicationContext.getBean("aspectClass",AspectClass.class);
        Order order =applicationContext.getBean("order",Order.class);
        /* userService.upd("ddddd");*/
       /* userService.inset(2);*/
        /*userService.del("ddddssss");*/
        order.getOrder(userService);
    }
}
