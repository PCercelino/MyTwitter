package br.ufc.dc.poo.twitter.exceptions;

import br.ufc.dc.poo.twitter.perfil.Perfil;

public class UNCException extends Exception{

	private static final long serialVersionUID = 1L;
	private Perfil usuario;

	public UNCException(Perfil usuario) {
		super("Usuário não cadastrado!"); 
	}
	
	public Perfil getUsuario(Perfil usuario) {
		return this.usuario;
	}
}
