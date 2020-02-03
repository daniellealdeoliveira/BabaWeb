package br.com.BabaWeb.managed.bean;


import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;


import br.com.BabaWeb.bo.UsuarioBO;
import br.com.BabaWeb.entity.Pelada;
import br.com.BabaWeb.entity.Usuario;


@ManagedBean
@SessionScoped
public class LoginView implements Serializable {

	private String password;
	private String email;
	
	private Pelada novaPelada = new Pelada();
	private Usuario novoUsuario = new Usuario();
	private Usuario novoAmigo = new Usuario();
	private String novoEmail;
	private String novaSenha;

	private Usuario usuarioLogado;

	@PostConstruct
	public void init() {
		try {
			if (!FacesContext.getCurrentInstance().isPostback()) {
				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
						.getRequest();
				if (request.getParameter("action") != null) {
					if (request.getParameter("action").trim().toLowerCase().equals("logout")) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:",
								"Logout efetuado com sucesso!");
						FacesContext.getCurrentInstance().addMessage(null, message);
						FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
					} else if (request.getParameter("action").trim().toLowerCase().equals("login")) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta:",
								"Para acessar essa tela é necessário estar logado no sistema.");
						FacesContext.getCurrentInstance().addMessage(null, message);
						FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
					} else if (request.getParameter("action").trim().toLowerCase().equals("permissao")) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta:",
								"Seu usuário não tem permissão de acessar esse módulo. Favor entrar em contato com o administrador do sistema.");
						FacesContext.getCurrentInstance().addMessage(null, message);
						FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
					}
				}
			}
		} catch (Exception ex) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção:",
					"Erro. " + ex.getLocalizedMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login(ActionEvent event) {
		String pageLogin = null;
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;

		try {

			usuarioLogado = (new UsuarioBO()).login(email, password);

			pageLogin = "dashboard?faces-redirect=true";

		} catch (Exception ex) {

			usuarioLogado = null;
			pageLogin = null;
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção", ex.getMessage());
			FacesContext.getCurrentInstance().addMessage("growl", message);
		} finally {

			return pageLogin;
		}

	}
	
	public void cadastrar(ActionEvent event) {
		boolean salvo = false;
		try {
		new UsuarioBO().addUsuario(novoUsuario);
		} catch (Exception ex) {
            salvo = false;
        }
	}
	
	public void convidar(ActionEvent event) {
		boolean salvo = false;
		try {
		new UsuarioBO().addUsuario(novoAmigo);
		} catch (Exception ex) {
            salvo = false;
        }
	}
	
	public void cadastrarPelada(ActionEvent event) {
		boolean salvo = false;
		try {
		new UsuarioBO().addPelada(novaPelada, usuarioLogado);
		} catch (Exception ex) {
            salvo = false;
        }
	}

	public void redirectLogin() throws IOException {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException ex) {
			Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(String novoEmail) {
		this.novoEmail = novoEmail;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public Usuario getNovoAmigo() {
		return novoAmigo;
	}

	public void setNovoAmigo(Usuario novoAmigo) {
		this.novoAmigo = novoAmigo;
	}

	public Pelada getNovaPelada() {
		return novaPelada;
	}

	public void setNovaPelada(Pelada novaPelada) {
		this.novaPelada = novaPelada;
	}
	

}
