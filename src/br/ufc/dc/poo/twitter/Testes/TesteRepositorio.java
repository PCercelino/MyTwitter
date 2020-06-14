package br.ufc.dc.poo.twitter.Testes;
import br.ufc.dc.poo.twitter.perfil.*;
import br.ufc.dc.poo.twitter.*;

public class TesteRepositorio {

	public static void main(String[] args)   {
		
		Perfil usuario = new PessoaFisica("@PedroCercelino");
		Perfil usuario2 = new PessoaJuridica("@Empresa");
		long cpf = 616994313;
		((PessoaFisica) usuario).setCpf(cpf);
		((PessoaJuridica) usuario2).setCnpj(1234567890);
		
		Repositorio repositorio = new Repositorio();
		repositorio.buscar(usuario.getUsuario());
		
		MyTwitter meuTwitter = new MyTwitter(repositorio);
		meuTwitter.criarPerfil(usuario);
		meuTwitter.criarPerfil(usuario2);
		meuTwitter.seguir(usuario2.getUsuario(), usuario.getUsuario());
		meuTwitter.tweetar("@PedroCercelino", "Boa noite!");
		meuTwitter.tweetar("@PedroCercelino", "Rumo ao Hexa!");
		meuTwitter.tweetar("@PedroCercelino", "Mostra Tua Força Brasil");
		meuTwitter.tweetar("@PedroCercelino", "E amarra o amor na chuteira");
		
		for(int i = 0; i<meuTwitter.timeline(usuario2.getUsuario()).size(); ++i) {
			System.out.println(meuTwitter.timeline(usuario2.getUsuario()).get(i).getMensagem());
		}
		
		for(int i = 0; i<meuTwitter.seguidores(usuario.getUsuario()).size(); ++i) {
			System.out.println(meuTwitter.seguidores(usuario.getUsuario()).get(i).getUsuario());
		}
		
		
		for(int i = 0; i<meuTwitter.tweets(usuario.getUsuario()).size(); ++i) {
			System.out.println(meuTwitter.tweets(usuario.getUsuario()).get(i).getMensagem());
		}
		
		
		
	}

}
