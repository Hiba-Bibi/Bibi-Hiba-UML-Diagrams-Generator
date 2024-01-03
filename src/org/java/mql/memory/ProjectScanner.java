package org.java.mql.memory;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ProjectScanner {

	private Set<String> packageNames;
	
	public ProjectScanner() {
	}
	
	
	public Set<String> projectScanner(String classpath) {
		
		packageNames = new HashSet<>();
		classpath = classpath + "\\bin";
		System.out.println(classpath);
		
		File repertoire = new File(classpath);
		if(repertoire.isDirectory() && repertoire.exists()) {
			 for (File file : repertoire.listFiles()) {
				 packageNames.addAll(scanFolder(file,repertoire.getAbsolutePath()));
		        } 
	         }
		else {
            System.out.println("Le dossier spécifié n'existe pas ou n'est pas un dossier valide.");
        }
		
	 	return packageNames;
	}

	public Set<String> scanFolder(File repertoire,String binPath) {
		File[] files = repertoire.listFiles();
		if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                	packageNames.addAll(scanFolder(file,binPath));
                } else {
                    if (file.getName().endsWith(".class")) {
                     	packageNames.add(getPackageName(file,binPath));
					}
                }
            }
        }
		
	return packageNames;
	}
	
	private String getPackageName(File Classpath,String binPath) {
		String absolutePath = Classpath.getAbsolutePath();
		String className =absolutePath.substring(0, absolutePath.length() - 6);
		String relativePath = className.substring(binPath.length() + 1);
        return removeLastElement(relativePath);
    }
	
	private static String removeLastElement(String path) {
        int lastSeparatorIndex = path.lastIndexOf("\\");
        
        if (lastSeparatorIndex != -1) {
            return path.substring(0, lastSeparatorIndex);
        } else {
            return path;
        }
    }
	
	/*
	public String getPackage(String className) {
		className = className.replace("\\", ".");
		String packageName = "";
		
			try {
			Class<?> myClass = Class.forName(className);
			packageName = myClass.getPackageName();
			} catch (Exception e) {
			System.out.println("Erreur = " + e.getMessage());
			}
			return packageName;
	}
	*/
	public void classScanner() {
		
	}
	
	
}
