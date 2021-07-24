package br.com.cmdev.javaejpaii.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("java-e-jpa-ii");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
