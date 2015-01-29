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
package org.bigtester.ate.model.caserunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import jodd.util.ClassLoaderUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.EnumCaseDependencyType;
import org.bigtester.ate.model.project.CaseDependency;
import org.bigtester.ate.model.project.TestSuite;
import org.bigtester.ate.model.project.XmlTestCase;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

// TODO: Auto-generated Javadoc
/**
 * This class CaseRunnerGenerator defines ....
 * 
 * @author Peidong Hu
 *
 */
public class CaseRunnerGenerator {

	/** The number of test cases. */
	transient private long numberOfTestCases;

	/** The case runner java file path names. */
	transient private Map<String, String> caseRunnerJavaFileNames = new HashMap<String, String>();

	/** The package name. */
	@Nullable
	private String basePackageName;

	/** The case runner template. */
	public final static String caseRunnerTemplateFileName = "CaseRunner";// NOPMD

	/** The case runner cache folder. */
	final private String caseRunnerCacheAbsoluteFolder;

	/** The suites. */
	final private List<TestSuite> suites;

	/**
	 * @return the caseRunnerCacheAbsoluteFolder
	 */
	public String getCaseRunnerCacheAbsoluteFolder() {
		return caseRunnerCacheAbsoluteFolder;
	}

	/**
	 * Instantiates a new case runner generator.
	 *
	 * @param numberOfTestCases
	 *            the number of test cases
	 * @throws IOException 
	 */
	public CaseRunnerGenerator(List<TestSuite> suites) throws IOException {
		this.suites = suites;
		for (TestSuite tSuite : suites) {
			this.numberOfTestCases = this.numberOfTestCases
					+ tSuite.getTestCaseList().size();
		}
		this.caseRunnerCacheAbsoluteFolder = System.getProperty("user.dir")
				+ "/generated-code/caserunners/org/bigtester/ate/model/caserunner/";
		File deleteOldCaseRunners = new File (caseRunnerCacheAbsoluteFolder);
		if (deleteOldCaseRunners.exists()) {
			FileUtils.deleteDirectory(deleteOldCaseRunners);
		}

	}

