package cn.com.ssm.Test;

import org.springframework.web.bind.annotation.RequestMapping;

public class TestClassForName {
    private String privateField;
    protected String protectedField;
    public String publicField;
    String defField;

    private Integer privateIntegerField;
    private Long privateLongField;

    TestClassForName(){}
    TestClassForName(String privateField){
        this.privateField = privateField;
    }
    @MyAnnotation
    private String privateMothed(String name){
        System.out.println("我被调用了    privateMothed"+name);
        return "";
    }

    public String publicMothed(){
        System.out.println("我被调用了    publicMothed");
        return "";
    }
}
