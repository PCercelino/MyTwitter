package br.ufc.dc.poo.twitter;

import br.ufc.dc.poo.twitter.perfil.*;
import java.util.Vector;
import br.ufc.dc.poo.twitter.exceptions.PIException;
import br.ufc.dc.poo.twitter.exceptions.PDException;
import br.ufc.dc.poo.twitter.exceptions.SIException;
import br.ufc.dc.poo.twitter.exceptions.MFPException;
import br.ufc.dc.poo.twitter.exceptions.PEException;

public class MyTwitter implements ITwitter {

	IRepositorioUsuario Repositorio;

	public MyTwitter(IRepositorioUsuario repositorio) {
		this.Repositorio = repositorio;
	}

	public void criarPerfil(Perfil usuario) {
		Perfil perfilAux = Repositorio.buscar(usuario.getUsuario());
		if (perfilAux == null) {
			Repositorio.cadastrar(usuario);
		} else {
			try {
				throw new PEException(usuario);
			} catch (PEException e) {
				e.printStackTrace();
			}
		}
	}

	public void cancelarPerfil(String usuario) {
		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		if (perfilAuxiliar != null && perfilAuxiliar.isAtivo() == true) {
			perfilAuxiliar.setAtivo(false);
			Repositorio.atualizar(perfilAuxiliar);
		} else if (perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException e) {
				e.printStackTrace();
			}
		}
	}

	public void tweetar(String usuario, String mensagem) {
		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		if (perfilAuxiliar != null && perfilAuxiliar.isAtivo() == true) {
			if (1 <= mensagem.length() && mensagem.length() <= 140) {
				Tweet tweet = new Tweet();
				tweet.setUsuario(usuario);
				tweet.setMensagem(mensagem);
				perfilAuxiliar.addTweet(tweet);
				Vector<Perfil> vectorSeguidores = perfilAuxiliar.getSeguidores();
				for (int i = 0; i < vectorSeguidores.size(); ++i) {
					vectorSeguidores.get(i).addTweet(tweet);
				}
				Repositorio.atualizar(perfilAuxiliar);
			} else if (0 > mensagem.length() || mensagem.length() > 140) {
				try {
					throw new MFPException(mensagem);
				} catch (MFPException mfp) {
					mfp.printStackTrace();
				}
			}
		} else if(perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException pi) {
				pi.printStackTrace();
			}
		} else if(perfilAuxiliar.isAtivo() == false) {
			try {
				throw new PDException(perfilAuxiliar);
			} catch(PDException pd) {
				pd.printStackTrace();
			}
		}
	}

	public Vector<Tweet> timeline(String usuario) {

		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		if (perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException pi) {
				pi.printStackTrace();
			}
		} else if (perfilAuxiliar.isAtivo() == false) {
			try {
				throw new PDException(perfilAuxiliar);
			} catch (PDException pd) {
				pd.printStackTrace();
			}
		}
		return perfilAuxiliar.getTimeline();
	}

	public int numeroSeguidores(String usuario) {

		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		if (perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException pi) {
				pi.printStackTrace();
			}
		} else if (perfilAuxiliar.isAtivo() == false) {
			try {
				throw new PDException(perfilAuxiliar);
			} catch (PDException e) {
				e.printStackTrace();
			}
		}
		return perfilAuxiliar.getSeguidores().size();
	}

	public Vector<Perfil> seguidores(String usuario) {

		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		if (perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException pi) {
				pi.printStackTrace();
			}
		} else if (perfilAuxiliar.isAtivo() == false) {
			try {
				throw new PDException(perfilAuxiliar);
			} catch (PDException pd) {
				pd.printStackTrace();
			}
		}
		Vector<Perfil> vectorSeguidores = new Vector<Perfil>();
		for (Perfil indiceUsuario : perfilAuxiliar.getSeguidores()) {
			if (indiceUsuario != null && indiceUsuario.isAtivo() == true) {
				vectorSeguidores.add(indiceUsuario);
			}
		}
		return vectorSeguidores;
	}

	public Vector<Perfil> seguidos(String usuario) {
		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		if (perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException pi) {
				pi.printStackTrace();
			}
		} else if (perfilAuxiliar.isAtivo() == false) {
			try {
				throw new PDException(perfilAuxiliar);
			} catch (PDException pd) {
				pd.printStackTrace();
			}
		}
		Vector<Perfil> vectorSeguidos = new Vector<Perfil>();
		for (Perfil indiceUsuario : perfilAuxiliar.getSeguidos()) {
			if (indiceUsuario != null && indiceUsuario.isAtivo() == true) {
				vectorSeguidos.add(indiceUsuario);
			}
		}
		return vectorSeguidos;
	}

	public void seguir(String seguidor, String seguido) {

		Perfil seguidorAuxiliar = Repositorio.buscar(seguidor);
		Perfil seguidoAuxiliar = Repositorio.buscar(seguido);
		if (seguidorAuxiliar == null || seguidoAuxiliar == null) {
			if (seguidorAuxiliar == null) {
				try {
					throw new PIException(seguidorAuxiliar);
				} catch (PIException pi) {
					pi.printStackTrace();
				}
			} else {
				try {
					throw new PIException(seguidoAuxiliar);
				} catch (PIException pi) {
					pi.printStackTrace();
				}
			}
		}

		else if (seguidoAuxiliar.isAtivo() == false || seguidorAuxiliar.isAtivo() == false) {
			if(seguidoAuxiliar.isAtivo() == false){
				try {
					throw new PDException(seguidoAuxiliar);
				} catch (PDException pd) {
					pd.printStackTrace();
				}
			}else {
				try {
					throw new PDException(seguidorAuxiliar);
				} catch (PDException pd) {
					pd.printStackTrace();
				}
			}
			
		} else {
			if (seguidorAuxiliar.getUsuario() == seguidoAuxiliar.getUsuario()) {
				try {
					throw new SIException(seguidorAuxiliar);
				} catch (SIException si) {
					si.printStackTrace();
				}
			} else {
				seguidoAuxiliar.addSeguidor(seguidorAuxiliar);
				Repositorio.atualizar(seguidoAuxiliar);
			}
		}
	}

	public Vector<Tweet> tweets(String usuario) {

		Perfil perfilAuxiliar = Repositorio.buscar(usuario);
		Vector<Tweet> vectorTweets = new Vector<Tweet>();
		if (perfilAuxiliar == null) {
			try {
				throw new PIException(perfilAuxiliar);
			} catch (PIException pi) {
				pi.printStackTrace();
			}
		} else if (perfilAuxiliar.isAtivo() == false) {
			try {
				throw new PDException(perfilAuxiliar);
			} catch (PDException pd) {
				pd.printStackTrace();
			}
		} else {
			for (Tweet tweet : perfilAuxiliar.getTimeline()) {
				vectorTweets.add(tweet);
			}
		}
		return vectorTweets;
	}
}

