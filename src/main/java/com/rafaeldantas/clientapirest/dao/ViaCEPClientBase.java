package com.rafaeldantas.clientapirest.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rafaeldantas.clientapirest.model.Endereco;

public interface ViaCEPClientBase {

	@GetMapping("{cep}/json")
	Endereco buscaEnderecoPor(@PathVariable("cep") String cep);

	@GetMapping("{cep}/json")
	ResponseEntity<Endereco> buscaEntidadePor(@PathVariable("cep") String cep);

}
