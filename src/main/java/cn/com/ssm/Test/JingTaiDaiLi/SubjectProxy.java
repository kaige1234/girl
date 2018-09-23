package cn.com.ssm.Test.JingTaiDaiLi;

/**
 * 代理主题
 */
public class SubjectProxy implements Subject{
    private RealSubject realSubject;

    SubjectProxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }
    //实现主题接口
    @Override
    public void getSubject() {
        realSubject.getSubject();
    }
}
