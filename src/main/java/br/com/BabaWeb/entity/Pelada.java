package br.com.BabaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pelada")
public class Pelada implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_pelada")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="usuario_id_seq")
	private int cdPelada;

	@Column(name = "nm_pelada")
	private String nome;

	
	@Column(name = "dt_pelada")
	private String data;

	@Column(name = "ds_local")
	private String local;

	@ManyToMany(mappedBy = "pelada")
	private List<Usuario> usuario;

	public Pelada() {

	}

	public int getCdPelada() {
		return cdPelada;
	}

	public void setCdPelada(int cdPelada) {
		this.cdPelada = cdPelada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}
