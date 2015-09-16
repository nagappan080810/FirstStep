package com.firststep.classloader;
import java.lang.reflect.*;

public class Client {
	public static void main(String[] args){
        String className = "com.firststep.classloader.SayHello";
        String dir = "D:\\Temp";
        KonaClassLoader kcl = new KonaClassLoader();
        Class<?> clazz = null;
        Object obj = null;
        Method m = null;
        try {           
            clazz = kcl.loadClass(className);  
            //clazz = kcl.loadClassFromLocal(dir, className);
            obj = clazz.newInstance();
            m = clazz.getMethod("sayGoodbye", String.class);
            m.invoke(obj, "Robin");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
