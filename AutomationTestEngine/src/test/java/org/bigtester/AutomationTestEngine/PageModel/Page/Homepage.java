package org.bigtester.AutomationTestEngine.PageModel.Page;

import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;
import org.springframework.beans.factory.annotation.Autowired;

public class Homepage extends _PageModelBase{
	@Autowired
	private static String homeUrl;
	public static void setHomeUrl(String homeUrl) {
		Homepage.homeUrl = homeUrl;
	}

	public String getHomeUrl() {
		return homeUrl;
	}
	
	public Homepage()
	{
		
	}
	
	public void startHomepage(){
		super.iMyWd.getWd().get(homeUrl);
	}
}
