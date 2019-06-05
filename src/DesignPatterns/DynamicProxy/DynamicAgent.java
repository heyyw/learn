package DesignPatterns.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/3/8 16:36
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DynamicAgent {
    static class MyHandler implements InvocationHandler{
        private Object proxy;
        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>>>before invoke");
            Object ret = method.invoke(this.proxy,args);
            System.out.println(">>>>>>after invoke");
            return ret;
        }
    }

    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }
}
