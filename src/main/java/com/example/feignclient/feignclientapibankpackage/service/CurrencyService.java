package com.example.feignclient.feignclientapibankpackage.service;

import com.example.feignclient.feignclientapibankpackage.model.entity.CurrencyEntity;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import java.util.Currency;
import java.util.List;

public interface CurrencyService {
  List<CurrencyEntity> saveAllCurrency(CurrencyListXmlFile currencyListXmlFile);
}
