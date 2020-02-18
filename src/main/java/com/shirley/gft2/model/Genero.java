package com.shirley.gft2.model;

public enum Genero {
	
	SERTANEJO ("Sertanejo"),
	FORRÓ ("Forró"),
	SAMBA ("Samba"),
	PAGODE ("Pagode"),
	ROCK ("Rock"),
	AXE ("Axé");
	
	
	private String generoMusical;

	private Genero(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}



}
