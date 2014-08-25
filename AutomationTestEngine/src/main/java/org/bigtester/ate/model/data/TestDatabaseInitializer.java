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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

// TODO: Auto-generated Javadoc
/**
 * This class DatabaseInitializer defines ....
 * @author Peidong Hu
 *
 */

public class TestDatabaseInitializer {
	
	/** The init xml file. */
	private File initXmlFile;

	/**
	 * Gets the inits the xml file.
	 *
	 * @return the initXmlFile
	 */
	public File getInitXmlFile() {
		return initXmlFile;
	}

	/**
	 * Sets the inits the xml file.
	 *
	 * @param initXmlFile the initXmlFile to set
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setInitXmlFile(Resource initXmlFile) throws IOException {
		this.initXmlFile = initXmlFile.getFile();
	}
	
	/**
	 * Initialize.
	 *
	 * @param context the context
	 * @param dataSource the data source
	 * @throws DatabaseUnitException the database unit exception
	 * @throws SQLException the SQL exception
	 * @throws MalformedURLException the malformed url exception
	 */
	public void initialize(ApplicationContext context, String dataSource) throws DatabaseUnitException, SQLException, MalformedURLException {
		DataSource datas = (DataSource)context.getBean(dataSource);
		IDatabaseConnection con = new DatabaseConnection(datas.getConnection()); //Create DBUnit Database connection 
		DatabaseOperation.REFRESH.execute(con, new FlatXmlDataSetBuilder().build(initXmlFile)); //Import your data
		con.close();
		
	}

}
