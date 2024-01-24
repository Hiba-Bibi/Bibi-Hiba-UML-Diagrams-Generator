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
    
        // Créer une instance de la classe Memory qui gère la mémoire du projet
        Memory memory = new Memory();
        
        // Récupérer un projet à partir de la mémoire
        Project projet = memory.getProject("C:\\Users\\lenovo\\Desktop\\TPs\\For Test");
        
        // Convertir le projet en XML en utilisant la classe ObjectsToXml
        ObjectsToXml xml = new ObjectsToXml(projet);
        xml.convert();
        
        // Instancier un objet de la classe Handler pour parser le fichier XML généré
        Handler parser = new Handler();
        
        // Parser le fichier XML et obtenir un projet en mémoire
        Project project = parser.parse("resources\\Project_Data.xml");
    
        // Parcourir les packages du projet
        for (org.java.mql.models.Package pack : project.getPackages()) {
            System.out.println("*******************************************Package name is = " + pack.getPackage());
            // Parcourir les classes du package
            for (Class classe : pack.getClasses()) {
                System.out.println("**********************************Class = " + classe.getClassName());
                // Afficher les champs de la classe
                System.out.println("**************************Fields");
                for (Field field : classe.getFields()) {
                    System.out.println(field.getModifier() + " " + field.getType() + " " + field.getName() );
                }
                // Afficher les méthodes de la classe
                System.out.println("**************************Methods");
                for (Method method : classe.getMethods()) {
                    System.out.println(method.getModifier() + " " + method.getReturnType() + " " + method.getName());
                }
                // Afficher les constructeurs de la classe
                System.out.println("**************************Constructors");
                for (Constructor constructor : classe.getConstructors()) {
                    System.out.println(constructor.getModifier() + " " + constructor.getName());
                }
                // Afficher les relations de la classe
                System.out.println("**************************Relations");
                for (Relation relation : classe.getRelations()) {
                    System.out.println(relation.getClassName() + " " + relation.getName());
                }
            }
            
            // Parcourir les interfaces du package
            List<Interface> interfaces = pack.getInterfaces();
            for (Interface classe : interfaces) {
                System.out.println("***************************************Interface = " + classe.getInterface());
                // Afficher les méthodes de l'interface
                System.out.println("*****************************methods");
                List<Method> methods = classe.getMethods();
                for (Method method : methods) {
                    System.out.println(method.getModifier() + " " + method.getReturnType() + " " + method.getName());
                }
                
            }   
            
            // Parcourir les annotations du package
            List<Annotation> annotations = pack.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("***************************************Annotation = " + annotation.getAnnotation());
                // Afficher les méthodes de l'annotation
                System.out.println("*****************************methods");
                List<Method> methods = annotation.getMethods();
                for (Method method : methods) {
                    System.out.println(method.getModifier() + " " + method.getReturnType() + " " + method.getName());
                }   
            }   
        }
    }
    
    // Point d'entrée du programme
    public static void main(String[] args){
        // Créer une instance de la classe Test pour exécuter l'expérience
        new Test();
    }
}
