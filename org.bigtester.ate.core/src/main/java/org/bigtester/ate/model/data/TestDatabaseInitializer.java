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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bigtester.ate.GlobalUtils;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import edu.umd.cs.findbugs.annotations.NonNull;




// TODO: Auto-generated Javadoc
/**
 * This class DatabaseInitializer defines ....
 * 
 * @author Peidong Hu
 *
 */

public class TestDatabaseInitializer {

	/** The init xml file. */
	final private List<InputStream> initXmlFile = new ArrayList<InputStream>();

	/** The datasets. */
	transient private IDataSet[] datasets;

	/** The single init xml file. */
	private InputStream singleInitXmlFile;

	/**
	 * Gets the inits the xml file.
	 *
	 * @return the initXmlFile
	 */
	public List<InputStream> getInitXmlFile() {
		return initXmlFile;
	}

	/**
	 * Sets the inits the xml file.
	 *
	 * @param initXmlFile
	 *            the initXmlFile to set
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setInitXmlFile(List<Resource> initXmlFile) throws IOException {
		for (int i = 0; i < initXmlFile.size(); i++) {

			this.initXmlFile.add(initXmlFile.get(i).getInputStream());

		}
	}

	/**
	 * Initialize.
	 *
	 * @param context
	 *            the context
	 * @param dataSource
	 *            the data source
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	public void initializeGlobalDataFile(ApplicationContext context)
			throws DatabaseUnitException, SQLException, MalformedURLException {
		DataSource datas = GlobalUtils.findDataSourceBean(context);
		IDatabaseConnection con = new DatabaseConnection(datas.getConnection()); // Create
																					// DBUnit
																					// Database
																					// connection
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);

		datasets = new IDataSet[] { builder.build(singleInitXmlFile) };
		DatabaseOperation.REFRESH.execute(con, new CompositeDataSet(datasets)); // Import
																				// your
																				// data

		// TODO handle the empty data file case.
		con.close();

	}

	/**
	 * Initialize.
	 *
	 * @param context
	 *            the context
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	public void initialize(ApplicationContext context)
			throws DatabaseUnitException, SQLException, MalformedURLException {
		DataSource datas = GlobalUtils.findDataSourceBean(context);
		IDatabaseConnection con = new DatabaseConnection(datas.getConnection()); // Create
																					// DBUnit
																					// Database
																					// connection
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);

		if (!initXmlFile.isEmpty()) {
			datasets = new IDataSet[initXmlFile.size()];
			for (int i = 0; i < initXmlFile.size(); i++) {
				datasets[i] = builder.build(initXmlFile.get(i));
			}
			DatabaseOperation.CLEAN_INSERT.execute(con, new CompositeDataSet(
					datasets)); // Import your data
		}
		// TODO handle the empty data file case.
		con.close();

	}

	/**
	 * Initialize.
	 *
	 * @param beanFac
	 *            the bean factory
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws MalformedURLException
	 *             the malformed url exception
	 */
	public void initialize(BeanFactory beanFac) throws DatabaseUnitException,
			SQLException, MalformedURLException {
		DataSource datas = GlobalUtils.findDataSourceBean(beanFac);
		IDatabaseConnection con = new DatabaseConnection(datas.getConnection()); // Create
																					// DBUnit
																					// Database
																					// connection
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);

		if (!initXmlFile.isEmpty()) {
			datasets = new IDataSet[initXmlFile.size()];
			for (int i = 0; i < initXmlFile.size(); i++) {
				datasets[i] = builder.build(initXmlFile.get(i));
			}
			DatabaseOperation.CLEAN_INSERT.execute(con, new CompositeDataSet(
					datasets)); // Import your data
		}
		// TODO handle the empty data file case.
		con.close();

	}

	/**
	 * @return the singleInitXmlFile
	 */
	public InputStream getSingleInitXmlFile() {
		return singleInitXmlFile;
	}

	/**
	 * @param singleInitXmlFile
	 *            the singleInitXmlFile to set
	 * @throws IOException
	 */
	public void setSingleInitXmlFile(@org.eclipse.jdt.annotation.NonNull Resource singleInitXmlFile)
			throws IOException {
		this.singleInitXmlFile = singleInitXmlFile.getInputStream();
	}

}
