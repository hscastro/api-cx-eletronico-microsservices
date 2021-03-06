package com.hscastro.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hscastro.entities.Cliente;
import com.hscastro.services.ClienteService;

@Component
public class StringToConverterCliente implements Converter<String, Cliente> {

	@Autowired
	private ClienteService service;
	
	
	@Override
	public Cliente convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}

}