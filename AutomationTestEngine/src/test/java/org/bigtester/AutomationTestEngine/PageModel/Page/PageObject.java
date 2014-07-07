package org.bigtester.AutomationTestEngine.PageModel.Page;

import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObject extends _PageModelBase {

	List<WebElement> lWe;

	public List<WebElement> getlWe() {
		return lWe;
	}

	public void setlWe(List<WebElement> lWe) {
		this.lWe = lWe;
	}

	public PageObject() {

	}

}
