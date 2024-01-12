package com.example.feignclient.feignclientapibankpackage.service;
import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import jakarta.xml.bind.JAXBException;

public interface ParserService {
  CurrencyListXmlFile getAllCurrency(String stringXmlFile) throws JAXBException;

}
