package br.ufc.dc.poo.twitter.perfil;

import java.util.Vector;
import br.ufc.dc.poo.twitter.exceptions.UJCException;
import br.ufc.dc.poo.twitter.exceptions.UNCException;

public class Repositorio implements IRepositorioUsuario {

	private Vector<Perfil> usuarios;

	public Repositorio() {
		this.usuarios = new Vector<Perfil>();
	}
 
	public void cadastrar(Perfil usuario) {

		if (buscar(usuario.getUsuario()) == null) {
			usuarios.add(usuario);
		} else {
				try {
					throw new UJCException(usuario);
				} catch (UJCException e) {
					e.printStackTrace();
				}
		}
	}

	public Perfil buscar(String usuario) {

		for (int i = 0; i<usuarios.size(); ++i) {
			if (usuarios.get(i).getUsuario().equals(usuario)) {
				return usuarios.get(i);
			}
		}
		return null;
	}

	public void atualizar(Perfil usuario) {

		Perfil perfilAuxiliar = buscar(usuario.getUsuario());
		if (perfilAuxiliar != null) {
			usuarios.remove(perfilAuxiliar);
			usuarios.add(usuario);
		} else {
			try {
				throw new UNCException(usuario);
			} catch (UNCException unc) {
				unc.printStackTrace();
			}
		}
	}
}
