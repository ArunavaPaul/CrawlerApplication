package com.prudential.crawler.factory;

import org.springframework.stereotype.Component;

import edu.uci.ics.crawler4j.crawler.CrawlController;

/*
 * Crawler Factory Class
 * author: Arunava Paul
 */
@Component
public class CrawlerFactory implements CrawlController.WebCrawlerFactory<AppWebCrawler> {

	@Override
	public AppWebCrawler newInstance() throws Exception {
		return new AppWebCrawler();
	}
	

	
}
