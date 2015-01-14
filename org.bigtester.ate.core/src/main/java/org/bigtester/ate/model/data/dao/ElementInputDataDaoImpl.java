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
import org.bigtester.ate.model.data.dbtable.ElementInputData;
import org.bigtester.ate.model.data.exception.TestDataException;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * This class ElementInputDataDaoImpl defines ....
 * 
 * @author Peidong Hu
 *
 */
@Transactional
public class ElementInputDataDaoImpl extends BaseDaoImpl {

	
	/**
	 * Save.
	 *
	 * @param eid
	 *            the eid
	 * @return the long
	 */
	public Long save(@Nullable ElementInputData eid) {
		long retVal;
		if (null == eid)
			retVal = 0;
		else {
			getDbEM().persist(eid);
			retVal = eid.getId();
		}
		return retVal;
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public @Nullable List<ElementInputData> getAll() {
		return getDbEM().createQuery("SELECT p FROM ElementInputData p",
				ElementInputData.class).getResultList();
	}

	/**
	 * Gets the value.
	 *
	 * @param inputDataID
	 *            the input data id
	 * @return the value
	 */
	public String getValue(Long inputDataID) throws TestDataException {

		ElementInputData eid = getDbEM().find(ElementInputData.class,
				inputDataID);
		if (eid == null) {
			throw new TestDataException(ExceptionMessage.MSG_TESTDATA_NOTFOUND,
					ExceptionErrorCode.TESTDATA_NOTFOUND);
		} else {
			return eid.getDataValue();
		}
	}
}
