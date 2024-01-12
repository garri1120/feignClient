package com.example.feignclient.feignclientapibankpackage.model.xmlmodel;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@XmlRootElement(name = "ValCurs")
public class CurrencyListXmlFile {

  @XmlElement(name = "Valute")
  private List<CurrencyXmlFile> currencies;
}
