package com.prudential.crawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prudential.crawler.service.CrawlerServiceInterface;

/*
 * App Controller Class
 * author: Arunava Paul
 */
@RestController
public class CrawlerAppController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerAppController.class);
	
	@Autowired
	private CrawlerServiceInterface crawlerService;

	/* The response time of the crawling operation is directly proportional to the no of pages
	 * we want to crawl. Keeping a default value of 10 so we can view the results quicker.
	 * author: Arunava Paul
	 */
	@RequestMapping(value = "/crawl", method = { RequestMethod.GET })
	public Object crawlUrl(@RequestParam(value = "URL") String URL,
			@RequestParam(value = "max", defaultValue = "10") int maxPages) throws Exception {
		
				
        if(!URL.startsWith("https://"))
        	URL="https://"+URL;
        
        LOGGER.info("Request Received. Domain "+URL+" Pages to be Crawled "+maxPages);
        
        return crawlerService.crawlService(URL, maxPages);
	}
}
