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
package org.bigtester.ate.model.asserter;


import org.bigtester.ate.constant.AssertType;
import org.bigtester.ate.model.data.StepExpectedResultValue;
import org.bigtester.ate.model.page.exception.PageValidationException;
import org.bigtester.ate.model.page.page.ATEPageFactory;
import org.bigtester.ate.model.page.page.IATEPageFactory;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;

// TODO: Auto-generated Javadoc
/**
 * This class PageElementExistenceAsserter defines ....
 * 
 * @author Peidong Hu
 * 
 */
public class PageElementExistenceAsserter extends AbstractExpectedResultAsserter implements IExpectedResultAsserter {
	
	/**
	 * @param pageObj
	 */
	public PageElementExistenceAsserter(IPageObject pageObj) {
		super();
		setResultPage(pageObj);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStepERValue(StepExpectedResultValue stepERValue) {
		super.setStepERValue(stepERValue);
		
		for (int i = 0; i < stepERValue.getValue().size(); i++) {
			if (stepERValue.getValue().get(i).getTestDataContext().getContextFieldValue().equalsIgnoreCase(AssertType.PAGE_ELEMENT_EXISTENCE))
			{
				IATEPageFactory ipf = ATEPageFactory.getInstance();
				MyWebElement mwe = ipf.getMyWebElement(stepERValue.getValue().get(i).getElementFindBy(), stepERValue.getValue().get(i).getElementFindByValue());
				
				super.getResultPage().getMyWebElementList().add(mwe);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean assertER() throws PageValidationException {
		
//		boolean retVal = false; // NOPMD
//		List<MyWebElement> myWebElementList = getResultPage().getMyWebElementList();
//		if (!myWebElementList.isEmpty()) {
//			MyWebElement webelement;
//			for (int index = 0; index < myWebElementList.size(); index++) {
//				webelement = myWebElementList.get(index);
//				try {
//					webelement.getElementFind().doFind(getResultPage().getMyWd(),
//							webelement.getElementFind().getFindByValue());
//				} catch (NoSuchElementException e) {
//					PageValidationException pve = new PageValidationException(
//							ExceptionMessage.MSG_WEBELEMENT_NOTFOUND,
//							ExceptionErrorCode.WEBELEMENT_NOTFOUND,
//							webelement.getElementFind());
//					pve.initCause(e);
//					throw pve;
//				} 
//			}
//			retVal = true;
//		}
		return getResultPage().validatePage();
	}

}
