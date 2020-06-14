package br.ufc.dc.poo.twitter.exceptions;

public class MFPException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;

	public MFPException(String mensagem) {
		super("Mensagem fora do padrão!");
	}
	
	public String getMensagem(String mensagem) {
		return this.mensagem;
	}

}
