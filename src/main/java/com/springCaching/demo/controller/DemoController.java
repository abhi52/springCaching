package com.springCaching.demo.controller;

import com.springCaching.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

  private final DataService dataService;

  @Autowired
  public DemoController(DataService dataService) {
    this.dataService = dataService;
  }

  @GetMapping("/data")
  public String getData() {
    return dataService.getData();
  }

  @GetMapping("/data/refresh")
  public String getDataWithCachePut() {
    return dataService.getDataWithCachePut();
  }

  @GetMapping("/data/evict")
  public void evictCache() {
    dataService.cacheEvict();
  }
}
