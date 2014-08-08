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

import java.util.List;

import org.bigtester.ate.model.data.ElementInputData;
import org.bigtester.ate.model.data.ElementInputDataDaoImpl;
import org.bigtester.ate.systemlogger.LogbackWriter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class DataManager {
	
	/**
	 * Test first data class.
	 */
	@Test
	public void testFirstDataClass() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ElementInputDataDaoImpl dao = (ElementInputDataDaoImpl) context
				.getBean("elementInputDataDao");

		ElementInputData eid = new ElementInputData("Regular User",
				"login Name", "peidonghu");
		ElementInputData eid2 = new ElementInputData("Manager User",
				"login Name", "peidonghu2");

		dao.save(eid);
		dao.save(eid2);

		List<ElementInputData> persons = dao.getAll();
		for (ElementInputData person : persons) {
			LogbackWriter.writeAppInfo("testng-msg: " + person.toString());
		}
		context.close();
	}
}
