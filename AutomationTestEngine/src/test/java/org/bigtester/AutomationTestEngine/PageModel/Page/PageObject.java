package org.bigtester.AutomationTestEngine.PageModel.Page;
import org.bigtester.AutomationTestEngine.DataModel.DataSet.DataSet;
import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;
import org.bigtester.AutomationTestEngine.PageModel.WebElementXmlObject;
import org.bigtester.AutomationTestEngine.PageModel.ElementAction._ElementAction;
import org.bigtester.AutomationTestEngine.PageModel.ElementFind._ElementFind;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
public class PageObject extends _PageModelBase {
	@Autowired
	PageXmlObject pXmlO;
	
	List<WebElement> lWe;
	
	public PageXmlObject getpXmlO() {
		return pXmlO;
	}


	public void setpXmlO(PageXmlObject pXmlO) {
		this.pXmlO = pXmlO;
	}


	public List<WebElement> getlWe() {
		return lWe;
	}


	public void setlWe(List<WebElement> lWe) {
		this.lWe = lWe;
	}


	public PageObject() {
		initializePage();
	}
		
	
	private void initializePage()
	{
		for (WebElementXmlObject wexotemp : pXmlO.getWebEs()) {
			
		}
	}
//	public PageObject doAction(WebDriver driver, WebElementXmlObject weo, String action)
//	{
//		
//		By by = new By.ById("");
//		switch (FindByType.valueOf(weo.getFindby().toUpperCase())) { 
//			case NAME:
//				 by = new By.ByName(weo.getFindbyvalue());
//			case ID:
//				 by = new By.ById(weo.getFindbyvalue());
//			break;
//		default:
//			break;
//		}
//		
//		switch (ActionType.valueOf(action.toUpperCase())) {
//		default:
//			break;
//		case SENDKEYS:
//			driver.findElement(by).sendKeys("test");
//		}
//		return this;
//	}

	public PageObject doAction(WebElementXmlObject wexo, _ElementFind ef, _ElementAction eat, DataSet ds, PageObject downstreamPO) {
		
		eat.doAction(ef.doFind(wexo.getFindbyvalue()));
		return null;
	}
}
