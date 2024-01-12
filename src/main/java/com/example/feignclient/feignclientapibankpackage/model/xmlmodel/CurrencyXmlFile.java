package com.example.feignclient.feignclientapibankpackage.model.xmlmodel;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.ToString;

@XmlRootElement(name = "Valute")
@Getter
@ToString
public class CurrencyXmlFile {

  @XmlElement(name = "Name")
  private String name;

  @XmlElement(name = "Value")
  private String value;

  @XmlElement(name = "NumCode")
  private String numCode;

  @XmlElement(name = "CharCode")
  private String charCode;

  @XmlElement(name = "Nominal")
  private String nominal;
}
