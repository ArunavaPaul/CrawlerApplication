package com.prudential.crawler.factory;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/*
 * Main Crawler Class
 * This class is responsible for maintaining all the rules the Crawler has to follow.
 * author: Arunava Paul
 */

public class AppWebCrawler extends WebCrawler {
	private static final Pattern FILTERS = Pattern
			.compile(".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf"
					+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	CrawlerData crawlerData;

	public AppWebCrawler() {
		crawlerData = new CrawlerData();
	}

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches() && !href.contains("google") && !href.contains("twitter");
	}

	@Override
	public void visit(Page page) {
		logger.info("Visited: {}", page.getWebURL().getURL());

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData parseData = (HtmlParseData) page.getParseData();
			Set<WebURL> links = parseData.getOutgoingUrls();
			Set<String> paths = new TreeSet<String>();
			links.forEach(l -> {
				paths.add(page.getWebURL().getURL() + l.getPath());
			});
			crawlerData.setUrlList(page.getWebURL().getURL(), paths);
		}

	}

	/**
	 * This function is called by controller to get the local data of this crawler
	 * when job is finished
	 */
	@Override
	public Object getMyLocalData() {
		return crawlerData;
	}

	/**
	 * This function is called by controller before finishing the job. You can put
	 * whatever stuff you need here.
	 */
	@Override
	public void onBeforeExit() {

	}

}
