package com.regis.responseentity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Campanha {

	@Id
	private long id;

	private String descricaocampanha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricaocampanha() {
		return descricaocampanha;
	}

	public void setDescricaocampanha(String descricaocampanha) {
		this.descricaocampanha = descricaocampanha;
	}

	@Override
	public String toString() {
		return "Campanha [id=" + id + ", descricaocampanha=" + descricaocampanha + "]";
	}

}