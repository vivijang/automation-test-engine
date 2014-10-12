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
package org.bigtester.ate.model.page.exception;


import org.bigtester.ate.model.AbstractATECaseExecE;
import org.bigtester.ate.model.casestep.TestCase;
import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.elementfind.IElementFind;

// TODO: Auto-generated Javadoc
/**
 * This class PageValidationException defines ....
 * @author Peidong Hu
 *
 */
public class PageValidationException2 extends AbstractATECaseExecE {
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7144577815429959503L;
	
	
	
	/** The element find. */
	private final IElementFind elementFind;
     
    
    /**
     * Instantiates a new page validation exception.
     *
     * @param message the message
     * @param errorCode the error code
     * @param eFind the e find
     */
    public PageValidationException2(String message, String errorCode, IElementFind eFind, IMyWebDriver myWebDriver, TestCase currentTestCase){
        super(message, errorCode);
        elementFind = eFind;
        setCurrentTestCase(currentTestCase);
        setMyWebDriver(myWebDriver);
    }
     

	/**
	 * Gets the element find.
	 *
	 * @return the elementFind
	 */
	public IElementFind getElementFind() {
		return elementFind;
	}

	
	
}
