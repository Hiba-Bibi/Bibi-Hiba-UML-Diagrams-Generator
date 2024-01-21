package org.java.mql.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.java.mql.explorer.Memory;
import org.java.mql.models.Project;

public class ObjectsToXml {
	
	Project project ;
	
	public ObjectsToXml(Project project) {
		this.project = project;
	}
	
	
	public void convert() {
		
		Memory memoire = new Memory();
		File outputFile = new File("resources\\Project_Data.xml");
		try {
		JAXBContext context = JAXBContext.newInstance(Project.class);
	    Marshaller marshaller = context.createMarshaller();
	
	  
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
	    // Sérialiser l'objet en XML
	    marshaller.marshal(this.project, outputFile);
		} catch (JAXBException e) {
	        e.printStackTrace();
	    }
		
	}
}
