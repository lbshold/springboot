package top.lconcise.design_demo.design_mode.structure.proxy.dynamic_proxy.interface_p;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前-操作");
        Object result = method.invoke(object, args);
        System.out.println("操作后-操作");
        return result;
    }
}
