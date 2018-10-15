package com.prudential.crawler.service;

import org.springframework.stereotype.Service;

@Service
public interface CrawlerServiceInterface {

	Object crawlService(String URL, int max) throws Exception;

}
