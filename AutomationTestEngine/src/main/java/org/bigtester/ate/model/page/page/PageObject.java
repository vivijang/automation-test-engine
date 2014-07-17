package org.bigtester.ate.model.page.page;

import org.bigtester.ate.model.page._PageModelBase;
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
