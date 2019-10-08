package com.springCaching.demo.service.impl;

import com.springCaching.demo.service.DataService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

  @Cacheable(cacheNames = "getDataCache", cacheManager = "defaultCacheManager")
  @Override
  public String getData() {
    this.slowOperation();
    return "This will be cached";
  }

  // method to simulate high execution time
  private void slowOperation() {
    try {
      Thread.sleep(4000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @CachePut(cacheNames = "getDataCache", cacheManager = "defaultCacheManager")
  @Override
  public String getDataWithCachePut() {
    this.slowOperation();
    return "This will be executed everytime";
  }

  @CacheEvict(cacheNames = "getDataCache", cacheManager = "defaultCacheManager", allEntries = true)
  @Override
  public void cacheEvict() {

  }
}
