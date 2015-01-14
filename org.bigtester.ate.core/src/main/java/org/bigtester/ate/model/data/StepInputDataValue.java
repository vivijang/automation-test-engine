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
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class PropertyDataValue defines ....
 * 
 * @author Peidong Hu
 *
 */
public class StepInputDataValue extends BaseInputDataValue {

	/**
	 * @param elementDataDao
	 * @throws TestDataException 
	 */
	public StepInputDataValue(ElementInputDataDaoImpl elementDataDao,
			Long dataValueID) throws TestDataException {
		super(elementDataDao);
		this.dataValueID = dataValueID;
		initDataValue (dataValueID);
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Nullable
	private String value; // NOPMD

	/**
	 * Gets the data value id.
	 *
	 * @return the data value id
	 */

	private Long dataValueID; // NOPMD

	/**
	 * @return the value
	 */
	public String getValue() {
		final String value2 = value;
		if (null == value2) {
			throw new IllegalStateException(
					"Input Data value is not correctly populated.");
		} else {
			return value2;
		}
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the dataValueID
	 */
	public Long getDataValueID() {
		return dataValueID;
	}

	/**
	 * @param dataValueID
	 *            the dataValueID to set
	 * @throws TestDataException
	 */
	public void setDataValueID(Long dataValueID) {
		this.dataValueID = dataValueID;
	}

	/**
	 * Inits the data value.
	 *
	 * @param dataValueID the data value id
	 * @throws TestDataException the test data exception
	 */
	public void initDataValue(Long dataValueID) throws TestDataException {
		value = getElementDataDao().getValue(dataValueID);
	}
}
