package com.rafaeldantas.clientapirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import com.rafaeldantas.clientapirest.dao.ViaCEPClient;
import com.rafaeldantas.clientapirest.model.Endereco;

@SpringBootApplication
@EnableFeignClients
public class ClientapirestApplication implements CommandLineRunner {

	@Autowired
	ViaCEPClient viaCEPCli;

	public static void main(String[] args) {
		SpringApplication.run(ClientapirestApplication.class, args);
	}

	@Override
	public void run(String... args) {
			String cep = "88058560";
			Endereco endereco = viaCEPCli.buscaEnderecoPor(cep);
			ResponseEntity<Endereco> entidade = viaCEPCli.buscaEntidadePor(cep);
			System.out.println("Objeto endereço: " + endereco);
			System.out.println("ReponseEntity: " + entidade);
			System.out.println("Http Status Code: " + entidade.getStatusCodeValue());
			System.out.println("Status Code: " + entidade.getStatusCode());			
			System.out.println("Header: " + entidade.getHeaders());
	}

}
