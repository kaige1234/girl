package cn.com.ssm.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        /* Resource resources = new ClassPathResource("spring/spring_bean.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        int a = xmlBeanDefinitionReader.loadBeanDefinitions(resources);*/
       /* TestSprint testSprint = (TestSprint)defaultListableBeanFactory.getBean("test");
        testSprint.getSpring();
        System.out.println(a);
        TestSprint testSprint_01 = (TestSprint)defaultListableBeanFactory.getBean("testSpring");
        testSprint_01.getSpring();
        System.out.println(a);*/
        ApplicationContext ctx = new FileSystemXmlApplicationContext("E:\\IdeaWorkSpaces\\spring\\src\\main\\resources\\spring\\spring_bean.xml");
        AutowireTestSpring autowireTestSpring = (AutowireTestSpring)ctx.getBean("auto");
        autowireTestSpring.getTest();
    }
}
