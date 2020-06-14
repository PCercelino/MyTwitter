package br.ufc.dc.poo.twitter;
import br.ufc.dc.poo.twitter.perfil.*;
import java.util.Vector;

public interface ITwitter {

	public void criarPerfil(Perfil usuario);
	public void cancelarPerfil(String usuario);
	public void tweetar(String usuario, String mensagem);
	public Vector<Tweet> timeline(String usuario);
	public Vector<Tweet> tweets(String usuario);
	public int numeroSeguidores(String usuario);
	public Vector<Perfil> seguidores(String usuario);
	public Vector<Perfil> seguidos(String usuario);
	public void seguir(String seguidor, String seguido);
	
}
