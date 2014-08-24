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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * This class TestDataContext defines ....
 * 
 * @author Peidong Hu
 * 
 */
@Entity
@Table
public class TestDataContext extends AbstractDBTable {
	@Column(length = 50, nullable = false, unique = false)
	/**
	 * Gets the context field value.
	 *
	 * @return the context field value
	 */
	@Getter
	/**
	 * Sets the context field value.
	 *
	 * @param contextFieldValue the new context field value
	 */
	@Setter
	private String contextFieldValue; //NOPMD

	/**
	 * Gets the context field name.
	 * 
	 * @return the context field name
	 */
	@Getter
	/**
	 * Sets the context field name.
	 *
	 * @param contextFieldName the new context field name
	 */
	@Setter
	@ManyToOne
	@JoinColumn(name = "contextFieldName_idColumn", referencedColumnName = "idColumn")
	private TestDataContextFieldName contextFieldName; //NOPMD

}
