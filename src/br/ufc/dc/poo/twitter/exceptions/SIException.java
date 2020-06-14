package br.ufc.dc.poo.twitter.exceptions;

import br.ufc.dc.poo.twitter.perfil.Perfil;

public class SIException extends Exception{

	private static final long serialVersionUID = 1L;
	private Perfil usuario;

	public SIException(Perfil usuario) {
		super("Seguidor Inválido!");
	}

	public Perfil getUsuario(Perfil usuario) {
		return this.usuario;
	}
}
