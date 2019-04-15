package com.rafaeldantas.clientapirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.rafaeldantas.clientapirest.dao.ViaCEPClient;
import com.rafaeldantas.clientapirest.dao.ViaCEPClient2;
import com.rafaeldantas.clientapirest.dao.ViaCEPClientBase;
import com.rafaeldantas.clientapirest.model.Endereco;

import feign.FeignException;

@SpringBootApplication
@EnableFeignClients
public class ClientapirestApplication implements CommandLineRunner {

	@Autowired
	ViaCEPClient viaCEPCli;

	@Autowired
	ViaCEPClient2 viaCEPCli2;

	static final String cepCorreto = "88058560";
	static final String cepErrado = "880585601";

	public static void main(String[] args) {
		SpringApplication.run(ClientapirestApplication.class, args);
	}

	@Override
	public void run(String... args) {
		buscarResponsePor(viaCEPCli, cepCorreto);
		buscarResponsePor(viaCEPCli, cepErrado);
		buscarResponsePor(viaCEPCli2, cepCorreto);
		buscarResponsePor(viaCEPCli2, cepErrado);
	}

	private void buscarResponsePor(ViaCEPClientBase cliente, String cep) {
		System.out.println("===================== Iniciando busca =====================");

		try {
			ResponseEntity<Endereco> response = cliente.buscaEntidadePor(cep);

			if (response.getStatusCode().equals(HttpStatus.OK)) {
				System.out.println("   ReponseEntity: " + response);
				System.out.println("   Http Status Code: " + response.getStatusCodeValue());
				System.out.println("   Status Code: " + response.getStatusCode());
				System.out.println("   Header: " + response.getHeaders());
			} else {
				System.out.println("   Error code: " + response.getStatusCode() + ", headers: " + response.getHeaders());
			}
		} catch (FeignException e) {
			System.out.println("   FeignException = " + e);
		} catch (HttpClientErrorException e) {
			System.out.println("   HttpClientErrorException = " + e);
		} catch (HttpServerErrorException e) {
			System.out.println("   HttpServerErrorException = " + e);
		} catch (Exception e) {
			System.out.println("   Exception = " + e);
		}

		System.out.println("=====================  Fim da busca   =====================\n");
	}

}
