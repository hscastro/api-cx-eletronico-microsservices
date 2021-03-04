package com.hscastro.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CaixaEletronicoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaEletronicoWebApplication.class, args);
	}

}
