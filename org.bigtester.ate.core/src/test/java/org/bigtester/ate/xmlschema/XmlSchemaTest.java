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
package org.bigtester.ate.xmlschema;

import org.bigtester.ate.model.casestep.TestCase;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.page.page.Homepage;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlSchemaTest.
 *
 * @author Peidong Hu
 */
public class XmlSchemaTest {
	
	/** The context. */
	transient private ClassPathXmlApplicationContext context;

	/**
	 * Bt.
	 */
	@BeforeTest
	public void initT() {
		context = new ClassPathXmlApplicationContext(
				"XmlSchemaTest-applicationContext.xml");
	}

	/**
	 * F.
	 */
	@Test
	public void testHomepage() {

		Homepage jdt = (Homepage) context.getBean("homepg");
		jdt.setHomeUrl("http://www.bigtester.com");
		jdt.startHomepage();

		context.close();
	}

	/**
	 * F1.
	 *
	 * @throws StepExecutionException2 the step execution exception2
	 * @throws PageValidationException2 the page validation exception2
	 */
	@Test
	public void testTestCase() throws StepExecutionException2, PageValidationException2 {

		TestCase jdt = (TestCase) context.getBean("testcase");
		jdt.goSteps();
		context.close();
	}

}
