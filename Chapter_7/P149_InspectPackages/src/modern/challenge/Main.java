package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());   
    
    public static void main(String[] args) 
            throws ClassNotFoundException, URISyntaxException, IOException {
        
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        
        logger.info("Get the package name of Integer class");        
        Class clazz1 = Class.forName("java.lang.Integer");
        Package packageOfClazz1 = clazz1.getPackage();
        String packageNameOfClazz1 = packageOfClazz1.getName();
        logger.log(Level.INFO, "Package = {0}\n\n", packageNameOfClazz1);

        logger.info("Get the package name of File class");        
        File file = new File(".");
        Package packageOfFile = file.getClass().getPackage();
        String packageNameOfFile = packageOfFile.getName();
        logger.log(Level.INFO, "Package name of File: {0} \n\n", packageNameOfFile);

        logger.info("Get the package name of this class (Main)");        
        Main main = new Main();
        // this.getClass().getPackage(); - in a non-static context
        Package packageOfMain = main.getClass().getPackage();
        String packageNameOfMain = packageOfMain.getName();
        logger.log(Level.INFO, "Package name of Main: {0} \n\n", packageNameOfMain);
        
        logger.info("Get the packages names with the given prefix");        
        List<String> packagesSamePrefix = Packages.fetchPackagesByPrefix("java.util");
        logger.log(Level.INFO, "Packages: {0} \n\n", packagesSamePrefix);        
    
        logger.info("Get the clasess of the specified package");        
        List<Class<?>> classes1 = Packages.fetchClassesFromPackage("org.apache.commons.lang3.builder");      
        logger.log(Level.INFO, "Classes: {0} size: {1} \n\n", new Object[]{classes1, classes1.size()});
        
        logger.info("Get the classes of the spcified package via an URLClassLoader");        
        URL[] urls = Packages.fetchJarsUrlsFromClasspath(Path.of("D:/tomcat8/lib"));
        URLClassLoader urlClassLoader = new URLClassLoader(
                urls, Thread.currentThread().getContextClassLoader());
        List<Class<?>> classes2 = Packages.fetchClassesFromPackage(
                  "org.apache.tomcat.jdbc.pool", urlClassLoader);                               
        logger.log(Level.INFO, "Classes: {0} size: {1} \n\n", new Object[]{classes2, classes2.size()});
    }
}
