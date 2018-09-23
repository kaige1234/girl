    package cn.com.ssm.Test.DongTaiDailI;

    import java.lang.reflect.InvocationHandler;
    import java.lang.reflect.Method;
    import java.lang.reflect.Proxy;

    /**
     * 动态代理类
     */
    public class ProxySubject implements InvocationHandler{

        private Object tar;

        public Object bind(Subject tar){
            this.tar =  tar;

            return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                    tar.getClass().getInterfaces(),this);
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(tar,args);
        }
    }
