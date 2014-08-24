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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Data
@SuppressWarnings(value = { "PMD" })
public class ElementInputData {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column
    private Long id;
	
	/** The data name. */
	@Getter
	@Setter
	@Column(length = 50, nullable = false, unique = false)
	private String dataName;
	/** The key in data. */
	@Getter
	@Setter
	@Column(length = 50, nullable = false, unique = true)
	private String dataValue;
	
	public ElementInputData(String dataName, String dataValue) {
		this.dataName = dataName;
		this.dataValue = dataValue;
	}
	public ElementInputData() {
		this.dataName = "";
		this.dataValue = "";
	}
}
