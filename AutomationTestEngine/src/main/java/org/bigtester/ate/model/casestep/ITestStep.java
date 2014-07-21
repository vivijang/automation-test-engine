/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2014, Montreal PROT, or individual contributors as
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
package org.bigtester.ate.model.casestep; //NOPMD

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.testng.IClass;
import org.testng.IRetryAnalyzer;
import org.testng.ITestClass;
import org.testng.internal.ConstructorOrMethod;
import org.testng.xml.XmlTest;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITestStep defines ....
 * 
 * @author Peidong Hu
 */
public interface ITestStep extends Comparable<ITestStep>, Serializable {

	/**
	 * Gets the real class.
	 * 
	 * @return The real class on which this method was declared (can be
	 *         different from getMethod().getDeclaringClass() if the test method
	 *         was defined in a superclass).
	 */
	Class getRealClass();

	/**
	 * Gets the test class.
	 * 
	 * @return the test class
	 */
	ITestClass getTestClass();

	/**
	 * Sets the test class having this method. This is not necessarily the
	 * declaring class.
	 * 
	 * @param cls
	 *            The test class having this method.
	 */
	void setTestClass(ITestClass cls);

	/**
	 * Returns the method name. This is needed for serialization because methods
	 * are not Serializable.
	 * 
	 * @return the method name.
	 */
	String getMethodName();

	/**
	 * Gets the single instance of ITestStep.
	 * 
	 * @return single instance of ITestStep
	 */
	Object getInstance();

	/**
	 * Needed for serialization.
	 * 
	 * @return the instance hash codes
	 */
	long[] getInstanceHashCodes();

	/**
	 * Gets the groups.
	 * 
	 * @return The groups this method belongs to, possibly added to the groups
	 *         declared on the class.
	 */
	String[] getGroups();

	/**
	 * Gets the groups depended upon.
	 * 
	 * @return The groups this method depends on, possibly added to the groups
	 *         declared on the class.
	 */
	String[] getGroupsDependedUpon();

	/**
	 * If a group was not found.
	 * 
	 * @return the missing group
	 */
	String getMissingGroup();

	/**
	 * Sets the missing group.
	 * 
	 * @param group
	 *            the new missing group
	 */
	void setMissingGroup(String group);

	/**
	 * Before and After groups.
	 * 
	 * @return the before groups
	 */
	String[] getBeforeGroups();

	/**
	 * Gets the after groups.
	 * 
	 * @return the after groups
	 */
	String[] getAfterGroups();

	/**
	 * Gets the methods depended upon.
	 * 
	 * @return The methods this method depends on, possibly added to the methods
	 *         declared on the class.
	 */
	String[] getMethodsDependedUpon();

	/**
	 * Adds the method depended upon.
	 * 
	 * @param methodName
	 *            the method name
	 */
	void addMethodDependedUpon(String methodName);

	/**
	 * Checks if is test.
	 * 
	 * @return true if this method was annotated with @Test
	 */
	boolean isTest();

	/**
	 * Checks if is before method configuration.
	 * 
	 * @return true if this method was annotated with @Configuration and
	 *         beforeTestMethod = true
	 */
	boolean isBeforeMethodConfiguration();

	/**
	 * Checks if is after method configuration.
	 * 
	 * @return true if this method was annotated with @Configuration and
	 *         beforeTestMethod = false
	 */
	boolean isAfterMethodConfiguration();

	/**
	 * Checks if is before class configuration.
	 * 
	 * @return true if this method was annotated with @Configuration and
	 *         beforeClassMethod = true
	 */
	boolean isBeforeClassConfiguration();

	/**
	 * Checks if is after class configuration.
	 * 
	 * @return true if this method was annotated with @Configuration and
	 *         beforeClassMethod = false
	 */
	boolean isAfterClassConfiguration();

	/**
	 * Checks if is before suite configuration.
	 * 
	 * @return true if this method was annotated with @Configuration and
	 *         beforeSuite = true
	 */
	boolean isBeforeSuiteConfiguration();

	/**
	 * Checks if is after suite configuration.
	 * 
	 * @return true if this method was annotated with @Configuration and
	 *         afterSuite = true
	 */
	boolean isAfterSuiteConfiguration();

	/**
	 * Checks if is before test configuration.
	 * 
	 * @return <tt>true</tt> if this method is a @BeforeTest (@Configuration
	 *         beforeTest=true)
	 */
	boolean isBeforeTestConfiguration();

	/**
	 * Checks if is after test configuration.
	 * 
	 * @return <tt>true</tt> if this method is an @AfterTest (@Configuration
	 *         afterTest=true)
	 */
	boolean isAfterTestConfiguration();

	/**
	 * Checks if is before groups configuration.
	 * 
	 * @return true, if is before groups configuration
	 */
	boolean isBeforeGroupsConfiguration();

	/**
	 * Checks if is after groups configuration.
	 * 
	 * @return true, if is after groups configuration
	 */
	boolean isAfterGroupsConfiguration();

	/**
	 * Gets the time out.
	 * 
	 * @return The timeout in milliseconds.
	 */
	long getTimeOut();

