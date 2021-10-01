package com.br.cnabapi.util;

import java.util.ArrayList;
import java.util.List;

import com.br.cnabapi.entity.Cnab;

public class UtilConverter {

	public static List<Cnab> converterStringToList(String text) {
		String[] list = text.split("\n");
		
		List<Cnab> cnabs = new ArrayList<Cnab>(); 
		
		for(String s: list) {
			Cnab cnab = Cnab.builder()
					.tipo(s.substring(0, 1))
					.data(s.substring(2, 9))
					.valor(Double.parseDouble(s.substring(10, 19)) / 100.00)
					.cpf(s.substring(20, 30))
					.cartao(s.substring(31, 42))
					.hora(s.substring(43, 48))
					.donaDaLoja(s.substring(49, 62))
					.nomeLoja(s.substring(63, 80))
					.build();
			
			cnabs.add(cnab);
		}
		
		return cnabs;
	}
}
