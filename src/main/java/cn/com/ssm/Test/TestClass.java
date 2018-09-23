package cn.com.ssm.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class clazz = Class.forName("cn.com.ssm.Test.TestClassForName");
        Method method =   clazz.getDeclaredMethod("privateMothed",String.class);
        method.setAccessible(true);
        MyAnnotation myAnnotation = method.getDeclaredAnnotation(MyAnnotation.class);
       if(myAnnotation.flag()){
           Object object = clazz.getDeclaredConstructor().newInstance();
           method.invoke(object,"讯开");
       }
    }
}
