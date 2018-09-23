package cn.com.ssm.Test.JingTaiDaiLi;

/**
 * 真实的主题
 */
public class RealSubject implements Subject{
    //实现主题的方法
    @Override
    public void getSubject() {
        System.out.println("真实主题");
    }
}
