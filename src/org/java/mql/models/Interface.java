package org.java.mql.models;

import java.util.List;
import java.util.Vector;

public class Interface {

	private List<String> methods;
	private String interfac;
	
	public Interface() {
		methods = new Vector<String>();
	}

	public List<String> getMethods() {
		return methods;
	}

	
	public String getInterface() {
		return interfac;
	}

	public void setInterface(String interfac) {
		this.interfac = interfac;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}
	
	public void setMethod(String method) {
		this.methods.add(method);
	}
	
}
