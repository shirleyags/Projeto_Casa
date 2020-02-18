package com.shirley.gft2.controler.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.shirley.gft2.model.CasaShow;
import com.shirley.gft2.repository.CasaCadastros;

@Component
public class StringToCasaConverter implements Converter <String, CasaShow> {

	@Autowired
	private CasaCadastros casasDeShowCadastradas;
	
	@Override
	public CasaShow convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long code =Long.valueOf(text);
		
		return casasDeShowCadastradas.getOne(code);
	}
	
	
	
	
	
	
	
	
	
	

}
