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


import org.bigtester.ate.model.project.XmlTestCase;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;


// TODO: Auto-generated Javadoc
/**
 * This class SimpleDateFormatBeanDefinitionParser defines ....
 * 
 * @author Peidong Hu
 *
 */
public class XmlTestCaseBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	/**
	 * {@inheritDoc}
	 */
	protected Class<XmlTestCase> getBeanClass(Element element) {
	        return XmlTestCase.class; 
    }

	/**
	 * {@inheritDoc}
	 */
	protected void doParse(Element element, BeanDefinitionBuilder bean) {
        // this will never be null since the schema explicitly requires that a value be supplied
        String testCaseName = element.getAttribute("testCaseName");
        bean.addPropertyValue("testCaseName", testCaseName);
//
//        // this however is an optional property
//        String lenient = element.getAttribute("list-class");
//        if (StringUtils.hasText(lenient)) {
//            bean.addPropertyValue("lenient", Boolean.valueOf(lenient));
//        }
    }

}
