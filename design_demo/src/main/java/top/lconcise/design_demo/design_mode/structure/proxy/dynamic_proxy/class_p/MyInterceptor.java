package top.lconcise.design_demo.design_mode.structure.proxy.dynamic_proxy.class_p;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("操作前-操作");
        methodProxy.invokeSuper(obj, objects);
        System.out.println("操作后-操作");
        return null;
    }
}
