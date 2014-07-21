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
package org.bigtester.ate.model.casestep;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.testng.IClass;
import org.testng.IRetryAnalyzer;
import org.testng.ITestClass;
import org.testng.ITestNGMethod;
import org.testng.annotations.ITestOrConfiguration;
import org.testng.collections.Lists;
import org.testng.collections.Maps;
import org.testng.collections.Sets;
import org.testng.internal.ConstructorOrMethod;
import org.testng.internal.annotations.IAnnotationFinder;
import org.testng.internal.thread.IAtomicInteger;
import org.testng.internal.thread.ThreadUtil;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlTest;

// TODO: Auto-generated Javadoc
/**
 * This class AbstractBaseTestStep defines ....
 * 
 * @author Peidong Hu
 * 
 */
public abstract class AbstractBaseTestStep implements ITestStep {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8825803511734774448L;

	/** The Constant SPACE_SEPARATOR_PATTERN. */
	private static final Pattern SPACE_SEPARATOR_PATTERN = Pattern
			.compile(" +");

	/**
	 * The test class on which the test method was found. Note that this is not
	 * necessarily the declaring class.
	 */
	protected ITestClass testClass;

	/** The method class. */
	protected final transient Class<?> methodClass;
	
	/** The method. */
	protected final transient ConstructorOrMethod method;
	
	/** The signature. */
	private final transient String signature;
	
	/** The step id. */
	protected String stepID = "";
	
	/** The date. */
	protected long date = -1;
	
	/** The annotation finder. */
	protected final transient IAnnotationFinder annotationFinder;
	
	/** The groups. */
	protected String[] groups = {};
	
	/** The groups depended upon. */
	protected String[] groupsDependedUpon = {};
	
	/** The methods depended upon. */
	protected String[] methodsDependedUpon = {};
	
	/** The before groups. */
	protected String[] beforeGroups = {};
	
	/** The after groups. */
	protected String[] afterGroups = {};
	
	/** The is always run. */
	private boolean isAlwaysRun;
	
	/** The enabled. */
	private boolean enabled;

	/** The method name. */
	private final String methodName;
	// If a depended group is not found
	/** The missing group. */
	private String missingGroup;
	
	/** The description. */
	private String description = null;
	
	/** The current invocation count. */
	protected IAtomicInteger currentInvocationCount = ThreadUtil
			.createAtomicInteger(0);
	
	/** The parameter invocation count. */
	private int parameterInvocationCount = 1;
	
	/** The retry analyzer. */
	private IRetryAnalyzer retryAnalyzer = null;
	
	/** The skip failed invocations. */
	private boolean skipFailedInvocations = true;
	
	/** The invocation time out. */
	private long invocationTimeOut = 0L;

	/** The invocation numbers. */
	private List<Integer> invocationNumbers = Lists.newArrayList();
	
	/** The failed invocation numbers. */
	private List<Integer> failedInvocationNumbers = Lists.newArrayList();
	
	/** {@inheritDoc}. */
	private long timeOut = 0;

	/** The ignore missing dependencies. */
	private boolean ignoreMissingDependencies;
	
	/** The priority. */
	private int priority;

	/** The xml test. */
	private XmlTest xmlTest;
	
	/** The instance. */
	private Object instance;

	/**
	 * Constructs a <code>AbstractBaseTestStep</code> TODO cquezel JavaDoc.
	 *
	 * @param method the method
	 * @param annotationFinder the annotation finder
	 * @param instance the instance
	 */
	public AbstractBaseTestStep(Method method,
			IAnnotationFinder annotationFinder, Object instance) {
		this(new ConstructorOrMethod(method), annotationFinder, instance);
	}

