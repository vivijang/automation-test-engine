/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
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
package org.bigtester.ate.model.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bigtester.ate.model.caserunner.CaseRunnerGenerator;
import org.testng.annotations.Test;





import com.github.javaparser.ParseException;

public class CaseRunnerGeneratorTest {
  
  /**
   * F.
   *
   * @throws ParseException the parse exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testCaseRunnerGenerator() throws ParseException, IOException {
	 CaseRunnerGenerator crg = new CaseRunnerGenerator(3);
	 crg.createCaseRunners();
	 for (int i=0; i<crg.getCaseRunnerJavaFileNames().size(); i++) {
		 //crg.changeTestMethodName(crg.getCaseRunnerCacheAbsoluteFolder() + crg.getCaseRunnerJavaFilePathNames().get(i), "runTest" + "abc");
		 List<String> groups = new ArrayList<String>();
		 groups.add("test1");
		 groups.add("test2");
		 crg.changeTestAnnotationGroups(crg.getCaseRunnerCacheAbsoluteFolder() + crg.getCaseRunnerJavaFileNames().get(i), groups, "runTest");
	 }
  }
}
