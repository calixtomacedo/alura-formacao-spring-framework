package br.com.cmdev.javaservletii.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataBase {

	private static List<Empresa> empresaList = new ArrayList<>();
	private static List<Usuario> usuarioList = new ArrayList<>();
	private static Long ids = 1L;

	static {
		Empresa alura = new Empresa();
		alura.setId(ids++);
		alura.setNome("Alura");
		alura.setDataCadastro(new Date());
		empresaList.add(alura);

		Empresa caelum = new Empresa();
		caelum.setId(ids++);
		caelum.setNome("Caelum");
		caelum.setDataCadastro(new Date());
		empresaList.add(caelum);
		
		Usuario calixto = new Usuario();
		calixto.setNome("Calixto Macedo");
		calixto.setLogin("calixto.macedo");
		calixto.setSenha("123");
		usuarioList.add(calixto);
		
		Usuario rosy = new Usuario();
		rosy.setNome("Rosimeire Cunegundes");
		rosy.setLogin("rosy.macedo");
		rosy.setSenha("321");
		
		usuarioList.add(rosy);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(ids++);
		DataBase.empresaList.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return DataBase.empresaList;
	}

	public void delete(Long id) {
		Iterator<Empresa> it = empresaList.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId().equals(id)) {
				it.remove();
			}
		}
	}

	public Empresa findById(Long id) {
		for (Empresa empresa : empresaList) {
			if(empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}

	public void save(Empresa empresa) {
		for (Empresa empresas : empresaList) {
			if (empresas.getId().equals(empresa.getId())) {
				empresas.setNome(empresa.getNome());
				empresas.setDataAbertura(empresa.getDataAbertura());
			}
		}
	}

	public Usuario usarioLogin(String login, String senha) {
		for (Usuario user : usuarioList) {
			if(user.isUsuarioValido(login, senha)) {
				return user;
			}
		}
		return null;
	}
}
