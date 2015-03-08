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
package org.bigtester.ate.model.data.dbtable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.bigtester.ate.GlobalUtils;
import org.eclipse.jdt.annotation.Nullable;



// TODO: Auto-generated Javadoc
/**
 * This class StepResult defines ....
 * 
 * @author Peidong Hu
 *
 */
@Entity
@Table
public class RepeatStepErElementExistence extends StepErElementExistence {

	@Column
	private int iterationIndex; // NOPMD
	
	/** The step er set id. */
	@Column
	@Nullable
	private String repeatStepBeanId;

	/**
	 * @return the iterationIndex
	 */
	public int getIterationIndex() {
		return iterationIndex;
	}

	/**
	 * @return the repeatStepBeanId
	 */
	public String getRepeatStepBeanId() {
		final String repeatStepBeanId2 = repeatStepBeanId;
		if (null == repeatStepBeanId2) {
			throw GlobalUtils.createNotInitializedException("repeat step bean id");
			
		} else {
			return repeatStepBeanId2;
		}
	}

	/**
	 * @param iterationIndex the iterationIndex to set
	 */
	public void setIterationIndex(int iterationIndex) {
		this.iterationIndex = iterationIndex;
	}

	/**
	 * @param repeatStepBeanId the repeatStepBeanId to set
	 */
	public void setRepeatStepBeanId(String repeatStepBeanId) {
		this.repeatStepBeanId = repeatStepBeanId;
	}

}
