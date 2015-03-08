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

import java.util.ArrayList;
import java.util.List;

import org.bigtester.ate.model.data.dao.StepExpectedResultDaoImpl;
import org.bigtester.ate.model.data.dbtable.StepErElementExistence;
import org.bigtester.ate.model.data.exception.TestDataException;

// TODO: Auto-generated Javadoc
/**
 * This class PropertyDataValue defines ....
 * this class is desperate
 * @author Peidong Hu
 *
 */
public class StepErElementExistenceValue extends BaseERValue{
	
	/**
	 * @param stepERDao
	 * @throws TestDataException 
	 */
	public StepErElementExistenceValue(StepExpectedResultDaoImpl stepERDao, String erSetId) throws TestDataException {
		super(stepERDao);
		this.dataValueID = erSetId;
		this.value = getStepERDao().getErElementExistences(erSetId);
	}
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	
	private List<StepErElementExistence> value = new ArrayList<StepErElementExistence>(); //NOPMD
	
	
	/**
	 * Gets the data value id.
	 *
	 * @return the data value id
	 */
	
	private String dataValueID; //NOPMD
	/**
	 * @return the value
	 */
	public List<StepErElementExistence> getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(List<StepErElementExistence> value) {
		this.value = value;
	}
	/**
	 * @return the dataValueID
	 */
	public String getDataValueID() {
		return dataValueID;
	}
	/**
	 * @param dataValueID the dataValueID to set
	 * @throws TestDataException 
	 */
	public void setDataValueID(String sERSetID) {
		this.dataValueID = sERSetID;
		
	}

}
