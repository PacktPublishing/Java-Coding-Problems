package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class Packages {

    private static final Logger logger = Logger.getLogger(Packages.class.getName());
        
    private static final String CLASS_EXTENSION = ".class";
    private static final String JAR_EXTENSION = ".jar";
    private static final String JAR_PREFIX = "jar:";

    private Packages() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<Class<?>> fetchClassesFromPackage(
            String packageName) throws URISyntaxException, IOException {

        List<Class<?>> classes = new ArrayList<>();

        String packagePath = packageName.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(packagePath);

        if (resource != null) {
            logger.log(Level.INFO, "Current package: {0}", packagePath);
            logger.log(Level.INFO, "As resource: {0}", resource);

            if (resource.toString().startsWith(JAR_PREFIX)) {
                classes.addAll(fetchClassesFromJar(resource, packageName));
            } else {                
                File file = new File(resource.toURI());
                classes.addAll(fetchClassesFromDirectory(file, packageName));
            }
        } else {
            throw new RuntimeException("Resource not found for package: " + packageName);
        }

        return classes;
    }

    private static List<Class<?>> fetchClassesFromDirectory(File directory, String packageName)
            throws IOException {

        List<Class<?>> classes = new ArrayList<>();

        logger.log(Level.INFO, "Processing directory: {0}", directory);

        String[] files = directory.list();
        for (String file : files) {

            String className = null;
            if (file.endsWith(CLASS_EXTENSION)) {
                className = packageName + '.'
                        + file.substring(0, file.lastIndexOf(CLASS_EXTENSION));
            }

            if (className != null) {
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException | NoClassDefFoundError e) {
                    logger.log(Level.SEVERE, "Cannot instantiate: [{0}] {1}", new Object[]{className, e});
                }
            }

            File subDir = new File(directory, file);
            if (subDir.isDirectory()) {
                classes.addAll(fetchClassesFromDirectory(subDir, packageName + '.' + file));
            }
        }

        return classes;
    }

    public static List<Class<?>> fetchClassesFromJar(URL resource, String packageName)
            throws IOException {
        
        String resourcePath = resource.getPath();

        String jarPath = resourcePath
                .replaceFirst("[.]jar[!].*", ".jar")
                .replaceFirst("file:", "")
                .replace(" ", "\\ ");
        jarPath = URI.create(jarPath).getPath();
        
        return fetchClassesInSamePackageFromJar(packageName, jarPath, null);        
    }

    public static URL[] fetchJarsUrlsFromClasspath(Path classpath) throws IOException {

        if (classpath == null) {
            throw new IllegalArgumentException("Classpath cannot be null");
        }

        List<URL> urlsOfJars = new ArrayList<>();

        List<File> jarFiles = Files.find(
                classpath,
                Integer.MAX_VALUE,
                (path, attr) -> !attr.isDirectory()
                && path.toString().toLowerCase().endsWith(JAR_EXTENSION))
                .map(Path::toFile)
                .collect(Collectors.toList());

        for (File jarFile : jarFiles) {
            try {
                urlsOfJars.add(jarFile.toURI().toURL());
            } catch (MalformedURLException e) {
                logger.log(Level.SEVERE, "Bad URL for{0} {1}", new Object[]{jarFile, e});
            }
        }

        return urlsOfJars.toArray(URL[]::new);
    }

    public static List<Class<?>> fetchClassesFromPackage(
            String packageName, URLClassLoader urlClassLoader) throws IOException {

        List<Class<?>> classes = new ArrayList<>();

        for (URL jarURL : urlClassLoader.getURLs()) {
            classes.addAll(fetchClassesInSamePackageFromJar(
                    packageName, jarURL.getPath(), urlClassLoader));
        }

        return classes;
    }

    public static List<Class<?>> fetchClassesInSamePackageFromJar(
            String packageName, String jarPath, URLClassLoader urlClassLoader)
            throws IOException {

        List<Class<?>> classes = new ArrayList<>();

        String packagePath = packageName.replace('.', '/');

        try (JarFile jarFile = new JarFile(jarPath)) {

            Enumeration<JarEntry> en = jarFile.entries();
            while (en.hasMoreElements()) {
                JarEntry entry = en.nextElement();
                String entryName = entry.getName();

                if (entryName != null 
                        && entryName.endsWith(CLASS_EXTENSION)
                        && entryName.startsWith(packagePath)
                        && !entryName.substring(packagePath.length() + 1).contains("/")) {

                    try {
                        String entryToLoad = entryName.substring(
                                0, entryName.lastIndexOf(CLASS_EXTENSION))
                                        .replace('/', '.');
                        
                        Class<?> entryClass = 
                                urlClassLoader == null ? Class.forName(entryToLoad) 
                                : urlClassLoader.loadClass(entryToLoad);                               

                        if (entryClass != null) {
                            classes.add(entryClass);
                        }
                    } catch (ClassNotFoundException | NoClassDefFoundError e) {
                        logger.log(Level.SEVERE, "Cannot instantiate: {0} {1}", 
                                new Object[]{entryName, e.toString()});
                    }
                }
            }
        }

        return classes;
    }
        
    public static List<String> fetchPackagesByPrefix(String prefix) {

        if (prefix == null || prefix.length() == 0) {
            throw new IllegalArgumentException("Prefix cannot be null or empty");
        }        
        
        return Arrays.stream(Package.getPackages())
                .map(Package::getName)
                .filter(n -> n.startsWith(prefix))
                .collect(Collectors.toList());
    }

}
