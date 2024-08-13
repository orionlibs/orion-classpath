package io.github.orionlibs.orion_classpath;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClasspathService
{
    public static List<URL> getJARFilesFromClasspathAsURLs()
    {
        List<URL> JARFilesInClasspath = new ArrayList<>();
        String classpath = System.getProperty("java.class.path");
        String[] JARFiles = classpath.split(File.pathSeparator);
        for(String JARFile : JARFiles)
        {
            try
            {
                JARFilesInClasspath.add(new File(JARFile).toURI().toURL());
            }
            catch(MalformedURLException e)
            {
                System.err.println("Error initializing classpath " + e);
            }
        }
        return JARFilesInClasspath;
    }


    public static URL[] getJARFilesFromClasspathAsURLsArray()
    {
        return getJARFilesFromClasspathAsURLs().toArray(new URL[0]);
    }
}