	/**
	 * Creates the case runners.
	 *
	 * @throws ParseException
	 *             the parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void createCaseRunners() throws ParseException, IOException {
		// creates an input stream for the file to be parsed
		for (TestSuite tSuite : suites) {
			File suiteCacheDir = new File(caseRunnerCacheAbsoluteFolder
					+ tSuite.getSuiteName() + "/");
			if (!suiteCacheDir.exists()) {
				suiteCacheDir.mkdirs();
			}
			for (int index = 0; index < tSuite.getTestCaseList().size(); index++) {
				Resource fTemp = new ClassPathResource(
						caseRunnerTemplateFileName);
				CompilationUnit caseRunnerCU;
				caseRunnerCU = JavaParser.parse(fTemp.getInputStream());
				this.basePackageName = caseRunnerCU.getPackage().getName()
						.toStringWithoutComments();
				try {
					File newCaseRunner = File.createTempFile("CaseRunner",
							".java", suiteCacheDir);
					this.caseRunnerJavaFileNames.put(tSuite.getTestCaseList()
							.get(index).getTestCaseFilePathName(),
							newCaseRunner.getCanonicalPath());
					new TestCaseNameFieldVisitor().visit(caseRunnerCU, tSuite
							.getTestCaseList().get(index)
							.getTestCaseFilePathName());
					new ClassNameVisitor().visit(caseRunnerCU, FilenameUtils
							.removeExtension(newCaseRunner.getName()));

					new PackageNameVisitor().visit(caseRunnerCU,
							this.basePackageName + "." + tSuite.getSuiteName());

					new MethodTestAnnotationVisitor().visit(caseRunnerCU,
							tSuite.getTestCaseList().get(index));

					// prints the changed compilation unit
					PrintWriter out = new PrintWriter(newCaseRunner);
					out.println(caseRunnerCU.toString());
					out.close();
				} catch (IOException ioE) {

					continue;
				}
				fTemp.getInputStream().close();
			}
		}

	}

	private String parsePackageName(String caseRunnerJavaFilePathName) {

		String testSuiteName = new File(caseRunnerJavaFilePathName)
				.getParentFile().getName();
		return this.basePackageName + "." + testSuiteName;
	}

	private String parseClassFullName(String caseRunnerJavaFilePathName) {
		String packageName = parsePackageName(caseRunnerJavaFilePathName);
		String caseRunnerFileName = new File(caseRunnerJavaFilePathName)
				.getName();
		return packageName + "."
				+ FilenameUtils.removeExtension(caseRunnerFileName);
	}

	public int loadCaseRunnerClasses() {
		int retVal = 0;
		Iterator<Entry<String, String>> it = caseRunnerJavaFileNames.entrySet()
				.iterator();
		while (it.hasNext()) {

			Map.Entry<String, String> pairs = (Map.Entry<String, String>) it
					.next();
			String caseRunnerJavaFilePath = pairs.getValue();
			if (caseRunnerJavaFilePath == null)
				continue;
			else {
				try {
					loadClass(caseRunnerJavaFilePath,
							parseClassFullName(caseRunnerJavaFilePath));
				} catch (InstantiationException | IllegalAccessException
						| MalformedURLException | ClassNotFoundException e) {
					continue;
				}
				retVal = retVal + 1;
			}
		}
		return retVal;
	}

	/**
	 * Change test annotation groups.
	 *
	 * @param caseRunnerRelativeFilePathName
	 *            the case runner relative file path name
	 * @param groups
	 *            the groups
	 * @param testMethodName
	 *            the test method name
	 * @throws ParseException
	 *             the parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void changeTestMethodName(String caseRunnerRelativeFilePathName,
			String testMethodName) throws ParseException, IOException {
		// creates an input stream for the file to be parsed
		FileInputStream fTemp = new FileInputStream(
				caseRunnerRelativeFilePathName);
		CompilationUnit caseRunnerCU;
		try {
			// parse the file
			caseRunnerCU = JavaParser.parse(fTemp);
		} finally {
			fTemp.close();

		}
		// visit and print the methods names
		new MethodNameVisitor().visit(caseRunnerCU, testMethodName);
		String newClass = caseRunnerCU.toString();
		fTemp.close();
		// prints the changed compilation unit
		FileWriter out = new FileWriter(caseRunnerRelativeFilePathName, false);
		out.write(newClass);
		out.close();
	}

	/**
	 * Change test annotation groups.
	 *
	 * @param caseRunnerAbsoluteFilePathName
	 *            the case runner relative file path name
	 * @param groups
	 *            the groups
	 * @param testMethodName
	 *            the test method name
	 * @throws ParseException
	 *             the parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void changeTestAnnotationGroups(
			String caseRunnerAbsoluteFilePathName, List<String> groups,
			String testMethodName) throws ParseException, IOException {
		// creates an input stream for the file to be parsed
		FileInputStream fTemp = new FileInputStream(
				caseRunnerAbsoluteFilePathName);
		CompilationUnit caseRunnerCU;
		try {
			// parse the file
			caseRunnerCU = JavaParser.parse(fTemp);
		} finally {
			fTemp.close();

		}

		groups.add(0, testMethodName);
		new MethodGroupAnnotationVisitor().visit(caseRunnerCU, groups);
		String newClass = caseRunnerCU.toString();
		fTemp.close();
		// prints the changed compilation unit
		FileWriter out = new FileWriter(caseRunnerAbsoluteFilePathName, false);
		out.write(newClass);
		out.close();
	}

	/**
	 * @return the numberOfTestCases
	 */
	public long getNumberOfTestCases() {
		return numberOfTestCases;
	}

	/**
	 * @return the caseRunnerJavaFilePathNames
	 */
	public Map<String, String> getCaseRunnerJavaFileNames() {
		return caseRunnerJavaFileNames;
	}

