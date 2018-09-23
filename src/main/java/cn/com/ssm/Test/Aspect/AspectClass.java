package cn.com.ssm.Test.Aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
    @Pointcut("execution(* cn.com.ssm.Test.Aspect.Service..*.*(..))")
    public  void pointCutah(){};
    @Before(value = "pointCutah()")
    public void before(){
        System.out.println("前切节点");
    }
    @Before("args(java.lang.String)")
    public void args(){
        System.out.println("参数");
    }
   /* @Before("@target(cn.com.ssm.Test.Aspect.Service.ArgeAnnotation)")
    public void find(){
        System.out.println("用来测试参数拦截@arge");
    }*/
    @Before("@args(cn.com.ssm.Test.Aspect.Service.ArgeAnnotation)")
    public void findId(){
        System.out.println("@args测试传入的参数");
    }
}
