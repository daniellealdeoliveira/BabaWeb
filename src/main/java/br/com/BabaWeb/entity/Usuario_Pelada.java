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
@Table(name = "usuario_pelada")
public class Usuario_Pelada implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_usuario_pelada")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="usuario_id_seq")
	private int cdUsuarioPelada;
    
    
	@Column(name = "cd_pelada")
	private int cdPelada;
	
	@Column(name = "cd_usuario")
	private int cdUsuario;

	public int getCdPelada() {
		return cdPelada;
	}

	public void setCdPelada(int cdPelada) {
		this.cdPelada = cdPelada;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public int getCdUsuarioPelada() {
		return cdUsuarioPelada;
	}

	public void setCdUsuarioPelada(int cdUsuarioPelada) {
		this.cdUsuarioPelada = cdUsuarioPelada;
	}
	
	

}
