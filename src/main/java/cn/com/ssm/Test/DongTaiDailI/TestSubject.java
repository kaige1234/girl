package cn.com.ssm.Test.DongTaiDailI;

public class TestSubject {
    public static void main(String[] args){
        ProxySubject proxySubject = new ProxySubject();
        RealSubject realSubject = new RealSubject();
        Subject obj =(Subject)proxySubject.bind(realSubject);
        obj.someThing();
    }
}
