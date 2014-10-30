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

//import java.io.File;
//
//import net.xeoh.plugins.base.PluginManager;
//import net.xeoh.plugins.base.impl.PluginManagerFactory;

import org.bigtester.ate.plugins.elementfind.IElementFind;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import org.xeustechnologies.jcl.JarClassLoader;

// TODO: Auto-generated Javadoc
/**
 * This class PluginTest defines ....
 * 
 * @author Peidong Hu
 *
 */
public class PluginTest {

	/**
	 * Loadplugin.
	 */
	@Test
	public void loadplugin() {

//		PluginManager plgm = PluginManagerFactory.createPluginManager();
//
//		// and then one or more of these ...
//
//		plgm.addPluginsFrom(new File(
//				"/home/peidong/git/ate/automation-test-engine/AutomationTestEngine/src/test/java/Untitled.jar")
//				.toURI());
//		IElementFind ief = plgm.getPlugin(IElementFind.class);
		
//		JarClassLoader jcl = new JarClassLoader();
//
//		jcl.add("/home/peidong/git/ate/automation-test-engine/AutomationTestEngine/target/testplugin.jar");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"Test-applicationContextPlugin.xml");
		IElementFind myef = (IElementFind) context.getBean("usernameValue2");
		System.out.println(myef.doFind("test1", 0));
		context.close();

	}
}
