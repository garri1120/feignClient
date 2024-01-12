package com.example.feignclient.feignclientapibankpackage.interfacefeignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cbr-request")
public interface FeignClientApiBank {
    @GetMapping
    ResponseEntity<String> getAllRates(@RequestParam("date_req") String date);
}
