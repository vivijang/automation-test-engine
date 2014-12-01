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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * This class ElementInputData defines ....
 * @author Peidong Hu
 *
 */
@Entity
@Table


/**
 * {@inheritDoc}
 */
@Data
@SuppressWarnings(value = { "PMD" })
public class ElementInputData {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column
    private Long id;
	
	
	
	/**
	 * Gets the data name.
	 *
	 * @return the data name
	 */
	@Getter
	
	
	/**
	 * Sets the data name.
	 *
	 * @param dataName the new data name
	 */
	@Setter
	@Column(length = 50, nullable = false, unique = false)
	private String dataName;
	/** The key in data. */
	
	
	
	/**
	 * Gets the data value.
	 *
	 * @return the data value
	 */
	@Getter
	
	
	/**
	 * Sets the data value.
	 *
	 * @param dataValue the new data value
	 */
	@Setter
	@Column(length = 50, nullable = false, unique = true)
	private String dataValue;
	
	
	
	
	/**
	 * Gets the test data context.
	 *
	 * @return the test data context
	 */
	@Getter
	
	
	
	/**
	 * Sets the test data context.
	 *
	 * @param testDataContext the new test data context
	 */
	@Setter
	@ManyToOne
	@JoinColumn(name = "testDataContext_idColumn", referencedColumnName = "idColumn")
	private TestDataContext testDataContext; //NOPMD
	
	/**
	 * Sets the sunny parent data.
	 *
	 * @param sunnyParentData the new sunny parent data
	 */
	@Setter
	
	/**
	 * Gets the sunny parent data.
	 *
	 * @return the sunny parent data
	 */
	@Getter
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="sunnyParentData_id", referencedColumnName = "id")
    private ElementInputData sunnyParentData;
	
	/**
	 * Sets the subordinates.
	 *
	 * @param subordinates the new subordinates
	 */
	@Setter
	
	/**
	 * Gets the subordinates.
	 *
	 * @return the subordinates
	 */
	@Getter
    @OneToMany(mappedBy="sunnyParentData")
    private Set<ElementInputData> subordinates = new HashSet<ElementInputData>();
	
	/**
	 * Instantiates a new element input data.
	 *
	 * @param dataName the data name
	 * @param dataValue the data value
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
