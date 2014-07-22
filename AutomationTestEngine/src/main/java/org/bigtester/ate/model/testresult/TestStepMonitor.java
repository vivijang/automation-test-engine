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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.apache.log4j.Logger;
import org.bigtester.ate.model.casestep.BaseTestStep;
import org.bigtester.ate.model.casestep.ITestStep;
import org.bigtester.ate.model.casestep.TestStep;
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
public class TestStepMonitor
{
	//private static final Logger logger_c = Logger.getLogger(TestStepResult.class);
	/** The monitor. */
	private final String MONITOR = "PERFORMANCE_MONITOR";
	public static final String STEPRESULTLIST = "StepResultList";
	/** The monitor_i. */
	private Monitor monitor_i;
	
	/*
	 * @Before tells the Spring framework that this method should be invoked before the specified Pointcut.
	 * The Pointcut expression here is identical to the one we used in the XML configuration example
	 */
	/**
	 * Start monitor.
	 */
	@Before("@annotation(org.bigtester.ate.annotation.StepLoggable)")
	public void startMonitor()
	{
		monitor_i = MonitorFactory.start(MONITOR);
	}

	/*
	 * @After tells the Spring framework that this method should be invoked after the specified Pointcut.
	 * The Pointcut expression here is identical to the one we used in the XML configuration example
	 */
	/**
	 * Stop monitor.
	 */
	@After("@annotation(org.bigtester.ate.annotation.StepLoggable)")
	public void stopMonitor()
	{
		monitor_i.stop();
	}

	/**
	 * get last access.
	 *
	 * @return Date
	 */
	public Date getLastAccess()
	{
		return monitor_i.getLastAccess();
	}

	/**
	 * get call count.
	 *
	 * @return int
	 */
	public int getCallCount()
	{
		return (int) monitor_i.getHits();
	}

	/**
	 * get average call time.
	 *
	 * @return double
	 */
	public double getAverageCallTime()
	{
		return monitor_i.getAvg() / 1000;
	}

	/**
	 * get last call time.
	 *
	 * @return double
	 */
	public double getLastCallTime()
	{
		return monitor_i.getLastValue() / 1000;
	}

	/**
	 * get maximum call time.
	 *
	 * @return double
	 */
	public double getMaximumCallTime()
	{
		return monitor_i.getMax() / 1000;
	}

	/**
	 * get minimum call time.
	 *
	 * @return double
	 */
	public double getMinimumCallTime()
	{
		return monitor_i.getMin() / 1000;
	}

	/**
	 * get total call time.
	 *
	 * @return double
	 */
	public double getTotalCallTime()
	{
		return monitor_i.getTotal() / 1000;
	}

	
	/**
	 * Log.
	 *
	 * @param joinPoint_p the join point_p
	 */
	@After("@annotation(org.bigtester.ate.annotation.StepLoggable)")
	public void log(final JoinPoint joinPoint_p)
	{
		TestStepResult tsr = new TestStepResult();
		tsr.setThisStep((BaseTestStep) joinPoint_p.getTarget());
		tsr.setStepName(((BaseTestStep) joinPoint_p.getTarget()).getStepName());
		
		ITestResult testResult = Reporter.getCurrentTestResult();
		//TODO checked cast or create a new class
		List<TestStepResult> stepResultList = (List<TestStepResult>) testResult.getAttribute(TestStepResult.STEPRESULTLIST);
		if (stepResultList == null) {
			stepResultList = new ArrayList<TestStepResult>();
			
		}
		stepResultList.add(tsr);
		testResult.setAttribute(TestStepResult.STEPRESULTLIST, stepResultList);
	}
	
}