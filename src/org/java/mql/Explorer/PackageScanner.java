package org.java.mql.Explorer;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class PackageScanner extends ClassLoader{

	public PackageScanner() {
	
	}
	
	public List<Class<?>> scan(Set<String> packagesName, String classPath) {
	
		List<Class<?>> listClass = new Vector<Class<?>>(); 
		try {
			ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
			URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file://" + classPath + "/")}, currentClassLoader);
			System.out.println("classpath= " + classPath);
			
			for (String packageName : packagesName) {
				
				String packageFolder = packageName.replace('.', '\\');
		        System.out.println("packageFolder  = " + classPath + "\\" + packageFolder);

		        File dir = new File(classPath + '\\' + packageFolder);
		        File classes[] = dir.listFiles();
		        System.out.println("length " + classes.length);
		        if (classes != null) {
		            for (File f : classes) {
		                String className = packageName + "." + f.getName().replace(".class", "");
		                listClass.addAll(classCharger(urlClassLoader, className));
		            }
		        }
			}
		} catch (Exception e) {
			System.out.println("Erreur = " + e.getMessage());
		}
		return listClass;
	}
	
	public List<Class<?>> classCharger(URLClassLoader urlClassLoader, String className) {
		List<Class<?>> classes = new Vector<Class<?>>();
		try {
            Class<?> loadedClass = urlClassLoader.loadClass(className);
            classes.add(loadedClass);
            System.out.println("- " + loadedClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            System.out.println("Classe non trouvée : " + className);
        }
		
		return classes;
	}
	
	
	
	
	
}
