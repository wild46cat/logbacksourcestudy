package com.xueyou.demo.reflection;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

/**
 * Created by wuxueyou on 2018/1/10.
 */
public class ReflectApp {
    public static void main(String[] args) {
        Student s = (Student) OptionHelper.instantiateByClassNameAndParameter("com.xueyou.demo.reflection.Student", ClassLoader.getSystemClassLoader(), null, null);
        s.setAge(1);
        System.out.println(s.getAge());

        Class<?>[] classtypes = {String.class, int.class};
        Object[] params = new Object[2];
        params[0] = "aaaa";
        params[1] = 13;
        Student s2 = (Student) OptionHelper.instantiateByClassNameAndParameter("com.xueyou.demo.reflection.Student", ClassLoader.getSystemClassLoader(), classtypes, params);
        System.out.println(s2.getAge());
        System.out.println(s2.getName());
    }
}
