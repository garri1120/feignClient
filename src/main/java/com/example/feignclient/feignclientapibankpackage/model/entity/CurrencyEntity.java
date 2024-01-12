package com.example.feignclient.feignclientapibankpackage.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currency")
public class CurrencyEntity {

  @Id
  @Column(name = "num_code", length = 3, nullable = false)
  private Integer numCode;

  @Column(name = "full_currency_name", nullable = false)
  private String name;

  @Column(name ="value", nullable = false)
  private BigDecimal value;

  @Column(name = "char_code", nullable = false)
  private String charCode;

  @Column(name = "nominal", nullable = false)
  private String nominal;
}