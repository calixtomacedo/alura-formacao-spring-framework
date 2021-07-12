package br.com.cmdev.javaservlet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	private static List<Empresa> empresaList = new ArrayList<>();
	
	static {
		Empresa alura = new Empresa();
		alura.setId(1L);
		alura.setNome("Alura");
		alura.setDataCadastro(LocalDateTime.now());
		empresaList.add(alura);
		
		Empresa caelum = new Empresa();
		caelum.setId(2L);
		caelum.setNome("Caelum");
		caelum.setDataCadastro(LocalDateTime.now());
		empresaList.add(caelum);
	}
	
	public void adiciona(Empresa empresa) {
		DataBase.empresaList.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return DataBase.empresaList;
	}
}
