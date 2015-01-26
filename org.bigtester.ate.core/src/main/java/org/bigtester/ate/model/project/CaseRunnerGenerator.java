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
package org.bigtester.ate.model.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.bigtester.ate.GlobalUtils;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MemberValuePair;
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
	final private long numberOfTestCases;

	/** The case runner java file path names. */
	transient private List<String> caseRunnerJavaFileNames = new ArrayList<String>();

	/** The package name. */
	@Nullable
	private String packageName;

	/** The case runner template. */
	public final static String caseRunnerClassPathFileName = "CaseRunner";// NOPMD

	/** The case runner cache folder. */
	final private String caseRunnerCacheAbsoluteFolder;

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
	 */
	public CaseRunnerGenerator(long numberOfTestCases) {
		this.numberOfTestCases = numberOfTestCases;
		this.caseRunnerCacheAbsoluteFolder = System.getProperty("user.dir") + "/generated-code/caserunners/org/bigtester/ate/model/project/";
		
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
		File cacheDir = new File(caseRunnerCacheAbsoluteFolder);
		if (cacheDir.mkdirs() || cacheDir.exists()) {
			for (long i = 0; i < this.numberOfTestCases; i++) {
				Resource fTemp = new ClassPathResource(caseRunnerClassPathFileName);
				CompilationUnit caseRunnerCU;
				caseRunnerCU = JavaParser.parse(fTemp.getInputStream());
				this.packageName = caseRunnerCU.getPackage().toStringWithoutComments();
				try {
					File newCaseRunner = File.createTempFile("CaseRunner",
							".java", cacheDir);
					this.caseRunnerJavaFileNames.add(newCaseRunner.getName());

					new ClassNameVisitor().visit(caseRunnerCU, FilenameUtils
							.removeExtension(newCaseRunner.getName()));

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
	public void changeTestAnnotationGroups(
			String caseRunnerRelativeFilePathName, List<String> groups,
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

		groups.add(0, testMethodName);
		new MethodGroupAnnotationVisitor().visit(caseRunnerCU, groups);
		String newClass = caseRunnerCU.toString();
		fTemp.close();
		// prints the changed compilation unit
		FileWriter out = new FileWriter(caseRunnerRelativeFilePathName, false);
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
	public List<String> getCaseRunnerJavaFilePathNames() {
		return caseRunnerJavaFileNames;
	}

	/**
	 * @param caseRunnerJavaFilePathNames
	 *            the caseRunnerJavaFilePathNames to set
	 */
	public void setCaseRunnerJavaFilePathNames(
			List<String> caseRunnerJavaFilePathNames) {
		this.caseRunnerJavaFileNames = caseRunnerJavaFilePathNames;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {

		final String packageName2 = packageName;
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
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
				@Nullable List<String> methodNamePlusGroupNames) {
			if (null == methodDec || null == methodNamePlusGroupNames)
				throw GlobalUtils
						.createNotInitializedException("classorinterfacedeclaration");
			else {
				if (methodDec.getName().equals(methodNamePlusGroupNames.get(0))) {
					List<Expression> groups = new ArrayList<Expression>();
					for (int i = 1; i < methodNamePlusGroupNames.size(); i++) {
						groups.add(new StringLiteralExpr(
								methodNamePlusGroupNames.get(i)));
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
}
