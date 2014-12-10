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

// TODO: Auto-generated Javadoc
/**
 * The Class TestParameters defines ....
 *
 * @author Peidong Hu
 */
public class TestParameters 
{
    
    /** The test name. */
    private String testName;
    
    /** The test file name. */
    private String testFileName;

    /** The step think time. */
    private int stepThinkTime;
    /**
	 * @return the stepThinkTime
	 */
	public int getStepThinkTime() {
		return stepThinkTime;
	}

	/**
	 * @param stepThinkTime the stepThinkTime to set
	 */
	public void setStepThinkTime(int stepThinkTime) {
		this.stepThinkTime = stepThinkTime;
	}

	/**
     * Instantiates a new test parameters.
     *
     * @param name the name
     * @param filename the filename
     */
    public TestParameters( String name, String filename ) {
        this.testName = name;
        this.testFileName = filename;
    }

    /**
     * Gets the test name.
     *
     * @return the test name
     */
    public String getTestName() {
        return testName;
    }
    
    /**
     * Gets the test file name.
     *
     * @return the testFileName
     */
	public String getTestFileName() {
		return testFileName;
	}

	/**
	 * Sets the test file name.
	 *
	 * @param testFileName the testFileName to set
	 */
	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}

	/**
	 * Sets the test name.
	 *
	 * @param testName the testName to set
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 * Gets the test filename.
	 *
	 * @return the test filename
	 */
	public String getTestFilename() {
        return testFileName;
    }
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty(){
		return testName.isEmpty() && testFileName.isEmpty();
	}
}
