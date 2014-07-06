package org.bigtester.AutomationTestEngine.PageModel;

import org.bigtester.AutomationTestEngine.PageModel.MyWebDriver.MyFirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public abstract class _PageModelBase {
	@Autowired
	protected MyFirefoxDriver mywd;
}
