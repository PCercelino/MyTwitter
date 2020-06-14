package br.ufc.dc.poo.twitter.exceptions;

import br.ufc.dc.poo.twitter.perfil.Perfil;

public class PEException extends Exception{

	private static final long serialVersionUID = 1L;
	private Perfil usuario;

	public PEException(Perfil usuario) {
		super("Perfil " + usuario.getUsuario() + " já existente!");
	}
	
	public Perfil getUsuario(Perfil usuario) {
		return this.usuario;
	}

}
