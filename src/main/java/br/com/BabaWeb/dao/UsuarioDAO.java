package br.com.BabaWeb.dao;

import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.hibernate.Session;
import org.hibernate.query.Query;
import br.com.BabaWeb.connection.factory.DAOGenerico;
import br.com.BabaWeb.entity.Pelada;
import br.com.BabaWeb.entity.Usuario;
import br.com.BabaWeb.entity.Usuario_Pelada;
import br.com.BabaWeb.util.exceptions.ValidatorException;

public class UsuarioDAO extends DAOGenerico {

	public Usuario getUsuario(String login, String senha) throws Exception {
		Session session = getSession();

		try {
			Usuario usuario = null;
			// usuario = new Usuario();
			// CriteriaBuilder cb = session.getCriteriaBuilder();
			// CriteriaQuery<Usuario> q = cb.createQuery(Usuario.class);
			// Root<Usuario> c = q.from(Usuario.class);
			// q.select(c).where(cb.equal(c.get("dsEmail"), login));

			// TypedQuery<Usuario> query = session.createQuery(q);
			// List<Usuario> list = query.getResultList();
			String select = "from Usuario where ds_email= '" + login + "' and ds_senha= '" + senha + "'";
			Query<Usuario> query = session.createQuery(select);
			List<Usuario> list = query.getResultList();

			if (list.size() > 0) {
				usuario = list.get(0);
			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(e.getMessage());
		} finally {
			closeSession();
		}
	}

	public void addUsuario(Usuario novoUsuario) throws ValidatorException {
		Session session = getSession();

		try {
			session.beginTransaction();
			session.save(novoUsuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();

			throw e;
		} finally {
			closeSession();
		}

	}

	public void addPelada(Pelada novaPelada, Usuario usuarioLogado) throws ValidatorException {
		Session session = getSession();
		Usuario_Pelada up = new Usuario_Pelada();
		
		up.setCdUsuario(usuarioLogado.getCdUsuario());
		try {
			session.beginTransaction();
			session.save(novaPelada);
			up.setCdPelada(novaPelada.getCdPelada());
			session.save(up);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();

			throw e;
		} finally {
			closeSession();
		}

	}

}
