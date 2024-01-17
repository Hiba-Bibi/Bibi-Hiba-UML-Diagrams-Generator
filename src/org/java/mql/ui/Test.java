package org.java.mql.ui;


import org.java.mql.JAXB.ObjectsToXml;
import org.java.mql.explorer.Memory;
import org.java.mql.models.Project;

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
    }
    
    
    
    public static void main(String[] args){
        new Test();
    }
}
