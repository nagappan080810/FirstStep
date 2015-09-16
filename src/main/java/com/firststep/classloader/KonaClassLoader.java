package com.firststep.classloader;

public class KonaClassLoader extends ClassLoader{
	public Class<?> loadClassFromLocal(String dir, String name) throws ClassNotFoundException {
		Class<?> clazz;
		clazz = loadClass(name);
		return clazz;
	}
}
