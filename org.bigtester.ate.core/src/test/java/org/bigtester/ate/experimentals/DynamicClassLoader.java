/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.experimentals;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
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

import org.testng.Assert;
import org.testng.annotations.Test;
import org.codehaus.janino.JavaSourceClassLoader;
import org.bigtester.ate.model.project.IRunTestCase;
/**
 * The Class DynamicClassLoader.
 *
 * @author Peidong Hu
 */
public class DynamicClassLoader {
  
  /**
   * F test.
 * @throws InvocationTargetException 
 * @throws IllegalArgumentException 
 * @throws IllegalAccessException 
 * @throws InstantiationException 
 * @throws ClassNotFoundException 
 * @throws SecurityException 
 * @throws NoSuchMethodException 
   */
  public void fTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
	  ClassLoader classLoader = new JavaSourceClassLoader(
			  Thread.currentThread().getContextClassLoader(),  // parentClassLoader
			    new File[] { new File(System.getProperty("user.dir") + "/generated-code/caserunners") }, // optionalSourcePath
			    (String) null                     // optionalCharacterEncoding
			);
	  IRunTestCase obj = (IRunTestCase) classLoader.loadClass("org.bigtester.ate.model.project.CaseRunner8187856223134148550").newInstance();
	  obj.setCurrentExecutingTCName("test case name example");
	  Assert.assertEquals(obj.getCurrentExecutingTCName(), "test case name example");
  }
  
  /**
   * F2 test.
 * @throws IllegalAccessException 
 * @throws InstantiationException 
 * @throws ClassNotFoundException 
 * @throws MalformedURLException 
   */
  @Test
  public void f2Test() throws InstantiationException, IllegalAccessException, ClassNotFoundException, MalformedURLException {
	  /** Compilation Requirements *********************************************************************************************/
      DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

      // This sets up the class path that the compiler will use.
      // I've added the .jar file that contains the DoStuff interface within in it...
      List<String> optionList = new ArrayList<String>();
      optionList.add("-classpath");
      optionList.add(System.getProperty("java.class.path") + ";dist/InlineCompiler.jar");

      File helloWorldJava = new File(System.getProperty("user.dir") + "/generated-code/caserunners/org/bigtester/ate/model/project/CaseRunner8187856223134148550.java");
      
      Iterable<? extends JavaFileObject> compilationUnit
              = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
      JavaCompiler.CompilationTask task = compiler.getTask(
          null, 
          fileManager, 
          diagnostics, 
          optionList, 
          null, 
          compilationUnit);
      /********************************************************************************************* Compilation Requirements **/
      if (task.call()) {
          /** Load and execute *************************************************************************************************/
          System.out.println("Yipe");
          // Create a new custom class loader, pointing to the directory that contains the compiled
          // classes, this should point to the top of the package structure!
          URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(System.getProperty("user.dir") + "/generated-code/caserunners/").toURI().toURL()});
          // Load the class from the classloader by name....
          Class<?> loadedClass = classLoader.loadClass("org.bigtester.ate.model.project.CaseRunner8187856223134148550");
          // Create a new instance...
          Object obj = loadedClass.newInstance();
          // Santity check
          if (obj instanceof IRunTestCase) {
        	  ((IRunTestCase) obj).setCurrentExecutingTCName("test case name example");
        	  Assert.assertEquals(((IRunTestCase) obj).getCurrentExecutingTCName(), "test case name example");
        	  System.out.println("pass");
          }
          /************************************************************************************************* Load and execute **/
      } else {
          for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
              System.out.format("Error on line %d in %s%n",
                      diagnostic.getLineNumber(),
                      diagnostic.getSource().toUri());
          }
      }
  }
}
