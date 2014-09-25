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
package org.bigtester.ate.model.data.dao;

import java.util.List;

import org.bigtester.ate.constant.ExceptionErrorCode;
import org.bigtester.ate.constant.ExceptionMessage;
import org.bigtester.ate.model.data.dbtable.StepExpectedResult;
import org.bigtester.ate.model.data.exception.TestDataException;

// TODO: Auto-generated Javadoc
/**
 * This class StepExpectedResultDaoImpl defines ....
 * @author Peidong Hu
 *
 */
public class StepExpectedResultDaoImpl extends AbstractDaoImpl{
	 
    /**
     * Gets the step expected results list.
     *
     * @param sERSetID the s er set id
     * @return the e rs
     * @throws TestDataException the test data exception
     */
    public List<StepExpectedResult> getERs(String sERSetID) throws TestDataException{
    	
    	List<StepExpectedResult> sERs = (List<StepExpectedResult>) getDbEM()
		.createQuery("select p from StepExpectedResult p where p.stepERSetID = :stepERSetID", StepExpectedResult.class)
		.setParameter("stepERSetID", sERSetID)
		.getResultList();
    	if (sERs.isEmpty()) {
    		throw new TestDataException(ExceptionMessage.MSG_TESTDATA_NOTFOUND, ExceptionErrorCode.TESTDATA_NOTFOUND);
    	} else {
    		return sERs;
    	}
    }
    
    
}
