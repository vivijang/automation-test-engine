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
package org.bigtester.ate.model.data;

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.EnumRunTimeDataType;
import org.bigtester.ate.constant.ExceptionErrorCode;
import org.bigtester.ate.constant.ExceptionMessage;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.page.IPageObject;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class RunTimeDataHolder defines ....
 * 
 * @author Peidong Hu
 *
 */
public class RunTimeDataHolder extends BaseInputDataValue implements IStepInputData{

	/** The page that has been used to parse the data. */
	@Nullable
	private IPageObject page;
	

	/** The data type. */
	final private EnumRunTimeDataType dataType;

	/** The page html left boundry. */
	@Nullable
	private String pageHtmlLeftBoundry;

	/** The oage html right boundry. */
	@Nullable
	private String pageHtmlRightBoundry;

	
	/**
	 * @return the dataType
	 */
	public EnumRunTimeDataType getDataType() {
		return dataType;
	}

	/**
	 * Instantiates a new run time data holder.
	 *
	 * @param dataType
	 *            the data type
	 * @param pageHtmlRightBoundry
	 */
	public RunTimeDataHolder(EnumRunTimeDataType dataType,
			String pageHtmlLeftBoundry, String pageHtmlRightBoundry,
			IPageObject page) {
		super("");
		this.dataType = dataType;
		this.pageHtmlLeftBoundry = pageHtmlLeftBoundry;
		this.pageHtmlRightBoundry = pageHtmlRightBoundry;
		this.page = page;
	}

	/**
	 * Instantiates a new run time data holder.
	 *
	 * @param dataType
	 *            the data type
	 * @param strDataValue
	 *            the str data value
	 */
	public RunTimeDataHolder(EnumRunTimeDataType dataType, String strDataValue) {
		super(strDataValue);
		this.dataType = dataType;
	}

	/**
	 * @return the pageHtmlLeftBoundry
	 */
	public String getPageHtmlLeftBoundry() {
		final String pageHtmlLeftBoundry2 = pageHtmlLeftBoundry;
		if (null == pageHtmlLeftBoundry2 ) {
			throw GlobalUtils.createNotInitializedException("pageHtmlLeftBoundry");
		} else {
			return pageHtmlLeftBoundry2;
		}
	}

	/**
	 * @return the oageHtmlRightBoundry
	 */
	public String getPageHtmlRightBoundry() {
		final String pageHtmlLeftBoundry2 = pageHtmlRightBoundry;
		if (null == pageHtmlLeftBoundry2 ) {
			throw GlobalUtils.createNotInitializedException("pageHtmlRightBoundry");
		} else {
			return pageHtmlLeftBoundry2;
		}
	}

	/**
	 * @return the page
	 */
	public IPageObject getPage() {
		final IPageObject page2 = page;
		if (null == page2 ) {
			throw GlobalUtils.createNotInitializedException("page object");
		} else {
			return page2;
		}
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(IPageObject page) {
		this.page = page;
	}

	/**
	 * @param pageHtmlLeftBoundry the pageHtmlLeftBoundry to set
	 */
	public void setPageHtmlLeftBoundry(String pageHtmlLeftBoundry) {
		this.pageHtmlLeftBoundry = pageHtmlLeftBoundry;
	}

	/**
	 * @param pageHtmlRightBoundry the pageHtmlRightBoundry to set
	 */
	public void setPageHtmlRightBoundry(String pageHtmlRightBoundry) {
		this.pageHtmlRightBoundry = pageHtmlRightBoundry;
	}
	
	/**
	 * Parses the value.
	 * @throws RuntimeDataException 
	 */
	public void parseValue() throws RuntimeDataException
	{
		String str = getPage().getPageHtmlSource();
		String value = str.substring(str.indexOf(getPageHtmlLeftBoundry()) + 1, str.indexOf(getPageHtmlRightBoundry()));
		if (null == value) {
			throw new RuntimeDataException(ExceptionMessage.MSG_RUNTIMEDATA_NOTFOUND, ExceptionErrorCode.RUNTIMEDATA_NOTFOUND);
		}
		setStrDataValue( value );
	}
}
