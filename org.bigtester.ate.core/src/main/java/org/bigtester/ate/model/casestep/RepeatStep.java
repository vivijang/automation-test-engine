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
package org.bigtester.ate.model.casestep;

import java.util.List;

import org.bigtester.ate.model.data.IDataParser;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class RepeatStep defines ....
 * @author Peidong Hu
 *
 */
public class RepeatStep extends AbstractTestStep implements ITestStep{

	/** The start step id. */
	private String startStepID;
	
	/** The end step id. */
	private String endStepID;

	/** The continue on failure. */
	private boolean continueOnFailure;
	
	private String 
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPageValidation() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public IPageObject getPageObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public IMyWebDriver getMyWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public MyWebElement getMyWebElement() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public List<IDataParser> getDataHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isElementStepFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doStep() throws StepExecutionException2,
			PageValidationException2, RuntimeDataException {
		// TODO Auto-generated method stub
		
	}
	
}
