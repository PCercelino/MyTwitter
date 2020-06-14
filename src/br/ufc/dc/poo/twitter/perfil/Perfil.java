package br.ufc.dc.poo.twitter.perfil;
import br.ufc.dc.poo.twitter.perfil.Tweet;


import java.util.Vector;

public abstract class Perfil {

	private String usuario;
	private Vector<Perfil> seguidos;
	private Vector<Perfil> seguidores;
	private Vector<Tweet> timeline;
	private boolean ativo;

	public Perfil(String usuario) {
		setUsuario(usuario);
		seguidos = new Vector<Perfil>();
		seguidores = new Vector<Perfil>();
		timeline = new Vector<Tweet>();
		ativo = true;
	}

	public void addSeguido(Perfil usuario) {
		seguidos.add(usuario);
	}

	public void addSeguidor(Perfil usuario) {
		seguidores.add(usuario);
	}

	public void addTweet(Tweet tweet) {
		timeline.add(tweet);
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public Vector<Perfil> getSeguidos() {
		return this.seguidos;
	}

	public Vector<Perfil> getSeguidores() {
		return this.seguidores;
	}

	public Vector<Tweet> getTimeline() {
		return this.timeline;
	}

	public void setAtivo(boolean valor) {
		this.ativo = valor;
	}

	public boolean isAtivo() {
		return this.ativo;
	}

}
