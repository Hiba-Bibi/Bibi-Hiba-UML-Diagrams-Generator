package org.java.mql.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Annotation {

	private String annotation;
	
	public Annotation() {
	}
	@XmlAttribute(name = "name",  required = true)
	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	
	
	
}
