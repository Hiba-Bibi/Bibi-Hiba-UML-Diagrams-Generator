package org.java.mql.Explorer;

import java.util.HashSet;
import java.util.Set;

public class Memory {
	
	public Memory() {
	 	ProjectScanner p = new ProjectScanner();
    	PackageScanner pa = new PackageScanner();
    	String classpath = "C:\\Users\\lenovo\\Desktop\\TPs\\For Test\\bin";
    	Set<String> packageNames = new HashSet<>();
    	packageNames = p.scan("C:\\Users\\lenovo\\Desktop\\TPs\\For Test");
    	pa.scan(packageNames,classpath);
	
	}
}
