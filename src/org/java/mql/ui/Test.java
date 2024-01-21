package org.java.mql.ui;


import java.util.List;

import org.java.mql.JAXB.ObjectsToXml;
import org.java.mql.explorer.Memory;
import org.java.mql.models.Annotation;
import org.java.mql.models.Class;
import org.java.mql.models.Constructor;
import org.java.mql.models.Field;
import org.java.mql.models.Interface;
import org.java.mql.models.Method;
import org.java.mql.models.Project;
import org.java.mql.models.Relation;
import org.java.mql.parser.Handler;

public class Test {
	
    public Test() {
        exp01();
    }

    private void exp01()  {
    
    	Memory memory = new Memory();
    	System.out.println(System.getProperty("java.class.path"));
    	Project projet = memory.getProject("C:\\Users\\lenovo\\Desktop\\TPs\\For Test");
    	
    	ObjectsToXml xml = new ObjectsToXml(projet);
    	xml.convert();
    	
    	Handler parser = new Handler();
    	
    	Project project = parser.parse("resources\\Project_Data.xml");
    
    	for (org.java.mql.models.Package pack : project.getPackages()) {
			System.out.println("*******************************************Package name is = " + pack.getPackage());
			for (Class classe : pack.getClasses()) {
				System.out.println("**********************************Class = " + classe.getClassName());
				System.out.println("**************************Fields");
				for (Field field : classe.getFields()) {
					System.out.println(field.getModifier() + " " + field.getType() + " " + field.getName() );
				}
				System.out.println("**************************Methods");
				for (Method method : classe.getMethods()) {
					System.out.println(method.getModifier() + " " + method.getReturnType() + " " + method.getName());
				}
				System.out.println("**************************Constructors");
				for (Constructor constructor : classe.getConstructors()) {
					System.out.println(constructor.getModifier() + " " + constructor.getName());
				}
				System.out.println("**************************Relations");
				for (Relation relation : classe.getRelations()) {
					System.out.println(relation.getClassName() + " " + relation.getName());
				}
			}
			
		
			List<Interface> interfaces = pack.getInterfaces();
			for (Interface classe : interfaces) {
				System.out.println("***************************************Interface = " + classe.getInterface());
				System.out.println("*****************************methods");
				List<Method> methods = classe.getMethods();
				for (Method method : methods) {
					System.out.println(method.getModifier() + " " + method.getReturnType() + " " + method.getName());
				}
				
			}	
				List<Annotation> annotations = pack.getAnnotations();
				for (Annotation annotation : annotations) {
					System.out.println("***************************************Annotation = " + annotation.getAnnotation());
					System.out.println("*****************************methods");
					List<Method> methods = annotation.getMethods();
					for (Method method : methods) {
						System.out.println(method.getModifier() + " " + method.getReturnType() + " " + method.getName());
					}	
				}	
		}
    }
    
    
    
    public static void main(String[] args){
        new Test();
    }
}
