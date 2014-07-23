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

import java.util.Date;

import org.bigtester.ate.model.casestep.BaseTestStep;

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

public class TestStepResult {
	/** The monitor. */
	private transient final static String MONITOR = "PERFORMANCE_MONITOR";

	/** The Constant STEPRESULTLIST. */
	public static final String STEPRESULTLIST = "StepResultList";
	/** The monitor_i. */
	private Monitor monitor;
	/** The step name. */
	private String stepName;

	/** The this step. */
	private BaseTestStep thisStep;

	/**
	 * Gets the monitor.
	 * 
	 * @return the monitor
	 */
	public Monitor getMonitor() {
		return monitor;
	}

	/**
	 * @param monitor
	 *            the monitor to set
	 */
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * Start monitor.
	 */

	public void startMonitor() {
		monitor = MonitorFactory.start(MONITOR);
	}

	/**
	 * Stop monitor.
	 */

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
	 * @param thisStep
	 *            the thisStep to set
	 */
	public void setThisStep(BaseTestStep thisStep) {
		this.thisStep = thisStep;
	}

	/**
	 * Gets the step name.
	 * 
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * Sets the step name.
	 * 
	 * @param stepName
	 *            the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
}