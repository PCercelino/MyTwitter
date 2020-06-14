package br.ufc.dc.poo.twitter.exceptions;

import br.ufc.dc.poo.twitter.perfil.Perfil;

public class PIException extends Exception{

	private static final long serialVersionUID = 1L;
	private Perfil usuario;

	public PIException(Perfil usuario) {
		super("Usuário inexistente!");
		this.usuario = usuario;
	}
	
	public Perfil getUsuario(Perfil usuario) {
		return this.usuario;
	}

}
