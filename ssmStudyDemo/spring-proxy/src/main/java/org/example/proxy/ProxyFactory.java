package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * ClassLoader loader:指定加载动态生成的代理类的类加载器（根类加载器，扩展类加载器，应用类加载器，自定义类加载器）
     * Class<?>[] interfaces:获取目标对象实现的所有接口的class对象的数组
     * InvocationHandler h:设置代理类中的抽象方法如何重写
     * @return
     */
    public Object getProxy(){
        ClassLoader classLoader = ProxyFactory.class.getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy :要实现的代理类
                //method:要执行的方法
                //args：要执行的方法的参数列表
                System.out.println("日志，方法"+method.getName()+",参数："+ Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println("日志，方法"+method.getName()+",result："+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,handler);
    }
}
