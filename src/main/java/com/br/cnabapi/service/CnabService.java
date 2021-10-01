package com.br.cnabapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.cnabapi.entity.Cnab;
import com.br.cnabapi.exceptions.ConverterException;
import com.br.cnabapi.util.UtilConverter;
import com.br.cnabapi.util.UtilFile;

@Service
public class CnabService {

	public void execute() {
		String textList = UtilFile.readFile();
		
		try {
			List<Cnab> cnabs = UtilConverter.converterStringToList(textList);			
		} catch (Exception e) {
			throw new ConverterException("Unable to read file: " + e.getMessage());
		}
	}
}
