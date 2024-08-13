package io.github.orionlibs.orion_classpath;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class JARFileService
{
    public static void executeMainMethodInJARFile(String mainClassName, String[] args)
    {
        URL[] JARFilesInClasspath = ClasspathService.getJARFilesFromClasspathAsURLsArray();
        ClassLoader loader = new URLClassLoader(JARFilesInClasspath, null);
        try
        {
            Thread.currentThread().setContextClassLoader(loader);
            Class<?> c = Class.forName(mainClassName, true, loader);
            Method m = c.getMethod("main", args.getClass());
            m.invoke(null, (Object)args);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error starting OpenRocket", e);
        }
    }
}