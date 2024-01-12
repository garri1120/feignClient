package com.example.feignclient.feignclientapibankpackage.interfacefeignclient;

import com.example.feignclient.feignclientapibankpackage.model.entity.CurrencyEntity;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "second-request")
public interface FeignClientSecondApiSaveAllCurrency {

  @PostMapping
  ResponseEntity<List<CurrencyEntity>> saveAllCurrency(@RequestBody CurrencyListXmlFile currencyListXmlFile);
}
