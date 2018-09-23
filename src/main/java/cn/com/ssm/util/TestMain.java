package cn.com.ssm.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        acac.register(TestMain.class);
        acac.refresh();
        Test t = acac.getBean(Test.class);
        t.print();

    }
}
