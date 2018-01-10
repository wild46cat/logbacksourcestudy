package com.xueyou.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class OptionHelper {

    public static Object instantiateByClassNameAndParameter(String className, ClassLoader classLoader, Class<?>[] type, Object[] parameter) {
        if (className == null) {
            throw new NullPointerException();
        }
        try {
            Class<?> classObj = null;
            classObj = classLoader.loadClass(className);
            if (type == null) {
                return classObj.newInstance();
            } else {
                Constructor<?> constructor = classObj.getConstructor(type);
                return constructor.newInstance(parameter);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}

