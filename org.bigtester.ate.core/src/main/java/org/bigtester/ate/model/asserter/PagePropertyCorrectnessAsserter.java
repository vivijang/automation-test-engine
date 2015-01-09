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

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.AssertType;
import org.bigtester.ate.constant.EnumAssertPriority;
import org.bigtester.ate.constant.EnumAssertResult;
import org.bigtester.ate.constant.ExceptionErrorCode;
import org.bigtester.ate.constant.ExceptionMessage;
import org.bigtester.ate.constant.PagePropertyType;
import org.bigtester.ate.constant.ReportMessage;
import org.bigtester.ate.model.data.StepExecutionResult;
import org.bigtester.ate.model.data.StepExpectedResultValue;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.page.IPageObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

// TODO: Auto-generated Javadoc
/**
 * This class PagePropertyCorrectnessAsserter validates non web element property
 * value including 1) cookie; 2) page title
 * 
 * @author Peidong Hu
 *
 */
public class PagePropertyCorrectnessAsserter extends
		AbstractExpectedResultAsserter implements IExpectedResultAsserter {

	/**
	 * @param pageObj
	 */
	public PagePropertyCorrectnessAsserter(final IPageObject pageObj) {
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
			if (stepERValue.getValue().get(i).getTestDataContext()
					.getContextFieldValue()
					.equalsIgnoreCase(AssertType.PAGE_PROPERTY_CORRECTNESS)) {
				String assertProperty = stepERValue.getValue().get(i)
						.getAssertProperty();
				if (PagePropertyType.COOKIE.equalsIgnoreCase(assertProperty)) {
					Cookie cki = new Cookie(stepERValue.getValue().get(i)
							.getAssertValue(), stepERValue.getValue().get(i)
							.getElementFindByValue());
					super.getResultPage().getCookies().add(cki);
					interestingERDBIndexes.add(stepERValue.getValue().get(i)
							.getIdColumn());
				} else if (PagePropertyType.PAGE_TITLE
						.equalsIgnoreCase(assertProperty)) {
					super.getResultPage().setPageTitle(
							stepERValue.getValue().get(i).getAssertValue());
					interestingERDBIndexes.add(stepERValue.getValue().get(i)
							.getIdColumn());
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean assertER() throws PageValidationException2 {
		execResult.setStepExpectedResultValue(getStepERValue());

		boolean retVal = true; // NOPMD

		WebDriver webDriver = getResultPage().getMyWd().getWebDriver();// NOPMD

		for (int i = 0; i < getStepERValue().getValue().size(); i++) {
			if (getStepERValue().getValue().get(i).getTestDataContext()
					.getContextFieldValue()
					.equalsIgnoreCase(AssertType.PAGE_PROPERTY_CORRECTNESS)) {
				String assertProperty = getStepERValue().getValue().get(i)
						.getAssertProperty();
				if (PagePropertyType.COOKIE.equalsIgnoreCase(assertProperty)) {

					Cookie cki = new Cookie(getStepERValue().getValue().get(i)
							.getAssertValue(), getStepERValue().getValue()
							.get(i).getElementFindByValue());
					if (webDriver.manage().getCookies().contains(cki)) {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), CORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYCORRECT);
					} else {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), NOTCORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYNOTCORRECT);
						PageValidationException2 pve = new PageValidationException2(
								ExceptionMessage.MSG_NONCORRECT_PAGEPROPERTY,
								ExceptionErrorCode.PAGEPROPERTY_INCORRECT,
								assertProperty, getResultPage().getMyWd(),
								GlobalUtils.findTestCaseBean(getApplicationContext()));
						retVal = false;// NOPMD
						throw pve;

					}
				} else if (PagePropertyType.PAGE_TITLE
						.equalsIgnoreCase(assertProperty)) {
					if (webDriver.getTitle()
							.equals(getStepERValue().getValue().get(i)
									.getAssertValue())) {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), CORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYCORRECT);
					} else {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), NOTCORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYNOTCORRECT);
						PageValidationException2 pve = new PageValidationException2(
								ExceptionMessage.MSG_NONCORRECT_PAGEPROPERTY,
								ExceptionErrorCode.PAGEPROPERTY_INCORRECT,
								PagePropertyType.PAGE_TITLE, getResultPage()
										.getMyWd(),
										GlobalUtils.findTestCaseBean(getApplicationContext()));
						retVal = false; // NOPMD
						throw pve;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void assertER2() {
		execResult.setStepExpectedResultValue(getStepERValue());

		WebDriver webDriver = getResultPage().getMyWd().getWebDriver();// NOPMD

		for (int i = 0; i < getStepERValue().getValue().size(); i++) {
			if (getStepERValue().getValue().get(i).getTestDataContext()
					.getContextFieldValue()
					.equalsIgnoreCase(AssertType.PAGE_PROPERTY_CORRECTNESS)) {
				String assertProperty = getStepERValue().getValue().get(i)
						.getAssertProperty();
				if (PagePropertyType.COOKIE.equalsIgnoreCase(assertProperty)) {

					Cookie cki = new Cookie(getStepERValue().getValue().get(i)
							.getAssertValue(), getStepERValue().getValue()
							.get(i).getElementFindByValue());
					if (webDriver.manage().getCookies().contains(cki)) {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), CORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYCORRECT);
					} else {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), NOTCORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYNOTCORRECT);
						execResult.getFailedResults().put(getStepERValue().getValue().get(i)
										.getIdColumn(), EnumAssertResult.PAGEPROPERTYNOTCORRECT);
						EnumAssertPriority failPriority = getStepERValue().getValue().get(i).getAssertPriority();
						if (null != failPriority && failPriority.equals(EnumAssertPriority.HIGH)) {
							execResult.setFlagFailCase(true);
						}
					}
				} else if (PagePropertyType.PAGE_TITLE
						.equalsIgnoreCase(assertProperty)) {
					if (webDriver.getTitle()
							.equals(getStepERValue().getValue().get(i)
									.getAssertValue())) {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), CORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYCORRECT);
					} else {
						execResult
								.getActualResult()
								.getResultSet()
								.put(getStepERValue().getValue().get(i)
										.getIdColumn(), NOTCORRECT);
						execResult.getComparedResult().put(
								getStepERValue().getValue().get(i)
										.getIdColumn(),
								EnumAssertResult.PAGEPROPERTYNOTCORRECT);
						execResult.getFailedResults().put(getStepERValue().getValue().get(i)
								.getIdColumn(), EnumAssertResult.PAGEPROPERTYNOTCORRECT);
						EnumAssertPriority failPriority = getStepERValue().getValue().get(i)
								.getAssertPriority(); 
						if (null != failPriority && failPriority.equals(EnumAssertPriority.HIGH)) {
							execResult.setFlagFailCase(true);
						}
					}
				}
			}
		}
		StepExecutionResult ser = getExecResult();
		StepExpectedResultValue serv = ser.getStepExpectedResultValue();
		if (serv != null) {
			for (int index = 0; index < serv.getValue().size(); index++) {
				if (ser.getActualResult().getResultSet()
						.get(serv.getValue().get(index).getIdColumn()) != null) {
					assertReportMSG += serv.getValue().get(index)
							.getTestDataContext()
							.getContextFieldValue();
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ serv.getValue().get(index)
									.getAssertPriority();
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ serv.getValue().get(index)
									.getAssertProperty();
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ serv.getValue().get(index)
									.getAssertValue();
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ serv.getValue().get(index)
									.getElementFindBy();
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ serv.getValue().get(index)
									.getElementFindByValue();
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ ReportMessage.MSG_SEPERATOR
							+ ser.getActualResult()
									.getResultSet()
									.get(serv.getValue().get(index)
											.getIdColumn());
					assertReportMSG += ReportMessage.MSG_SEPERATOR
							+ ReportMessage.MSG_SEPERATOR
							+ ser.getComparedResult()
									.get(serv.getValue().get(index)
											.getIdColumn()).toString();
					assertReportMSG += '\n';
				}
			}
		}

	}
}
