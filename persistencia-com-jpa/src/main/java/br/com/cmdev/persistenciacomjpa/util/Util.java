package br.com.cmdev.persistenciacomjpa.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	
	private static final DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static String formatDataComHora(LocalDateTime data) {
		return fullDate.format(data);
	}
	
	public static String formataMoeda(BigDecimal valor) {
		return NumberFormat.getCurrencyInstance().format(valor);
	}

}
