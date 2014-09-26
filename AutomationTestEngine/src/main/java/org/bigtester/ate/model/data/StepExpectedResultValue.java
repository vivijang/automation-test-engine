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

import java.util.List;

import org.bigtester.ate.model.data.dbtable.StepExpectedResult;
import org.bigtester.ate.model.data.exception.TestDataException;

import lombok.Getter;

// TODO: Auto-generated Javadoc
/**
 * This class PropertyDataValue defines ....
 * @author Peidong Hu
 *
 */
public class StepExpectedResultValue extends AbstractERValue{
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Getter
	private List<StepExpectedResult> value; //NOPMD
	
	
	/**
	 * Gets the data value id.
	 *
	 * @return the data value id
	 */
	@Getter
	private String dataValueID; //NOPMD
	/**
	 * @param dataValueID the dataValueID to set
	 * @throws TestDataException 
	 */
	public void setDataValueID(String sERSetID) throws TestDataException {
		this.dataValueID = sERSetID;
		value = getStepERDao().getERs(sERSetID);
	}

}
