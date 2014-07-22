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

public class TestStepResult
{
	/** The monitor. */
	private final String MONITOR = "PERFORMANCE_MONITOR";
	public static final String STEPRESULTLIST = "StepResultList";
	/** The monitor_i. */
	private Monitor monitor_i;
	
	private String stepName;
	
	/** The this step. */
	private BaseTestStep thisStep;

	
	/**
	 * Start monitor.
	 */
	
	public void startMonitor()
	{
		monitor_i = MonitorFactory.start(MONITOR);
	}

	
	/**
	 * Stop monitor.
	 */
	
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
	 * Gets the this step.
	 *
	 * @return the thisStep
	 */
	public BaseTestStep getThisStep() {
		return thisStep;
	}

	/**
	 * Sets the this step.
	 *
	 * @param thisStep the thisStep to set
	 */
	public void setThisStep(BaseTestStep thisStep) {
		this.thisStep = thisStep;
	}

	/**
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * @param stepName the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
}