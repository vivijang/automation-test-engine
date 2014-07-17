package org.bigtester.ate.model.page.page;

import org.bigtester.ate.model.page._PageModelBase;

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
