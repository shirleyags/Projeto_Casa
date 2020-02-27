package com.shirley.gft2.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class CasaShow extends AbstractEntity<Long> {
	
	
	
	
	@NotEmpty(message = "O nome da casa de show é obrigatório.")
	@Size(max = 60, message = "A descrição não pode conter mais de 60 caracteres.")
	private String casa;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "casaShow")
	private  List<Eventos> listaEventos; 
	
	public List<Eventos> getListaEventos() {
		return listaEventos;
	}
	public void setListaEventos(List<Eventos> listaEventos) {
		this.listaEventos = listaEventos;
	}
	@NotEmpty(message = "O logradouro é obrigatório.")
	@Size(max = 60, message = "O logradouro não pode conter mais de 60 caracteres.")
	private String logradouro;
	
	@NotEmpty(message = "A cidade é obrigatória.")
	@Size(max = 60, message = "O logradouro não pode conter mais de 60 caracteres.")
	private String cidade;
	
	@NotEmpty(message = "A abreviação do estado é obrigatória.")
	@Size(max = 3, message = "A abreviação não pode conter mais de 3 caracteres.")
	private String estado;


		

	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	

}
