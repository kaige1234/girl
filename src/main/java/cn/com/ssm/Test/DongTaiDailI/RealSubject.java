package cn.com.ssm.Test.DongTaiDailI;

/**
 * 真实主题
 */
public class RealSubject implements Subject{

    @Override
    public void someThing() {
        System.out.println("这是真实的代理");
    }
}
