package br.com.BabaWeb.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 	@Id
	    @Column(name = "cd_usuario")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="usuario_id_seq")
	    private int cdUsuario;
	 
	    @Column(name = "nm_usuario")
	    private String nome;
	    
	    @Column(name = "ds_apelido")
	    private String apelido;
	    
	    @Column(name = "ds_email")
	    private String email;
	    
	    @Column(name = "ds_senha")
	    private String senha;
	    
	    @ManyToMany
	    @JoinTable(name="usuario_pelada", joinColumns=
	    {@JoinColumn(name="cd_usuario")}, inverseJoinColumns=
	      {@JoinColumn(name="cd_pelada")})
	    private List<Pelada> pelada;
	    
	    public Usuario() {
	    	
	    }

		public int getCdUsuario() {
			return cdUsuario;
		}

		public void setCdUsuario(int cdUsuario) {
			this.cdUsuario = cdUsuario;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getApelido() {
			return apelido;
		}

		public void setApelido(String apelido) {
			this.apelido = apelido;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<Pelada> getPelada() {
			return pelada;
		}

		public void setPelada(List<Pelada> pelada) {
			this.pelada = pelada;
		}

		
	    

}
