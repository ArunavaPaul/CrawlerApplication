# CrawlerApplication

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Simple Springboot Web Crawler Application 
 
 Libraries Used:-
  - Springboot 2.0
  - Crawler4j


# Pre-requisites

  - JDK 1.8
  - Maven

# Quickstart
Option 1
1. Download project.
2. Create Jar (Command - mvn install).
3. Run Jar created in Target Folder (Command - java -jar crawler-0.0.1-SNAPSHOT.jar)

Option 2
1. Download project.
2. Import as Maven project in local IDE.
3. Run CrawlerApplication.java

# Application
Application starts on localhost:6000.
This application can crawl any domain URL which is send as a query parameter (URL).
Ex:- localhost:6000/crawl?URL=www.volvo.com/home.html 
Since crawling of any popular domains is a time intensive process so for brevity an optional second query parameter (max) is also provided. This is the maximum no of pages to retrieved/crawled from the domain URL.
If max is not sent explicitly it will take the default value of 10.
Ex:- localhost:6000/crawl?URL=www.volvo.com/home.html&max=30