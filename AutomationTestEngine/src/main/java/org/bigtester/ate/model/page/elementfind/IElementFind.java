package org.bigtester.ate.model.page.elementfind;

import org.openqa.selenium.WebElement;

public interface IElementFind {
	public WebElement doFind(String findByValue);
	public String getFindByValue();
}
