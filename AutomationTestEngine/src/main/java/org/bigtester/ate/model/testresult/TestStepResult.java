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
package org.bigtester.ate.model.testresult;

import org.testng.IClass;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

// TODO: Auto-generated Javadoc
/**
 * This class TestStepResult defines ....
 * @author Peidong Hu
 *
 */
public class TestStepResult implements ITestStepResult{
	
	  private IClass testClass = null;
	  private ITestNGMethod method = null;
	  private int status = -1;
	  private Throwable throwable = null;
	  private long startMillis = 0;
	  private long endMillis = 0;
	  private String stepName = null;
	  private String host;
	  transient private Object[] parameters = {};
	  transient private Object instance;
	  private String instanceName;
	  private ITestContext context;
	  private testElement

	  public TestStepResult() {

	  }

	  public TestStepResult(IClass testClass,
	      Object instance,
	      ITestNGMethod method,
	      Throwable throwable,
	      long start,
	      long end,
	      ITestContext context)
	  {
	    init(testClass, instance, method, throwable, start, end, context);
	  }

	  /**
	   *
	   * @param testClass
	   * @param instance
	   * @param method
	   * @param throwable
	   * @param start
	   * @param end
	   */
	  public void init (IClass testClass,
	      Object instance,
	      ITestNGMethod method,
	      Throwable throwable,
	      long start,
	      long end,
	      ITestContext context)
	  {
	    m_testClass = testClass;
	    m_throwable = throwable;
	    m_instanceName = m_testClass.getName();
	    if (null == m_throwable) {
	      m_status = ITestStepResult.SUCCESS;
	    }
	    m_startMillis = start;
	    m_endMillis = end;
	    m_method = method;
	    m_context = context;

	    m_instance = instance;

	    // Calculate the name: either the method name, ITest#getTestName or
	    // toString() if it's been overridden.
	    if (m_instance == null) {
	      m_name = m_method.getMethodName();
	    } else {
	      if (m_instance instanceof ITest) {
	        m_name = ((ITest) m_instance).getTestName();
	      }
	      else {
	        String string = m_instance.toString();
	        // Only display toString() if it's been overridden by the user
	        m_name = getMethod().getMethodName();
	        try {
	          if (!Object.class.getMethod("toString")
	              .equals(m_instance.getClass().getMethod("toString"))) {
	            m_instanceName = string.startsWith("class ")
	                ? string.substring("class ".length())
	                : string;
	            m_name = m_name + " on " + m_instanceName;
	          }
	        }
	        catch(NoSuchMethodException ignore) {
	          // ignore
	        }
	      }
	    }
	  }

	  private static void ppp(String s) {
	    System.out.println("[TestResult] " + s);
	  }

	  @Override
	  public void setEndMillis(long millis) {
	    m_endMillis = millis;
	  }

	  /**
	   * If this result's related instance implements ITest, returns its test name,
	   * otherwise returns null.
	   */
	  @Override
	  public String getTestName() {
	    if (m_instance instanceof ITest) {
	      return ((ITest) m_instance).getTestName();
	    }
	    return null;
	  }

	  @Override
	  public String getName() {
	    return m_name;
	  }

	  /**
	   * @return Returns the method.
	   */
	  @Override
	  public ITestNGMethod getMethod() {
	    return m_method;
	  }

	  /**
	   * @param method The method to set.
	   */
	  public void setMethod(ITestNGMethod method) {
	    m_method = method;
	  }

	  /**
	   * @return Returns the status.
	   */
	  @Override
	  public int getStatus() {
	    return m_status;
	  }

	  /**
	   * @param status The status to set.
	   */
	  @Override
	  public void setStatus(int status) {
	    m_status = status;
	  }

	  @Override
	  public boolean isSuccess() {
	    return ITestResult.SUCCESS == m_status;
	  }

	  /**
	   * @return Returns the testClass.
	   */
	  @Override
	  public IClass getTestClass() {
	    return m_testClass;
	  }

	  /**
	   * @param testClass The testClass to set.
	   */
	  public void setTestClass(IClass testClass) {
	    m_testClass = testClass;
	  }

	  /**
	   * @return Returns the throwable.
	   */
	  @Override
	  public Throwable getThrowable() {
	    return m_throwable;
	  }

	  /**
	   * @param throwable The throwable to set.
	   */
	  @Override
	  public void setThrowable(Throwable throwable) {
	    m_throwable = throwable;
	  }

	  /**
	   * @return Returns the endMillis.
	   */
	  @Override
	  public long getEndMillis() {
	    return m_endMillis;
	  }

	  /**
	   * @return Returns the startMillis.
	   */
	  @Override
	  public long getStartMillis() {
	    return m_startMillis;
	  }

	//  public List<String> getOutput() {
//	    return m_output;
	//  }

	  @Override
	  public String toString() {
	    List<String> output = Reporter.getOutput(this);
	    String result = Objects.toStringHelper(getClass())
	        .omitNulls()
	        .omitEmptyStrings()
	        .add("name", getName())
	        .add("status", toString(m_status))
	        .add("method", m_method)
	        .add("output", output != null && output.size() > 0 ? output.get(0) : null)
	        .toString();

	    return result;
	  }

	  private String toString(int status) {
	    switch(status) {
	      case SUCCESS: return "SUCCESS";
	      case FAILURE: return "FAILURE";
	      case SKIP: return "SKIP";
	      case SUCCESS_PERCENTAGE_FAILURE: return "SUCCESS WITHIN PERCENTAGE";
	      case STARTED: return "STARTED";
	      default: throw new RuntimeException();
	    }
	  }

	  @Override
	  public String getHost() {
	    return m_host;
	  }

	  public void setHost(String host) {
	    m_host = host;
	  }

	  @Override
	  public Object[] getParameters() {
	    return m_parameters;
	  }

	  @Override
	  public void setParameters(Object[] parameters) {
	    m_parameters = parameters;
	  }

	  @Override
	  public Object getInstance() {
	    return m_instance;
	  }

	  private IAttributes m_attributes = new Attributes();

	  @Override
	  public Object getAttribute(String name) {
	    return m_attributes.getAttribute(name);
	  }

	  @Override
	  public void setAttribute(String name, Object value) {
	    m_attributes.setAttribute(name, value);
	  }

	  @Override
	  public Set<String> getAttributeNames() {
	    return m_attributes.getAttributeNames();
	  }

	  @Override
	  public Object removeAttribute(String name) {
	    return m_attributes.removeAttribute(name);
	  }
	  
	  @Override
	  public ITestContext getTestContext() {
		  return m_context;
	  }
	  
	  public void setContext(ITestContext context) {
		  m_context = context;
	  }

	  @Override
	  public int compareTo(ITestResult comparison) {
		  if( getStartMillis() > comparison.getStartMillis() ) {
			  return 1;
		  } else if( getStartMillis() < comparison.getStartMillis()) {
			  return -1;
		  } else {
			  return 0;
		  }
	  }

	  @Override
	  public String getInstanceName() {
	    return m_instanceName;
	  }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(ITestStepResult o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
