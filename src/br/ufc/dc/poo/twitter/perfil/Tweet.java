package br.ufc.dc.poo.twitter.perfil;

public class Tweet {

	private String usuario;
	private String mensagem;

	public Tweet() {
		usuario = null;
		mensagem = null;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
