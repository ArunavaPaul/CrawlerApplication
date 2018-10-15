package com.prudential.crawler.factory;

import java.util.HashMap;
import java.util.Set;

/*
 * Crawler Data Storage/Collector Class
 * author: Arunava Paul
 */
public class CrawlerData {
	private HashMap<String,Set<String>> urlList;

	public CrawlerData() {
		urlList = new HashMap<>();
	}

	public HashMap<String, Set<String>> getUrlList() {
		return urlList;
	}

	public void setUrlList(String key, Set<String> paths) {
		this.urlList.put(key, paths);
	}
	
	
	
	
	
	

}
