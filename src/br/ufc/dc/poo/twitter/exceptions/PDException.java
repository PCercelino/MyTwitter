package br.ufc.dc.poo.twitter.exceptions;

import br.ufc.dc.poo.twitter.perfil.Perfil;

public class PDException extends Exception{

	private static final long serialVersionUID = 1L;
	private Perfil usuario;

	public PDException(Perfil usuario) {
		super("Usuário " + usuario.getUsuario() + " está desativado!");
	}
	
	public Perfil getUsuario(Perfil usuario) {
		return this.usuario;
	}

}
