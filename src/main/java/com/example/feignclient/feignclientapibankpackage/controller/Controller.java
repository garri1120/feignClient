package com.example.feignclient.feignclientapibankpackage.controller;

import com.example.feignclient.feignclientapibankpackage.interfacefeignclient.FeignClientApiBank;
import com.example.feignclient.feignclientapibankpackage.interfacefeignclient.FeignClientSecondApiSaveAllCurrency;
import com.example.feignclient.feignclientapibankpackage.model.entity.CurrencyEntity;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import com.example.feignclient.feignclientapibankpackage.service.CurrencyService;
import com.example.feignclient.feignclientapibankpackage.service.ParserService;
import jakarta.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

  private final FeignClientApiBank feignClientApiBank;

  private final FeignClientSecondApiSaveAllCurrency feignClientSecondApiSaveAllCurrency;

  private final ParserService parserService;

  private final CurrencyService currencyService;
  // Запрос в ЦБ РФ на получение курса валют на заданную дату
  @GetMapping("/cbr")
  public ResponseEntity<List<CurrencyEntity>> getAllRatesController(@RequestParam("date_req") String date)
      throws JAXBException {

    ResponseEntity<String> response = feignClientApiBank.getAllRates(date);

    if (response.getStatusCode() == HttpStatus.OK) {
      CurrencyListXmlFile currencyListXmlFile = parserService.getAllCurrency(response.getBody());
      return feignClientSecondApiSaveAllCurrency.saveAllCurrency(currencyListXmlFile);
    }
    return ResponseEntity.ok(new ArrayList<>());
  }

  // Сохранение всех валют в БД
  @PostMapping("/save-all-currency")
  public ResponseEntity<List<CurrencyEntity>> saveAllCurrency(@RequestBody CurrencyListXmlFile currencyListXmlFile) {
    return ResponseEntity.ok(currencyService.saveAllCurrency(currencyListXmlFile));
  }
}
