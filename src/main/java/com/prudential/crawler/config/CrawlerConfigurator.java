package com.prudential.crawler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;

/*
 * Crawler Configurator Class
 * This class is responsible for supplying the configuration for the Crawler
 * author: Arunava Paul
 */
@Configuration
public class CrawlerConfigurator {

	@Value("${com.prudential.staticFolderLocation}")
	private String rootFolder;

	@Bean(name = "CrawlerConfig")
	public CrawlConfig crawlConfig() {
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(rootFolder);
		config.setPolitenessDelay(1000);

		return config;
	}

}
