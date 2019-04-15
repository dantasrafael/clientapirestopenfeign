package com.rafaeldantas.clientapirest.dao;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCEPClient extends ViaCEPClientBase {}
