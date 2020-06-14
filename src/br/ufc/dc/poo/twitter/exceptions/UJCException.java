package br.ufc.dc.poo.twitter.exceptions;

import br.ufc.dc.poo.twitter.perfil.Perfil;

public class UJCException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private Perfil usuario;
	
	public UJCException(Perfil usuario) {
		super("Usuário " +  usuario.getUsuario() + " já cadastrado!");
		this.usuario = usuario;
	}
	
	public Perfil getUsuario() {
		return this.usuario;
	}
}
