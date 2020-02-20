package com.shirley.gft2.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@SuppressWarnings("serial")
public class Eventos extends AbstractEntity<Long> {

	
	@NotEmpty(message="O nome do evento é obrigatório.")
	@Size(max=60, message="A casa não pdoe ter mais que 60 caracteres.")
	private String evento;
	
	
	
	@NotNull(message="O preenchimento da capacidade é obrigatório.")
	@DecimalMin(value="1", message="O capacidade não pode ser menor que 1")
	@DecimalMax(value="9999999", message="O valor não pode ser maior que 9.999.999")
	private Integer capacidade;

	
	@NotNull(message="A data é obrigatória.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;

	
	
	

	@NotNull(message="O preenchimento do valor é obrigatório.")
	@NumberFormat(pattern = "#,##0.00")
	@DecimalMin(value="0.01", message="O valor não pode ser menor que 0,01")
	@DecimalMax(value="9999999.99", message="O valor não pode ser maior que R$ 9.999.999,99")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "id_casadeshow_fk")
	private CasaShow casaShow;

	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	
	
	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CasaShow getCasaShow() {
		return casaShow;
	}

	public void setCasaShow(CasaShow casaShow) {
		this.casaShow = casaShow;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
	
	
	
	

}




