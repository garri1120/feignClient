package com.example.feignclient.feignclientapibankpackage.model.repository;

import com.example.feignclient.feignclientapibankpackage.model.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

}