	/**
	 * Sets the time out.
	 * 
	 * @param timeOut
	 *            the new time out
	 */
	void setTimeOut(long timeOut);

	/**
	 * Gets the invocation count.
	 * 
	 * @return the number of times this method needs to be invoked.
	 */
	int getInvocationCount();

	/**
	 * Sets the invocation count.
	 * 
	 * @param count
	 *            the new invocation count
	 */
	void setInvocationCount(int count);

	/**
	 * Gets the success percentage.
	 * 
	 * @return the success percentage for this method (between 0 and 100).
	 */
	int getSuccessPercentage();

	/**
	 * Gets the id.
	 * 
	 * @return The id of the thread this method was run in.
	 */
	String getId();

	/**
	 * Sets the id.
	 * 
	 * @param setid
	 *            the new id
	 */
	void setId(String setid);

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	long getDate();

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	void setDate(long date);

	/**
	 * Returns if this ITestNGMethod can be invoked from within IClass.
	 * 
	 * @param testClass
	 *            the test class
	 * @return true, if successful
	 */
	boolean canRunFromClass(IClass testClass);

	/**
	 * Checks if is always run.
	 * 
	 * @return true if this method is alwaysRun=true
	 */
	boolean isAlwaysRun();

	/**
	 * Gets the thread pool size.
	 * 
	 * @return the number of threads to be used when invoking the method on
	 *         parallel
	 */
	int getThreadPoolSize();

	/**
	 * Sets the thread pool size.
	 * 
	 * @param threadPoolSize
	 *            the new thread pool size
	 */
	void setThreadPoolSize(int threadPoolSize);

	/**
	 * Gets the enabled.
	 * 
	 * @return the enabled
	 */
	boolean isEnabled();

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	String getDescription();

	/**
	 * Increment current invocation count.
	 */
	void incrementCurrentInvocationCount();

	/**
	 * Gets the current invocation count.
	 * 
	 * @return the current invocation count
	 */
	int getCurrentInvocationCount();

	/**
	 * Sets the parameter invocation count.
	 * 
	 * @param nCount
	 *            the new parameter invocation count
	 */
	void setParameterInvocationCount(int nCount);

	/**
	 * Gets the parameter invocation count.
	 * 
	 * @return the parameter invocation count
	 */
	int getParameterInvocationCount();

	/**
	 * Gets the retry analyzer.
	 * 
	 * @return the retry analyzer
	 */
	IRetryAnalyzer getRetryAnalyzer();

	/**
	 * Sets the retry analyzer.
	 * 
	 * @param retryAnalyzer
	 *            the new retry analyzer
	 */
	void setRetryAnalyzer(IRetryAnalyzer retryAnalyzer);

	/**
	 * Skip failed invocations.
	 * 
	 * @return true, if successful
	 */
	boolean skipFailedInvocations();

	/**
	 * Sets the skip failed invocations.
	 * 
	 * @param skip
	 *            the new skip failed invocations
	 */
	void setSkipFailedInvocations(boolean skip);

	/**
	 * The time under which all invocationCount methods need to complete by.
	 * 
	 * @return the invocation time out
	 */
	long getInvocationTimeOut();

	/**
	 * Ignore missing dependencies.
	 * 
	 * @return true, if successful
	 */
	boolean ignoreMissingDependencies();

	/**
	 * Sets the ignore missing dependencies.
	 * 
	 * @param ignore
	 *            the new ignore missing dependencies
	 */
	void setIgnoreMissingDependencies(boolean ignore);

	/**
	 * Which invocation numbers of this method should be used (only applicable
	 * if it uses a data provider). If this value is an empty list, use all the
	 * values returned from the data provider. These values are read from the
	 * XML file in the <include invocationNumbers="..."> tag.
	 * 
	 * @return the invocation numbers
	 */
	List<Integer> getInvocationNumbers();

	/**
	 * Sets the invocation numbers.
	 * 
	 * @param numbers
	 *            the new invocation numbers
	 */
	void setInvocationNumbers(List<Integer> numbers);

	/**
	 * The list of invocation numbers that failed, which is only applicable for
	 * methods that have a data provider.
	 * 
	 * @param number
	 *            the number
	 */
	void addFailedInvocationNumber(int number);

	/**
	 * Gets the failed invocation numbers.
	 * 
	 * @return the failed invocation numbers
	 */
	List<Integer> getFailedInvocationNumbers();

	/**
	 * The scheduling priority. Lower priorities get scheduled first.
	 * 
	 * @return the priority
	 */
	int getPriority();

	/**
	 * Sets the priority.
	 * 
	 * @param priority
	 *            the new priority
	 */
	void setPriority(int priority);

	/**
	 * Gets the xml test.
	 * 
	 * @return the XmlTest this method belongs to.
	 */
	XmlTest getXmlTest();

	/**
	 * Gets the constructor or method.
	 * 
	 * @return the constructor or method
	 */
	ConstructorOrMethod getConstructorOrMethod();

	/**
	 * Find method parameters.
	 * 
	 * @param test
	 *            the test
	 * @return the parameters found in the include tag, if any
	 */
	Map<String, String> findMethodParameters(XmlTest test);

	/**
	 * Do step.
	 */
	void doStep();
}
