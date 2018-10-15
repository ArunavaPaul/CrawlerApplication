package com.prudential.crawler.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prudential.crawler.factory.CrawlerFactory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/*
 * Crawler Service Class
 * This class is responsible for Crawling the URL
 * author: Arunava Paul
 */
@Component
public class CrawlerService implements CrawlerServiceInterface {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerService.class);

	private final CrawlConfig config;

	@Autowired
	CrawlerFactory crawlerFactory;

	@Autowired
	public CrawlerService(@Qualifier(value = "CrawlerConfig") CrawlConfig config) {
		this.config = config;
	}

	@Value("${com.prudential.noOfCrawlers}")
	private int numberOfCrawlers;

	@Override
	public Object crawlService(String URL, int max) throws Exception {
		
		LOGGER.info("In Service Class");
		
		this.config.setMaxPagesToFetch(max);

		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

		controller.addSeed(URL);
		controller.start(crawlerFactory, numberOfCrawlers);

		List<Object> crawlersLocalData = controller.getCrawlersLocalData();
        
		LOGGER.info("End of Service Class");
		return crawlersLocalData;

	}

}
