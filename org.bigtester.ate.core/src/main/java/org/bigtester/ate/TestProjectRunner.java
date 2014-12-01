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

package org.bigtester.ate;

import java.net.MalformedURLException;
import java.sql.SQLException;


import org.bigtester.ate.model.data.TestDatabaseInitializer;
import org.bigtester.ate.model.project.TestProject;
import org.dbunit.DatabaseUnitException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class TestProjectRunner defines ....
 * 
 * @author Peidong Hu
 */
public final class TestProjectRunner {
	
	/** The context. */
	private static ApplicationContext context; 
	/**
	 * Instantiates a new test project runner.
	 */
	private TestProjectRunner() {
		
	}
	
	
	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws SQLException 
	 * @throws DatabaseUnitException 
	 * @throws MalformedURLException 
	 */
	public static void main(final String... args) throws DatabaseUnitException, SQLException, MalformedURLException {
		context = new ClassPathXmlApplicationContext(
				"testproject.xml");
		TestDatabaseInitializer dbinit = (TestDatabaseInitializer) context.getBean("dbInitializer");
		
		//TODO add db initialization handler
		dbinit.initialize(context, "dataSource");
		
	  	runTest();
	  	((ConfigurableApplicationContext)context).close();
	}
	
	/**
	 * Run test.
	 */
	private static void runTest() {
		TestProject testProj = (TestProject) context.getBean("testproject");
		testProj.runSuites();
		
	}

}
