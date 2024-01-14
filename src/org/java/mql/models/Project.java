package org.java.mql.models;

import java.util.List;
import java.util.Vector;

public class Project {
	
	private List<Package> packages;
	
	
	public Project() {
		packages = new Vector<Package>();
	}


	public List<Package> getPackages() {
		return packages;
	}


	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	
	
	public void setPackage(Package Package) {
		this.packages.add(Package);
	}
	

}
