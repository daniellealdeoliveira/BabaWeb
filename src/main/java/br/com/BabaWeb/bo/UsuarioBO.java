package br.com.BabaWeb.bo;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.BabaWeb.dao.UsuarioDAO;
import br.com.BabaWeb.entity.Pelada;
import br.com.BabaWeb.entity.Usuario;
import br.com.BabaWeb.util.exceptions.ValidatorException;

public class UsuarioBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario login(String login, String senha) throws Exception {
		Usuario usuario = (new UsuarioDAO()).getUsuario(login, senha);

		if (usuario == null) {
			throw new ValidatorException("Email ou senha não confere.");
		}

		return usuario;
	}

	public void addUsuario(Usuario novoUsuario) throws ValidatorException {
		
		UsuarioDAO obj = new UsuarioDAO();
		obj.addUsuario(novoUsuario);
		
	}
public void addPelada(Pelada novaPelada, Usuario novoUsuario) throws ValidatorException {
		
		UsuarioDAO obj = new UsuarioDAO();
		obj.addPelada(novaPelada, novoUsuario);
	}

}