	/**
	 * Instantiates a new abstract base test step.
	 *
	 * @param com the com
	 * @param annotationFinder the annotation finder
	 * @param instance the instance
	 */
	public AbstractBaseTestStep(ConstructorOrMethod com,
			IAnnotationFinder annotationFinder, Object instance) {
		methodClass = com.getDeclaringClass();
		method = com;
		methodName = com.getName();
		this.annotationFinder = annotationFinder;
		this.instance = instance;
		signature = computeSignature();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<?> getRealClass() {
		return methodClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITestClass getTestClass() {
		return testClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTestClass(ITestClass tc) {
		assert null != tc;
		if (!tc.getRealClass().equals(method.getDeclaringClass())) {
			assert method.getDeclaringClass().isAssignableFrom(
					tc.getRealClass()) : "\nMISMATCH : " + tc.getRealClass()
					+ " " + method.getDeclaringClass();
		}
		testClass = tc;
	}

	/**
	 * TODO cquezel JavaDoc.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(ITestStep o) {
		int result = -2;
		Class<?> thisClass = getRealClass();
		Class<?> otherClass = ((ITestNGMethod) o).getRealClass();
		if (this == o) {
			result = 0;
		} else if (thisClass.isAssignableFrom(otherClass)) {
			result = -1;
		} else if (otherClass.isAssignableFrom(thisClass)) {
			result = 1;
		} else if (equals(o)) {
			result = 0;
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMethodName() {
		return methodName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getInstance() {
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long[] getInstanceHashCodes() {
		return testClass.getInstanceHashCodes();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the addition of groups defined on the class and on this method.
	 */
	@Override
	public String[] getGroups() {
		return groups;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getGroupsDependedUpon() {
		return groupsDependedUpon;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getMethodsDependedUpon() {
		return methodsDependedUpon;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTest() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBeforeSuiteConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAfterSuiteConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBeforeTestConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAfterTestConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBeforeGroupsConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAfterGroupsConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBeforeClassConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAfterClassConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBeforeMethodConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAfterMethodConfiguration() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getTimeOut() {
		long result = timeOut != 0 ? timeOut : (xmlTest != null ? xmlTest
				.getTimeOut(0) : 0);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTimeOut(long timeOut) {
		timeOut = timeOut;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the number of times this method needs to be invoked.
	 */
	@Override
	public int getInvocationCount() {
		return 1;
	}

	/**
	 * No-op.
	 *
	 * @param counter the new invocation count
	 */
	@Override
	public void setInvocationCount(int counter) {
	}

	/**
	 * {@inheritDoc} Default value for successPercentage.
	 */
	@Override
	public int getSuccessPercentage() {
		return 100;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return stepID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		stepID = id;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return Returns the date.
	 */
	@Override
	public long getDate() {
		return date;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param date
	 *            The date to set.
	 */
	@Override
	public void setDate(long date) {
		date = date;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canRunFromClass(IClass testClass) {
		return methodClass.isAssignableFrom(testClass.getRealClass());
	}

	/**
	 * {@inheritDoc} Compares two AbstractBaseTestStep using the test class then
	 * the associated Java Method.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		AbstractBaseTestStep other = (AbstractBaseTestStep) obj;

		boolean isEqual = testClass == null ? other.testClass == null
				: other.testClass != null
						&& testClass.getRealClass().equals(
								other.testClass.getRealClass())
						&& instance == other.getInstance();

		return isEqual
				&& getConstructorOrMethod().equals(
						other.getConstructorOrMethod());
	}

	/**
	 * {@inheritDoc} This implementation returns the associated Java Method's
	 * hash code.
	 * 
	 * @Return the associated Java Method's hash code.
	 */
	@Override
	public int hashCode() {
		return method.hashCode();
	}

	/**
	 * Inits the groups.
	 *
	 * @param annotationClass the annotation class
	 */
	protected void initGroups(
			Class<? extends ITestOrConfiguration> annotationClass) {
		//
		// Init groups
		//
		{
			ITestOrConfiguration annotation = getAnnotationFinder()
					.findAnnotation(getConstructorOrMethod().getMethod(),
							annotationClass);
			ITestOrConfiguration classAnnotation = getAnnotationFinder()
					.findAnnotation(
							getConstructorOrMethod().getDeclaringClass(),
							annotationClass);

			setGroups(getStringArray(
					null != annotation ? annotation.getGroups() : null,
					null != classAnnotation ? classAnnotation.getGroups()
							: null));
		}

		//
		// Init groups depended upon
		//
		{
			ITestOrConfiguration annotation = getAnnotationFinder()
					.findAnnotation(getConstructorOrMethod().getMethod(),
							annotationClass);
			ITestOrConfiguration classAnnotation = getAnnotationFinder()
					.findAnnotation(
							getConstructorOrMethod().getMethod()
									.getDeclaringClass(), annotationClass);

			Map<String, Set<String>> xgd = calculateXmlGroupDependencies(xmlTest);
			List<String> xmlGroupDependencies = Lists.newArrayList();
			for (String g : getGroups()) {
				Set<String> gdu = xgd.get(g);
				if (gdu != null) {
					xmlGroupDependencies.addAll(gdu);
				}
			}
			setGroupsDependedUpon(
					getStringArray(
							null != annotation ? annotation.getDependsOnGroups()
									: null,
							null != classAnnotation ? classAnnotation
									.getDependsOnGroups() : null),
					xmlGroupDependencies);

			String[] methodsDependedUpon = getStringArray(
					null != annotation ? annotation.getDependsOnMethods()
							: null,
					null != classAnnotation ? classAnnotation
							.getDependsOnMethods() : null);
			// Qualify these methods if they don't have a package
			for (int i = 0; i < methodsDependedUpon.length; i++) {
				String m = methodsDependedUpon[i];
				if (m.indexOf(".") < 0) {
					m = StepMethodHelper.calculateMethodCanonicalName(
							methodClass, methodsDependedUpon[i]);
					methodsDependedUpon[i] = m != null ? m
							: methodsDependedUpon[i];
				}
			}
			setMethodsDependedUpon(methodsDependedUpon);
		}
	}

	/**
	 * Calculate xml group dependencies.
	 *
	 * @param xmlTest the xml test
	 * @return the map
	 */
	private static Map<String, Set<String>> calculateXmlGroupDependencies(
			XmlTest xmlTest) {
		Map<String, Set<String>> result = Maps.newHashMap();
		if (xmlTest == null) {
			return result;
		}

		for (Map.Entry<String, String> e : xmlTest.getXmlDependencyGroups()
				.entrySet()) {
			String name = e.getKey();
			String dependsOn = e.getValue();
			Set<String> set = result.get(name);
			if (set == null) {
				set = Sets.newHashSet();
				result.put(name, set);
			}
			set.addAll(Arrays.asList(SPACE_SEPARATOR_PATTERN.split(dependsOn)));
		}

		return result;
	}

	/**
	 * Gets the annotation finder.
	 *
	 * @return the annotation finder
	 */
	protected IAnnotationFinder getAnnotationFinder() {
		return annotationFinder;
	}

	/**
	 * Gets the i class.
	 *
	 * @return the i class
	 */
	protected IClass getIClass() {
		return testClass;
	}

	/**
	 * Compute signature.
	 *
	 * @return the string
	 */
	private String computeSignature() {
		String classLong = method.getDeclaringClass().getName();
		String cls = classLong.substring(classLong.lastIndexOf(".") + 1);
		StringBuilder result = new StringBuilder(cls).append(".")
				.append(method.getName()).append("(");
		int i = 0;
		for (Class<?> p : method.getParameterTypes()) {
			if (i++ > 0) {
				result.append(", ");
			}
			result.append(p.getName());
		}
		result.append(")");
		result.append("[pri:").append(getPriority()).append(", instance:")
				.append(instance).append("]");

		return result.toString();
	}

	/**
	 * TODO cquezel JavaDoc.
	 *
	 * @return the signature
	 */
	protected String getSignature() {
		return signature;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return getSignature();
	}

	/**
	 * TODO cquezel JavaDoc.
	 *
	 * @param methodArray the method array
	 * @param classArray the class array
	 * @return the string array
	 */
	protected String[] getStringArray(String[] methodArray, String[] classArray) {
		final Set<String> vResult = Sets.newHashSet();
		if (null != methodArray) {
			Collections.addAll(vResult, methodArray);
		}
		if (null != classArray) {
			Collections.addAll(vResult, classArray);
		}
		return vResult.toArray(new String[vResult.size()]);
	}

	/**
	 * Sets the groups.
	 *
	 * @param groups the new groups
	 */
	protected void setGroups(String[] groups) {
		groups = groups;
	}

	/**
	 * Sets the groups depended upon.
	 *
	 * @param groups the groups
	 * @param xmlGroupDependencies the xml group dependencies
	 */
	protected void setGroupsDependedUpon(String[] groups,
			Collection<String> xmlGroupDependencies) {
		List<String> l = Lists.newArrayList();
		l.addAll(Arrays.asList(groups));
		l.addAll(xmlGroupDependencies);
		groupsDependedUpon = l.toArray(new String[l.size()]);
	}

	/**
	 * Sets the methods depended upon.
	 *
	 * @param methods the new methods depended upon
	 */
	protected void setMethodsDependedUpon(String[] methods) {
		methodsDependedUpon = methods;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addMethodDependedUpon(String method) {
		String[] newMethods = new String[methodsDependedUpon.length + 1];
		newMethods[0] = method;
		System.arraycopy(methodsDependedUpon, 0, newMethods, 1,
				methodsDependedUpon.length);
		methodsDependedUpon = newMethods;
	}

	/**
	 * Ppp.
	 *
	 * @param s the s
	 */
	private static void ppp(String s) {
		System.out.println("[AbstractBaseTestStep] " + s);
	}

	/** Compares two ITestNGMethod by date. */
	public static final Comparator<?> DATE_COMPARATOR = new Comparator<Object>() {
		@Override
		public int compare(Object o1, Object o2) {
			try {
				ITestNGMethod m1 = (ITestNGMethod) o1;
				ITestNGMethod m2 = (ITestNGMethod) o2;
				return (int) (m1.getDate() - m2.getDate());
			} catch (Exception ex) {
				return 0; // TODO CQ document this logic
			}
		}
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMissingGroup() {
		return missingGroup;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMissingGroup(String group) {
		missingGroup = group;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getThreadPoolSize() {
		return 0;
	}

	/**
	 * No-op.
	 *
	 * @param threadPoolSize the new thread pool size
	 */
	@Override
	public void setThreadPoolSize(int threadPoolSize) {
	}

	/**
	 * TODO cquezel JavaDoc.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		description = description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		enabled = enabled;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getBeforeGroups() {
		return beforeGroups;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getAfterGroups() {
		return afterGroups;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void incrementCurrentInvocationCount() {
		currentInvocationCount.incrementAndGet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCurrentInvocationCount() {
		return currentInvocationCount.get();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setParameterInvocationCount(int n) {
		parameterInvocationCount = n;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getParameterInvocationCount() {
		return parameterInvocationCount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ITestNGMethod clone();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRetryAnalyzer getRetryAnalyzer() {
		return retryAnalyzer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRetryAnalyzer(IRetryAnalyzer retryAnalyzer) {
		this.retryAnalyzer = retryAnalyzer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean skipFailedInvocations() {
		return skipFailedInvocations;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSkipFailedInvocations(boolean s) {
		skipFailedInvocations = s;
	}

	/**
	 * Sets the invocation time out.
	 *
	 * @param timeOut the new invocation time out
	 */
	public void setInvocationTimeOut(long timeOut) {
		invocationTimeOut = timeOut;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getInvocationTimeOut() {
		return invocationTimeOut;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean ignoreMissingDependencies() {
		return ignoreMissingDependencies;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIgnoreMissingDependencies(boolean i) {
		ignoreMissingDependencies = i;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> getInvocationNumbers() {
		return invocationNumbers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInvocationNumbers(List<Integer> numbers) {
		invocationNumbers = numbers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> getFailedInvocationNumbers() {
		return failedInvocationNumbers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addFailedInvocationNumber(int number) {
		failedInvocationNumbers.add(number);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public XmlTest getXmlTest() {
		return xmlTest;
	}

	/**
	 * Sets the xml test.
	 *
	 * @param xmlTest the new xml test
	 */
	public void setXmlTest(XmlTest xmlTest) {
		this.xmlTest = xmlTest;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConstructorOrMethod getConstructorOrMethod() {
		return method;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> findMethodParameters(XmlTest test) {
		// Get the test+suite parameters
		Map<String, String> result = test.getAllParameters();
		for (XmlClass xmlClass : test.getXmlClasses()) {
			if (xmlClass.getName().equals(getTestClass().getName())) {
				result.putAll(xmlClass.getLocalParameters());
				for (XmlInclude include : xmlClass.getIncludedMethods()) {
					if (include.getName().equals(getMethodName())) {
						result.putAll(include.getLocalParameters());
						break;
					}
				}
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doStep() {
		// TODO Auto-generated method stub

	}

}
