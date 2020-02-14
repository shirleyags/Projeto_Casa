package com.shirley.gft2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shirley.gft2.model.CasaShow;

public interface CasaCadastros extends  JpaRepository <CasaShow, Long> {
	
	public List<CasaShow> findByCasaContaining (String casa); // Para fazer a busca.

}


