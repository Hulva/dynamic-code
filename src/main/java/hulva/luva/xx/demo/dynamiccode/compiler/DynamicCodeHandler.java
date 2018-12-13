package hulva.luva.xx.demo.dynamiccode.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.newegg.ec2.platform.gatewaytoes.logmessagehandle.AbstractLogMessageHandler;

/**
 * @author Hulva Luva.H
 * @date 2018年12月13日
 * @description
 *
 */
public class DynamicCodeHandler {

  private static DynamicCodeHandler dynamicCodeHandler = null;

  private DynamicCodeHandler() {}

  public static DynamicCodeHandler build() {
    dynamicCodeHandler = dynamicCodeHandler == null ? new DynamicCodeHandler() : dynamicCodeHandler;
    return dynamicCodeHandler;
  }

  public int compile() {
    StringBuilder sb = new StringBuilder(64);
    sb.append("package testcompile;\n");
    sb.append("public class HelloWorld implements inlinecompiler.InlineCompiler.DoStuff {\n");
    sb.append("    public void doStuff() {\n");
    sb.append("        System.out.println(\"Hello world\");\n");
    sb.append("    }\n");
    sb.append("}\n");

    File helloWorldJava = new File("testcompile/HelloWorld.java");
    if (helloWorldJava.getParentFile().exists() || helloWorldJava.getParentFile().mkdirs()) {
      URLClassLoader classLoader = null;
      try {
        Writer writer = null;
        try {
          writer = new FileWriter(helloWorldJava);
          writer.write(sb.toString());
          writer.flush();
        } finally {
          try {
            writer.close();
          } catch (Exception e) {
          }
        }

        /**
         * Compilation Requirements
         *********************************************************************************************/
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        // This sets up the class path that the compiler will use.
        // I've added the .jar file that contains the DoStuff interface within in it...
        List<String> optionList = new ArrayList<String>();
        optionList.add("-classpath");
        optionList.add(System.getProperty("java.class.path") + ";dist/InlineCompiler.jar");

        Iterable<? extends JavaFileObject> compilationUnit = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, optionList, null, compilationUnit);
        /*********************************************************************************************
         * Compilation Requirements
         **/
        if (task.call()) {
          /**
           * Load and execute
           *************************************************************************************************/
          System.out.println("Yipe");
          // Create a new custom class loader, pointing to the directory that contains the compiled
          // classes, this should point to the top of the package structure!
          classLoader = new URLClassLoader(new URL[] {new File("./").toURI().toURL()});
          // Load the class from the classloader by name....
          Class<?> loadedClass = classLoader.loadClass("testcompile.HelloWorld");
          // Create a new instance...
          Object obj = loadedClass.newInstance();
          // Santity check
          if (obj instanceof AbstractLogMessageHandler) {
            // Cast to the DoStuff interface
            AbstractLogMessageHandler stuffToDo = (AbstractLogMessageHandler) obj;
            // Run it baby
            stuffToDo.getSchema();
          }
          /*************************************************************************************************
           * Load and execute
           **/
        } else {
          for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            System.out.format("Error on line %d in %s%n", diagnostic.getLineNumber(), diagnostic.getSource().toUri());
          }
        }
        fileManager.close();
      } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException exp) {
        exp.printStackTrace();
      } finally {
        if (classLoader != null) {
          try {
            classLoader.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return 0;
  }
}
