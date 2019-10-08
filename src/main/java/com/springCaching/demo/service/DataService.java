package com.springCaching.demo.service;

public interface DataService {

  String getData();

  String getDataWithCachePut();

  void cacheEvict();
}
