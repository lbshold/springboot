package top.lconcise.design_demo.combat;

import top.lconcise.design_demo.Application;
import top.lconcise.design_demo.combat.entity.Fruits;
import top.lconcise.design_demo.combat.mapper.TemplateMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.*;

/**
 * 工作中一个接口需要动态加载不同类型的mapper类，mapper获取实体类，返回给前端。
 * <p>
 * 1. 自定义注解 @Subscribe，Mapper添加@Subscribe(desc = "xxxxxx")，维护不同类型与Mapper的对应关系。
 * 2. 获取所有Mapper。所有需要用的mapper实现自定义的TemplateMapper接口，通过反射获取所有该接口的实现类，（要求：接口与实现类在同一目录下）
 * 3. 获取Mapper实例。基于以上1,2，维护Map<String,Class>类，通过前端传递type，获取对应class，然后通过ApplicationContext.getBean(Class)返回对应mapper实例。
 *
 * @author: liusj
 * @date: 2022/5/26
 */
public class MapperFactory {

    public static Map<String, Class> typeClassMap;

    public static Fruits selectByIdAndType(String type, Long instanceId) {
        Class aClass = MapperFactory.getTypeClassMap().get(type);
        TemplateMapper mapper = (TemplateMapper) Application.applicationContext.getBean(aClass);
        return (Fruits) mapper.selectById(instanceId);
    }

    /**
     * typeClassMap 单例-懒加载。
     *
     * @return
     */
    public static synchronized Map<String, Class> getTypeClassMap() {
        if (typeClassMap == null) {
            typeClassMap = new HashMap<>();
            // 获取所有TemplateMapper接口所有实现类
            List<Class> classList = getAllAchieveClass(Fruits.class, true);
            for (Class aClass : classList) {
                Subscribe annotation = (Subscribe) aClass.getAnnotation(Subscribe.class);
                typeClassMap.putIfAbsent(annotation.desc(), aClass);
            }
        }
        return typeClassMap;
    }

    /**
     * 获取所有clazz接口的实现类.
     *
     * @param isAbstract 是否包含抽象类(抽象类和接口)，true 包含，false 不包含
     * @return
     */
    private static List<Class> getAllAchieveClass(Class clazz, Boolean isAbstract) {
        ArrayList<Class> list = new ArrayList<>();
        //判断是否是接口
        if (clazz.isInterface()) {
            // 获取clazz接口类所在路径下的所有实现类
            ArrayList<Class> allClass = getAllClassByPath(clazz.getPackage().getName());
            //  循环判allClass否实现了指定的接口,并且排除接口类自己
            for (int i = 0; i < allClass.size(); i++) {
                if (!isAbstract) {
                    if (Modifier.isAbstract(allClass.get(i).getModifiers())) {
                        continue;
                    }
                }
                //判断是不是同一个接口
                if (clazz.isAssignableFrom(allClass.get(i))) {
                    if (!clazz.equals(allClass.get(i))) {
                        list.add(allClass.get(i));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 从指定路径下获取所有类
     *
     * @return
     */
    private static ArrayList<Class> getAllClassByPath(String packageName) {
        ArrayList<Class> list = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        try {
            ArrayList<File> fileList = new ArrayList<>();
            Enumeration<URL> enumeration = classLoader.getResources(path);
            while (enumeration.hasMoreElements()) {
                URL url = enumeration.nextElement();
                fileList.add(new File(url.getFile()));
            }
            for (int i = 0; i < fileList.size(); i++) {
                list.addAll(findClass(fileList.get(i), packageName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 如果file是文件夹，则递归调用findClass方法
     * 如果file本身是类文件，则加入list中进行保存，并返回
     *
     * @param file
     * @param packageName
     * @return
     */
    private static ArrayList<Class> findClass(File file, String packageName) {
        ArrayList<Class> list = new ArrayList<>();
        if (!file.exists()) {
            return list;
        }
        File[] files = file.listFiles();
        for (File file2 : files) {
            if (file2.isDirectory()) {
                //添加断言用于判断
                assert !file2.getName().contains(".");
                ArrayList<Class> arrayList = findClass(file2, packageName + "." + file2.getName());
                list.addAll(arrayList);
            } else if (file2.getName().endsWith(".class")) {
                try {
                    //保存的类文件不需要后缀.class
                    list.add(Class.forName(packageName + '.' + file2.getName().substring(0,
                            file2.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