	/**
	 * @param caseRunnerJavaFileNames
	 *            the caseRunnerJavaFilePathNames to set
	 */
	public void setCaseRunnerJavaFileNames(
			Map<String, String> caseRunnerJavaFileNames) {
		this.caseRunnerJavaFileNames = caseRunnerJavaFileNames;
	}

	/**
	 * @return the packageName
	 */
	public String getBasePackageName() {

		final String packageName2 = basePackageName;
		if (null == packageName2) {
			throw GlobalUtils.createNotInitializedException("pageckage name");
		} else {
			return packageName2;
		}
	}

	/**
	 * @param packageName
	 *            the packageName to set
	 */
	public void setBasePackageName(String packageName) {
		this.basePackageName = packageName;
	}

	/**
	 * @return the suites
	 */
	public List<TestSuite> getSuites() {
		return suites;
	}

	/**
	 * The Class ClassVisitor.
	 *
	 * @author Peidong Hu
	 */
	private static class ClassNameVisitor extends VoidVisitorAdapter<String> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void visit(
				@Nullable ClassOrInterfaceDeclaration classInterfaceDec,
				@Nullable String newClassName) {
			if (null == classInterfaceDec)
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			else {
				if (classInterfaceDec.getName().equals("CaseRunner")) {
					classInterfaceDec.setName(newClassName);
				}
			}
		}
	}

	/**
	 * The Class ClassVisitor.
	 *
	 * @author Peidong Hu
	 */
	private static class TestCaseNameFieldVisitor extends
			VoidVisitorAdapter<String> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void visit(@Nullable FieldDeclaration fieldInterfaceDec,
				@Nullable String testCaseFilePath) {
			if (null == fieldInterfaceDec) {
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			} else {
				for (VariableDeclarator var : fieldInterfaceDec.getVariables()) {
					if (var.getId().getName().equals("currentExecutingTCName")) {
						var.setInit(new StringLiteralExpr(testCaseFilePath));
					}
				}
			}
		}
	}

	/**
	 * The Class PackageNameVisitor.
	 *
	 * @author Peidong Hu
	 */
	private static class PackageNameVisitor extends VoidVisitorAdapter<String> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void visit(@Nullable PackageDeclaration packageInterfaceDec,
				@Nullable String newPackageName) {
			if (null == packageInterfaceDec)
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			else {
				packageInterfaceDec.setName(new NameExpr(newPackageName));
			}
		}
	}

	/**
	 * Simple visitor implementation for visiting MethodDeclaration nodes.
	 *
	 * @author Peidong Hu
	 */
	private static class MethodNameVisitor extends VoidVisitorAdapter<String> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void visit(@Nullable MethodDeclaration methodDec,
				@Nullable String newMethodName) {
			if (null == methodDec)
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			else {
				if (methodDec.getName().equals("runTest")) {
					methodDec.setName(newMethodName);
				}
			}
		}
	}

	/**
	 * Simple visitor implementation for visiting MethodDeclaration nodes.
	 *
	 * @author Peidong Hu
	 */
	private static class MethodGroupAnnotationVisitor extends
			VoidVisitorAdapter<List<String>> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void visit(@Nullable MethodDeclaration methodDec,
				@Nullable List<String> groupNames) {
			if (null == methodDec || null == groupNames)
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			else {
				if (methodDec.getName().equals("runTest")) {
					List<Expression> groups = new ArrayList<Expression>();
					for (int i = 1; i < groupNames.size(); i++) {
						groups.add(new StringLiteralExpr(groupNames.get(i)));
					}
					List<MemberValuePair> testAnnoParams = new ArrayList<MemberValuePair>();
					testAnnoParams.add(new MemberValuePair("groups",
							new ArrayInitializerExpr(groups)));
					NormalAnnotationExpr testAnno = new NormalAnnotationExpr(
							ASTHelper.createNameExpr("Test"), testAnnoParams);

					methodDec.getAnnotations().add(testAnno);
				}
			}
		}
	}

	/**
	 * Simple visitor implementation for visiting MethodDeclaration nodes.
	 *
	 * @author Peidong Hu
	 */
	private static class MethodTestAnnotationVisitor extends
			VoidVisitorAdapter<XmlTestCase> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void visit(@Nullable MethodDeclaration methodDec,
				@Nullable XmlTestCase testCase) {
			if (null == methodDec || null == testCase)
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			else {
				if (methodDec.getName().equals("runTest")) {
					List<Expression> groups = new ArrayList<Expression>();
					groups.add(new StringLiteralExpr(testCase
							.getTestCaseFilePathName()));

					List<MemberValuePair> testAnnoParams = new ArrayList<MemberValuePair>();
					testAnnoParams.add(new MemberValuePair("groups",
							new ArrayInitializerExpr(groups)));
					testAnnoParams.add(new MemberValuePair("dataProvider",
							new StringLiteralExpr("dp")));

					List<CaseDependency> caseDeps = testCase
							.getDependOnTestCases();

					if (null != caseDeps) {
						List<Expression> dependsOnGroups = new ArrayList<Expression>();
						boolean alwaysRun = true;
						for (CaseDependency cDep : caseDeps) {
							dependsOnGroups.add(new StringLiteralExpr(cDep
									.getDependOnTestCaseID()));
							if (cDep.getDependencyType() == EnumCaseDependencyType.TESTCASESTEPDEPENDENCY) {
								alwaysRun = false;
							}
						}
						testAnnoParams.add(new MemberValuePair(
								"dependsOnGroups", new ArrayInitializerExpr(
										dependsOnGroups)));
						testAnnoParams.add(new MemberValuePair("alwaysRun",
								new BooleanLiteralExpr(alwaysRun)));
					}
					NormalAnnotationExpr testAnno = new NormalAnnotationExpr(
							ASTHelper.createNameExpr("Test"), testAnnoParams);

					methodDec.getAnnotations().add(testAnno);
				}
			}
		}
	}

	private void loadClass(String classFilePathName, String className)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, MalformedURLException {
		/** Compilation Requirements *********************************************************************************************/
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				diagnostics, null, null);

		// This sets up the class path that the compiler will use.
		// I've added the .jar file that contains the DoStuff interface within
		// in it...
		List<String> optionList = new ArrayList<String>();
		optionList.add("-classpath");
		optionList.add(System.getProperty("java.class.path")
				+ ";dist/InlineCompiler.jar");

		File helloWorldJava = new File(classFilePathName);

		Iterable<? extends JavaFileObject> compilationUnit = fileManager
				.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
				diagnostics, optionList, null, compilationUnit);
		/********************************************************************************************* Compilation Requirements **/
		if (task.call()) {
			/** Load and execute *************************************************************************************************/
			System.out.println("Yipe");
			// Create a new custom class loader, pointing to the directory that
			// contains the compiled
			// classes, this should point to the top of the package structure!
			URLClassLoader classLoader = new URLClassLoader(
					new URL[] { new File(System.getProperty("user.dir")
							+ "/generated-code/caserunners/").toURI().toURL() });
			String addonClasspath = System.getProperty("user.dir")
					+ "/generated-code/caserunners/";
			ClassLoaderUtil.addFileToClassPath(addonClasspath,
					classLoader.getParent());
			// Load the class from the classloader by name....
			// URL[] urls = ((ClassLoaderUtil)
			// classLoader.getParent()).getURLs();
			//
			// for(URL url: urls){
			// System.out.println(url.getFile());
			// }
			Class<?> loadedClass = classLoader.loadClass(className);
			// Create a new instance...
			Object obj = loadedClass.newInstance();

			// // Santity check
			// if (obj instanceof IRunTestCase) {
			// ((IRunTestCase)
			// obj).setCurrentExecutingTCName("test case name example");
			// Assert.assertEquals(((IRunTestCase)
			// obj).getCurrentExecutingTCName(), "test case name example");
			// System.out.println("pass");
			// }
			/************************************************************************************************* Load and execute **/
		} else {
			for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics
					.getDiagnostics()) {
				System.out.format("Error on line %d in %s%n", diagnostic
						.getLineNumber(), diagnostic.getSource().toUri());
			}
		}
	}
}
