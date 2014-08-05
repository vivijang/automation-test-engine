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
package org.bigtester.ate.resultmaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.bigtester.ate.model.casestep.BaseTestStep;
import org.bigtester.ate.model.testresult.TestStepResult;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

// TODO: Auto-generated Javadoc
/*
 * @Aspect tells the Spring framework that this class contains advice that should
 * be applied to one or more specified Pointcuts at runtime
 */
/**
 * The Class TestStepResult defines ....
 * 
 * @author Peidong Hu
 */
@Aspect
public class StepResultMaker {
	// private static final Logger logger_c =
	// Logger.getLogger(TestStepResult.class);
	/** The monitor. */
	private final static String MONITOR = "PERFORMANCE_MONITOR";

	/** The Step result list constant. */
	public static final String STEPRESULTLIST = "StepResultList";
	/** The monitor_i. */
	private Monitor monitor;

	/**
	 * Gets the monitor.
	 * 
	 * @return the monitor
	 */
	public Monitor getMonitor() {
		return monitor;
	}

	/**
	 * Sets the monitor_i.
	 * 
	 * @param monitor_i
	 *            the new monitor_i
	 */
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	/*
	 * @Before tells the Spring framework that this method should be invoked
	 * before the specified Pointcut. The Pointcut expression here is identical
	 * to the one we used in the XML configuration example
	 */
	/**
	 * Start monitor.
	 */
	@Before("@annotation(org.bigtester.ate.annotation.StepLoggable)")
	public void startMonitor() {
		monitor = MonitorFactory.start(MONITOR);
	}

	/*
	 * @After tells the Spring framework that this method should be invoked
	 * after the specified Pointcut. The Pointcut expression here is identical
	 * to the one we used in the XML configuration example
	 */
	/**
	 * Stop monitor.
	 */
	@After("@annotation(org.bigtester.ate.annotation.StepLoggable)")
	public void stopMonitor() {
		monitor.stop();
	}

	/**
	 * get last access.
	 * 
	 * @return Date
	 */
	public Date getLastAccess() {
		return monitor.getLastAccess();
	}

	/**
	 * get call count.
	 * 
	 * @return int
	 */
	public int getCallCount() {
		return (int) monitor.getHits();
	}

	/**
	 * get average call time.
	 * 
	 * @return double
	 */
	public double getAverageCallTime() {
		return monitor.getAvg() / 1000;
	}

	/**
	 * get last call time.
	 * 
	 * @return double
	 */
	public double getLastCallTime() {
		return monitor.getLastValue() / 1000;
	}

	/**
	 * get maximum call time.
	 * 
	 * @return double
	 */
	public double getMaximumCallTime() {
		return monitor.getMax() / 1000;
	}

	/**
	 * get minimum call time.
	 * 
	 * @return double
	 */
	public double getMinimumCallTime() {
		return monitor.getMin() / 1000;
	}

	/**
	 * get total call time.
	 * 
	 * @return double
	 */
	public double getTotalCallTime() {
		return monitor.getTotal() / 1000;
	}

	/**
	 * Log.
	 * 
	 * @param joinPoint_p
	 *            the join point_p
	 */

	@SuppressWarnings("unchecked")
	@After("@annotation(org.bigtester.ate.annotation.StepLoggable)")
	public void log(final JoinPoint joinPoint_p) {
		TestStepResult tsr = new TestStepResult();
		tsr.setThisStep((BaseTestStep) joinPoint_p.getTarget());
		tsr.setStepName(((BaseTestStep) joinPoint_p.getTarget()).getStepName());

		ITestResult testResult = Reporter.getCurrentTestResult();
		List<TestStepResult> stepResultList;
		try {
			if (testResult.getAttribute(TestStepResult.STEPRESULTLIST) instanceof List<?>) {
				stepResultList = (List<TestStepResult>) testResult //NOPMD
						.getAttribute(TestStepResult.STEPRESULTLIST);
			} else {
				stepResultList = new ArrayList<TestStepResult>();//NOPMD
			}
		} catch (final ClassCastException e) {
			//TODO add warning message to result
			System.out.println("class cast exception");
			stepResultList = new ArrayList<TestStepResult>();
		}

		stepResultList.add(tsr);
		testResult.setAttribute(TestStepResult.STEPRESULTLIST, stepResultList);
	}

}