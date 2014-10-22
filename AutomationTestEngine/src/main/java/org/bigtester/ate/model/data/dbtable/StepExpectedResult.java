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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.bigtester.ate.constant.EnumAssertPriority;
import org.bigtester.ate.constant.EnumElementFindType;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * This class StepResult defines ....
 * @author Peidong Hu
 *
 */
@Entity
@Table
public class StepExpectedResult extends AbstractTestDataTable{
	
	/** The step er set id. */
	
	/**
	 * Gets the step er set id.
	 *
	 * @return the step er set id
	 */
	@Getter
	
	/**
	 * Sets the step er set id.
	 *
	 * @param stepERSetID the new step er set id
	 */
	@Setter
	@Column
	private String stepERSetID; //NOPMD
	
	/**
	 * Gets the element find by.
	 *
	 * @return the element find by
	 */
	@Getter
	
	
	/**
	 * Sets the element find by.
	 *
	 * @param ElementFindBy the new element find by
	 */
	@Setter
	//@ManyToOne
	//@JoinColumn(name = "elementFindByType_idColumn", referencedColumnName = "idColumn")
	@Enumerated(EnumType.STRING)
	@Column
	private EnumElementFindType ElementFindBy; //NOPMD
	
	/** The assert priority. */
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@Column
	private EnumAssertPriority assertPriority; //NOPMD
	
	
	/**
	 * Gets the element find by value.
	 *
	 * @return the element find by value
	 */
	@Getter
	
	/**
	 * Sets the element find by value.
	 *
	 * @param ElementFindByValue the new element find by value
	 */
	@Setter
	@Column
	/** The Element find by value. */
	private String ElementFindByValue; //NOPMD
	
	/**
	 * Sets the assert property.
	 *
	 */
	@Setter
	
	/**
	 * Gets the assert property.
	 *
	 * @return the assert property
	 */
	@Getter
	@Column
	/** The Assert property. */
	private String AssertProperty; //NOPMD
	
	/**
	 * Sets the assert value.
	 *
	 * @param AssertValue the new assert value
	 */
	@Setter
	
	/**
	 * Gets the assert value.
	 *
	 * @return the assert value
	 */
	@Getter
	@Column
	/** The Assert value. */
	private String AssertValue; //NOPMD
	
	
	/** The page name. */
	
	/**
	 * Gets the page name.
	 *
	 * @return the page name
	 */
	@Getter
	
	/**
	 * Sets the page name.
	 *
	 * @param pageName the new page name
	 */
	@Setter
	@Column
	private String pageName; //NOPMD

}
