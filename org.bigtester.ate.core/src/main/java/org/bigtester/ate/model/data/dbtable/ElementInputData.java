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

import static javax.persistence.GenerationType.AUTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.jdt.annotation.Nullable;


// TODO: Auto-generated Javadoc
/**
 * This class ElementInputData defines ....
 * 
 * @author Peidong Hu
 *
 */
@Entity
@Table
/**
 * {@inheritDoc}
 */
// @Data
@SuppressWarnings(value = { "PMD" })
public class ElementInputData {

	/** The id. */
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column
	@Nullable
	private Long id;

	@Column(length = 50, nullable = false, unique = false)
	@Nullable
	private String dataName;
	/** The key in data. */

	@Column(length = 50, nullable = false, unique = true)
	@Nullable
	private String dataValue;

	/**
	 * @return the id
	 */
	public Long getId() {
		final Long id2 = id;
		if (null == id2 ) {
			throw new IllegalStateException("id collumn is not correctly populated");
		} else {
			return id2;
		}
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dataName
	 */
	public String getDataName() {
		final String dataName2 = dataName;
		if (null == dataName2) {
			throw new IllegalStateException("dataName collumn is not correctly populated");
			
		} else {
			return dataName2;
		}
	}

	/**
	 * @param dataName the dataName to set
	 */
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	/**
	 * @return the dataValue
	 */
	public String getDataValue() {
		final String dataValue2 = dataValue;
		if (null == dataValue2) {
			throw new IllegalStateException("datavalue collumn is not correctly populated");
			
		} else {
			return dataValue2;
		}
	}

	/**
	 * @param dataValue the dataValue to set
	 */
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	/**
	 * @return the testDataContext
	 */
	public TestDataContext getTestDataContext() {
		final TestDataContext retVal = testDataContext;
		if (null == retVal) {
			throw new IllegalStateException("test data context collumn is not correctly populated");
			
		} else {
			return retVal;
		}
	}

	/**
	 * @param testDataContext the testDataContext to set
	 */
	public void setTestDataContext(TestDataContext testDataContext) {
		this.testDataContext = testDataContext;
	}

	/**
	 * @return the sunnyParentData
	 */
	public ElementInputData getSunnyParentData() {
		final ElementInputData retVal = sunnyParentData;
		if (null == retVal) {
			throw new IllegalStateException("sunny parent data collumn is not correctly populated");
			
		} else {
			return retVal;
		}
	}

	/**
	 * @param sunnyParentData the sunnyParentData to set
	 */
	public void setSunnyParentData(ElementInputData sunnyParentData) {
		this.sunnyParentData = sunnyParentData;
	}

	/**
	 * @return the subordinates
	 */
	public Set<ElementInputData> getSubordinates() {
		final Set<ElementInputData> retVal = subordinates;
		if (null == retVal) {
			throw new IllegalStateException("subordinates collumn is not correctly populated");
			
		} else {
			return retVal;
		}
	}

	/**
	 * @param subordinates the subordinates to set
	 */
	public void setSubordinates(Set<ElementInputData> subordinates) {
		this.subordinates = subordinates;
	}

	@ManyToOne
	@JoinColumn(name = "testDataContext_idColumn", referencedColumnName = "idColumn")
	@Nullable
	private TestDataContext testDataContext; // NOPMD

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "sunnyParentData_id", referencedColumnName = "id")
	@Nullable
	private ElementInputData sunnyParentData;

	@OneToMany(mappedBy = "sunnyParentData")
	@Nullable
	private Set<ElementInputData> subordinates = new HashSet<ElementInputData>();

	/**
	 * Instantiates a new element input data.
	 *
	 * @param dataName
	 *            the data name
	 * @param dataValue
	 *            the data value
	 */
	public ElementInputData(String dataName, String dataValue) {
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

	/**
	 * Instantiates a new element input data.
	 */
	public ElementInputData() {
		this.dataName = "";
		this.dataValue = "";
	}
}
