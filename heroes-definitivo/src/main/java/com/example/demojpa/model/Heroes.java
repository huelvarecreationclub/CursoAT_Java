package com.example.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "heroes")
public class Heroes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_heroes")
	private Integer id_heroe;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "estado")
    private String estado;


	public Integer getId_heroes() {
		return id_heroe;
	}

	public void setId_heroes(Integer id_heroes) {
		this.id_heroe = id_heroes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
