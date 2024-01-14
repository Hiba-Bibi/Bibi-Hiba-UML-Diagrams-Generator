package org.java.mql.Explorer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Vector;


public class ClassExplorer {

	private Class<?> MyClass;
	
	public ClassExplorer(Class<?> MyClass) {
	
		this.MyClass = MyClass;
		
	}
	
	public List<String> getProperties(){
		List<String> properties = new Vector<String>();
		Field[] fields = MyClass.getDeclaredFields();
		for (Field field : fields) {
			properties.add(Modifier.toString(field.getModifiers()));
			properties.add(field.getType().getName());
			properties.add(field.getName());
		}
		return properties;
	}
	
	
	public List<String> getMethods(){
		List<String> methodes = new Vector<String>();
		Method[] methods = MyClass.getDeclaredMethods();
		for (Method methode : methods) {
			methodes.add(Modifier.toString(methode.getModifiers()));
			methodes.add(methode.getReturnType().getName());
			methodes.add(methode.getName());
		}
		return methodes;
	}
	
	public List<String> getConstructors(){
		List<String> constructors = new Vector<>();
		Constructor<?>[] AllConstructors = MyClass.getDeclaredConstructors();
		for (Constructor<?> constructor : AllConstructors) {
			constructors.add(Modifier.toString(constructor.getModifiers()));
			constructors.add(constructor.getName());
			//constructors.addAll(constructor.getParameterTypes());
		}
		return constructors;
	}
	
}
