package org.bigtester.AutomationTestEngine.PageModel.Page;

import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;

public class Homepage extends _PageModelBase{
	
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
