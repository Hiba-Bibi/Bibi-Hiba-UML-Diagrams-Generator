package org.java.mql.ui;



import java.util.Set;

import org.java.mql.memory.ProjectScanner;

public class Test {

	public Test() {
		exp01();
	}
	
	
	public void exp01() {
		ProjectScanner memoir = new ProjectScanner();
		String classpath = System.getProperty("java.class.path") ;
		Set<String> packages = memoir.projectScanner("C:\\Users\\lenovo\\Desktop\\TPs\\UML Diagrams Generator");
		for (String p : packages) {
			System.out.println(p);
		}
	}
	
	
	public static void main(String[] args) {
		new Test();
	}
	
	

	
}
