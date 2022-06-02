package com.qriculum.qriculum.models;

import java.util.List;

public class Cv{

	private String sobreMi;
	
	private List<Educacion> educacion;
	
	private List<ExpLaboral> expLaboral;
	
	private List<Idioma> idiomas;
	
	private List<String> conocimientos;
	
	private List<Certificado> certificados;
	
	private List<Red> redes;

	public String getSobreMi() {
		return sobreMi;
	}

	public void setSobreMi(String sobreMi) {
		this.sobreMi = sobreMi;
	}

	public List<Educacion> getEducacion() {
		return educacion;
	}

	public void setEducacion(List<Educacion> educacion) {
		this.educacion = educacion;
	}

	public List<ExpLaboral> getExpLaboral() {
		return expLaboral;
	}

	public void setExpLaboral(List<ExpLaboral> expLaboral) {
		this.expLaboral = expLaboral;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public List<String> getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(List<String> conocimientos) {
		this.conocimientos = conocimientos;
	}

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public List<Red> getRedes() {
		return redes;
	}

	public void setRedes(List<Red> redes) {
		this.redes = redes;
	}
	
	
}
