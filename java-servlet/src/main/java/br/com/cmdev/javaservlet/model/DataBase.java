package br.com.cmdev.javaservlet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBase {

	private static List<Empresa> empresaList = new ArrayList<>();
	private static Long ids = 1L;

	static {
		Empresa alura = new Empresa();
		alura.setId(ids++);
		alura.setNome("Alura");
		alura.setDataCadastro(LocalDateTime.now());
		empresaList.add(alura);

		Empresa caelum = new Empresa();
		caelum.setId(ids++);
		caelum.setNome("Caelum");
		caelum.setDataCadastro(LocalDateTime.now());
		empresaList.add(caelum);
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
}
