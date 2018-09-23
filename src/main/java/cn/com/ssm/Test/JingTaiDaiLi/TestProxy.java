package cn.com.ssm.Test.JingTaiDaiLi;

public class TestProxy {
    public static void main(String[] args){
        SubjectProxy subjectProxy = new SubjectProxy(new RealSubject());
        subjectProxy.getSubject();
    }
}
