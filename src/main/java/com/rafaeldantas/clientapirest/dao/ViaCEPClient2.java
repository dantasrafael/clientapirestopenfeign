package com.rafaeldantas.clientapirest.dao;

import org.springframework.cloud.openfeign.FeignClient;

import com.rafaeldantas.clientapirest.config.ClientErrorDecoder;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep2", configuration = ClientErrorDecoder.class)
public interface ViaCEPClient2 extends ViaCEPClientBase {}
