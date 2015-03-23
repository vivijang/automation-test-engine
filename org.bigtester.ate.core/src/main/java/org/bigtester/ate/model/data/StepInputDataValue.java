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
package org.bigtester.ate.model.data;

import org.bigtester.ate.model.data.dao.ElementInputDataDaoImpl;

import org.bigtester.ate.model.data.exception.TestDataException;

// TODO: Auto-generated Javadoc
/**
 * This class StepInputDataValue retrieve inputdata from db.
 * 
 * @author Peidong Hu
 *
 */
public class StepInputDataValue extends BaseInputDataValue implements IStepInputData{

	/** The element data dao. */
	private ElementInputDataDaoImpl elementDataDao;//NOPMD
	/**
	 * @param elementDataDao
	 * @throws TestDataException 
	 */
	public StepInputDataValue(ElementInputDataDaoImpl elementDataDao,
			String dataValueID) throws TestDataException {
		super("");
		this.elementDataDao = elementDataDao;
		this.dataValueID = dataValueID;
		initDataValue (dataValueID);
	}

	/**
	 * Gets the data value id.
	 *
	 * @return the data value id
	 */

	private String dataValueID; // NOPMD

	
	/**
	 * Gets the element data dao.
	 *
	 * @return the elementDataDao
	 */
	public ElementInputDataDaoImpl getElementDataDao() {
		return elementDataDao;
	}

	/**
	 * Sets the element data dao.
	 *
	 * @param elementDataDao the elementDataDao to set
	 */
	public void setElementDataDao(final ElementInputDataDaoImpl elementDataDao) {
		this.elementDataDao = elementDataDao;
	}
	/**
	 * Inits the data value.
	 *
	 * @param dataValueID the data value id
	 * @throws TestDataException the test data exception
	 */
	public void initDataValue(String dataValueID) throws TestDataException {
		setStrDataValue(getElementDataDao().getValue(dataValueID));
	}

	/**
	 * @return the dataValueID
	 */
	public String getDataValueID() {
		return dataValueID;
	}

	/**
	 * @param dataValueID the dataValueID to set
	 */
	public void setDataValueID(String dataValueID) {
		this.dataValueID = dataValueID;
	}
}
