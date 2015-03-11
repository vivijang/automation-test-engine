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
package org.bigtester.ate.model.data.dbtable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.EnumAssertPriority;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class BaseStepExpectedResult defines ....
 * 
 * @author Peidong Hu
 *
 */
@MappedSuperclass
public abstract class BaseStepExpectedResult extends BaseTestDataTable {

	/** The assert priority. */

	@Enumerated(EnumType.STRING)
	@Column
	@Nullable
	private EnumAssertPriority assertPriority; // NOPMD

	@Column
	@Nullable
	private String pageName; // NOPMD

	/** The step er set id. */

	@Column
	@Nullable
	private String stepERSetID; // NOPMD

	/**
	 * @return the pageName
	 */
	public String getPageName() {
		final String retVal = pageName;
		if (null == retVal) {
			throw new IllegalStateException(
					"pagename collumn is not correctly populated");

		} else {
			return retVal;
		}
	}

	/**
	 * @return the stepERSetID
	 */
	public String getStepERSetID() {
		final String retVal = stepERSetID;
		if (null == retVal) {
			throw new IllegalStateException(
					"stepERSetID collumn is not correctly populated");

		} else {
			return retVal;
		}
	}

	/**
	 * @param assertPriority
	 *            the assertPriority to set
	 */
	public void setAssertPriority(EnumAssertPriority assertPriority) {
		this.assertPriority = assertPriority;
	}

	/**
	 * @param pageName
	 *            the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/**
	 * @param stepERSetID
	 *            the stepERSetID to set
	 */
	public void setStepERSetID(String stepERSetID) {
		this.stepERSetID = stepERSetID;
	}

	/**
	 * @return the assertPriority
	 */
	public EnumAssertPriority getAssertPriority() {
		final EnumAssertPriority assertPriority2 = assertPriority;
		if (null == assertPriority2) {
			throw GlobalUtils.createNotInitializedException("assertPriority");
		} else {
			return assertPriority2;
		}
	}

}
