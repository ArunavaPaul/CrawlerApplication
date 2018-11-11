package com.prudential.crawler.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import com.prudential.crawler.controller.CrawlerAppController;
import com.prudential.crawler.service.CrawlerServiceInterface;

@RunWith(PowerMockRunner.class)
public class CrawlerAppControllerTest {
	
	Object obj=new Object();
	
	@Mock
	private CrawlerServiceInterface crawlerService; 
	
	@InjectMocks
	CrawlerAppController appController = new CrawlerAppController();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
		
	
	@Test
	public void testController() throws Exception {
		
		when(crawlerService.crawlService("https://vogella.com", 20)).thenReturn(obj);
		
		assertEquals(appController.crawlUrl("vogella.com",20), obj);
		
	}
	
	@Test(expected = Exception.class)
	public void testController2() throws Exception {
		when(crawlerService.crawlService("https://xyz.com", 20)).thenThrow(new Exception());
		
		appController.crawlUrl("xyz.com",20);
	}
	
	@Test
    public void testController3() throws Exception {
		
		when(crawlerService.crawlService("https://volla.com", 20)).thenReturn(obj);
		
		assertEquals(appController.crawlUrl("https://volla.com",20), obj);
		
	}

}
