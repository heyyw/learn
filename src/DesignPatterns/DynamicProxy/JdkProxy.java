package DesignPatterns.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Desc: 描述
 * @Author: Heyyw
 * @CreateDate: 2019/5/26 11:57
 * @UpdateAuthor:
 * @UpdateDate:
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JdkProxy implements InvocationHandler{
    private Object target = null;
    public Object bind(Object tar){
        this.target = tar;
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),tar.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前");
        Object obj = method.invoke(target,args);
        System.out.println("方法之后");
        return obj;
    }
}
