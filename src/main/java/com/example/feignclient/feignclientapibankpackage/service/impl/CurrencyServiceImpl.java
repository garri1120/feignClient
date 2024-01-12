package com.example.feignclient.feignclientapibankpackage.service.impl;

import com.example.feignclient.feignclientapibankpackage.mapper.CurrencyMapper;
import com.example.feignclient.feignclientapibankpackage.model.entity.CurrencyEntity;
import com.example.feignclient.feignclientapibankpackage.model.repository.CurrencyRepository;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import com.example.feignclient.feignclientapibankpackage.service.CurrencyService;
import java.util.Currency;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

  private final CurrencyRepository currencyRepository;
  @Override
  @Transactional
  public List<CurrencyEntity> saveAllCurrency(CurrencyListXmlFile currencyListXmlFile) {
    log.info("Запрос на сохранение всех валют из ЦБ РФ");
    List<CurrencyEntity> currencyEntities = CurrencyMapper.mapperCurrencyEntityList(
        currencyListXmlFile);
    currencyRepository.saveAll(currencyEntities);
    log.info("Валюты из ЦБ РФ успешно сохранены в БД");
    return currencyEntities;
  }
}
