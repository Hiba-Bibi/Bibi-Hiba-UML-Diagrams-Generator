package org.java.mql.explorer;

import org.java.mql.models.Annotation;
import org.java.mql.models.Class;
import org.java.mql.models.Enumeration;
import org.java.mql.models.Interface;
import org.java.mql.models.Package;
import org.java.mql.models.Project;

public class Memory {

    private Project project;

    public Memory() {
    }

    // Méthode pour explorer et scanner le projet
    public Project getProject(String projectName) {
        // Chemin du répertoire bin du projet
        String classpath = projectName + "\\bin";

        // Initialisation du projet
        project = new Project();

        // Exploration des packages du projet
        ProjectExplorer projectE = new ProjectExplorer();
        for (String pack : projectE.scan(projectName)) {
            // Création d'une instance de Package pour chaque package trouvé
            Package packa = new Package();
            packa.setPackage(pack);
            project.setPackage(packa);
        }

        // Exploration des classes, annotations, énumérations et interfaces pour chaque package
        PackageExplorer packE = new PackageExplorer();
        for (Package pack : project.getPackages()) {
            // Exploration des classes dans le package
            for (java.lang.Class<?> clazz : packE.getClasses(pack.getPackage(), classpath)) {
                ClassExplorer classE = new ClassExplorer(clazz);

                // Création d'une instance de Class pour chaque classe trouvée
                Class NewClass = new Class();
                NewClass.setClassName(clazz.getSimpleName());
                NewClass.setFields(classE.getProperties());
                NewClass.setMethods(classE.getMethods());
                NewClass.setConstructors(classE.getConstructors());
                NewClass.setRelations(classE.getRelations());
                // Ajout de la classe au package
                pack.setClasse(NewClass);
            }

            // Exploration des annotations dans le package
            for (java.lang.Class<?> annotation : packE.getAnnotations(pack.getPackage(), classpath)) {
            	 ClassExplorer classE = new ClassExplorer(annotation);
                // Création d'une instance d'Annotation pour chaque annotation trouvée
                Annotation NewAnnotation = new Annotation();
                NewAnnotation.setAnnotation(annotation.getSimpleName());
                NewAnnotation.setMethods(classE.getMethods());
                // Ajout de l'annotation au package
                pack.setAnnotation(NewAnnotation);
            }

            // Exploration des énumérations dans le package
            for (java.lang.Class<?> enumeration : packE.getEnumerations(pack.getPackage(), classpath)) {
                // Création d'une instance d'Enumeration pour chaque énumération trouvée
                Enumeration newEnumeration = new Enumeration();
                newEnumeration.setEnumeration(enumeration.getSimpleName());
                // Ajout de l'énumération au package
                pack.setEnumeration(newEnumeration);
            }

            // Exploration des interfaces dans le package
            for (java.lang.Class<?> Interface : packE.getInterfaces(pack.getPackage(), classpath)) {
                ClassExplorer classE = new ClassExplorer(Interface);

                // Création d'une instance d'Interface pour chaque interface trouvée
                Interface newInterface = new Interface();
                newInterface.setInterface(Interface.getSimpleName());
                newInterface.setMethods(classE.getMethods());

                // Ajout de l'interface au package
                pack.setInterface(newInterface);
            }
        }
        return project;
    }
    
    
   
}
