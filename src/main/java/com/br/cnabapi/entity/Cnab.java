package com.br.cnabapi.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cnab {
	
	private String tipo;
	private String data;
	private Double valor;
	private String cpf;
	private String cartao;
	private String hora;
	private String donaDaLoja;
	private String nomeLoja;

}
