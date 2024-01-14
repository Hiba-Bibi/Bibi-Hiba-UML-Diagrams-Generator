package org.java.mql.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

public class Class {
	
	private List<String> properties;
	private List<String> methods;
	private List<String> constructors;
	private String className;
	
	public Class() {
		properties = new Vector<String>();
		methods = new Vector<String>();
		constructors = new Vector<String>();
	}

	public List<String> getProperties() {
		return properties;
	}

	public List<String> getMethods() {
		return methods;
	}

	public List<String> getConstructors() {
		return constructors;
	}

	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public void setConstructors(List<String> constructors) {
		this.constructors = constructors;
	}

	public void setPropertie(String propertie) {
		this.properties.add(propertie);
	}

	public void setMethod(String method) {
		this.methods.add(method);
	}

	public void setConstructor(String constructor) {
		this.constructors.add(constructor);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
}
