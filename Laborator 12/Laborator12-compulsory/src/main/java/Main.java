import org.testng.annotations.Test;
import java.io.File;
import java.lang.reflect.*;

/**
 * authors Petrea Daniela and Stoica Dragos
 * we load MyTestClass in memory, and using reflection, extract name and methods about the class
 * using reflection, we invoke the static methods, with no arguments, annotated with @Test
 */
public class Main {
    public static void main(String[] args) {
        String absolutePath = "C:\\Users\\Daniela-211021\\IdeaProjects\\Laborator12-compulsory\\target\\classes\\newClass\\MyTestClass";
        String pathToClasses = absolutePath.substring(0, absolutePath.lastIndexOf("\\"));
        String packageAndClass = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1);
        try {
            packageAndClass = pathToClasses.substring(pathToClasses.lastIndexOf("\\") + 1) + "." + packageAndClass;
            pathToClasses = pathToClasses.substring(0, pathToClasses.lastIndexOf("\\"));
            File path = new File(pathToClasses);
            if (path.exists()) {
                Class cls = Class.forName(packageAndClass);
                System.out.println("Classname: " + cls.getName().substring(cls.getName().lastIndexOf(".")+1));
                System.out.println("Path: " + pathToClasses);
                System.out.println("PackageAndClass: " + packageAndClass);
                System.out.println("Methods:");
                for (Method method : Class.forName(packageAndClass).getMethods()) {
                    System.out.printf("%s %s(", method.getReturnType(), method.getName());
                    for (var parameter : method.getParameterTypes()) {
                        System.out.printf(" %s ", parameter.getCanonicalName());
                    }
                    System.out.printf(")\n");
                }
                System.out.println("Test methods:");
                for (Method method : Class.forName(packageAndClass).getMethods()) {
                    if (method.isAnnotationPresent(Test.class)) {
                        try {
                            method.invoke(null);
                        } catch (Throwable exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
        }
    }
}
