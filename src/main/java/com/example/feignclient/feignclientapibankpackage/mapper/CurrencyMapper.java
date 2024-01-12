package com.example.feignclient.feignclientapibankpackage.mapper;

import com.example.feignclient.feignclientapibankpackage.model.entity.CurrencyEntity;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyXmlFile;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrencyMapper {

  public static List<CurrencyEntity> mapperCurrencyEntityList(
      CurrencyListXmlFile currencyListXmlFile) {
    return currencyListXmlFile.getCurrencies().stream().map(CurrencyMapper::mapperCurrencyEntity).toList();
  }

  public static CurrencyEntity mapperCurrencyEntity(CurrencyXmlFile currencyXmlFile) {
    return CurrencyEntity
        .builder()
        .numCode(Integer.valueOf(currencyXmlFile.getNumCode()))
        .charCode(currencyXmlFile.getCharCode())
        .name(currencyXmlFile.getName())
        .nominal(currencyXmlFile.getNominal())
        .value(new BigDecimal(currencyXmlFile.getValue().replace(",",".")))
        .build();
  }
}
