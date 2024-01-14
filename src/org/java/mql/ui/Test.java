package org.java.mql.ui;

import java.util.List;

import org.java.mql.Explorer.Memory;
import org.java.mql.models.Class;
import org.java.mql.models.Package;
import org.java.mql.models.Project;

public class Test {
	
    public Test(){
        exp01();
    }

    private void exp01() {
    
    	Memory m = new Memory();
    	System.out.println(System.getProperty("java.class.path"));
    	Project projet = m.getProject("C:\\Users\\lenovo\\Desktop\\TPs\\For Test");
    	
    	List<Package> packages = projet.getPackages();
    	for (Package p : packages) {
			System.out.println("************************Package " +p.getPackage());
			List<Class> classes = p.getClasses();
			for (Class classe : classes) {
				System.out.println("*************Class " + classe.getClassName());
				List<String> fields = classe.getProperties();
				for (int i=0 ;i<fields.size() ;i+=3) {
					System.out.println("*************field " + fields.get(i) + " " + fields.get(i+1) + " " +fields.get(i+2));
				}
				
				List<String> methods = classe.getMethods();
				for (int i=0 ;i<methods.size() ;i+=3) {
					System.out.println("*************method " + methods.get(i) + " " + methods.get(i+1) + " " +methods.get(i+2));
				}
				List<String> constructors = classe.getConstructors();
				for (int i=0 ;i<constructors.size() ;i+=2) {
					System.out.println("*************constructors " + constructors.get(i) + " " + constructors.get(i+1));
				}
				
			}
		}
    }
    
    public static void main(String[] args){
        new Test();
    }
}
