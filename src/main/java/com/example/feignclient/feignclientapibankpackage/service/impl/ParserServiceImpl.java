package com.example.feignclient.feignclientapibankpackage.service.impl;

import com.example.feignclient.feignclientapibankpackage.model.xmlmodel.CurrencyListXmlFile;
import com.example.feignclient.feignclientapibankpackage.service.ParserService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;
import org.springframework.stereotype.Service;

@Service
public class ParserServiceImpl implements ParserService {

  @Override
  public CurrencyListXmlFile getAllCurrency(String stringXmlFile) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyListXmlFile.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    return (CurrencyListXmlFile) unmarshaller.unmarshal(
        new StreamSource(new StringReader(stringXmlFile)));
  }
}
