package com.construction.cmsfresher.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CodeGenerator {

	public static String generateCode(String name, int number) {
		StringBuilder builder = new StringBuilder();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		String formattedDate = currentDate.format(formatter);

		String number1 = String.format("%03d", number);
		String code = name + number1 + formattedDate;
		builder.append(code);
		return builder.toString();
	}
//DCV00112122023
	public static int getNumber(String name, String number) {
		switch (name) {
		case "PL":
			String codePlan = number.substring(2, 5);
			int number1 = Integer.parseInt(codePlan);
			number1++;
			return number1;

		case "DCV":
			String codeDinary = number.substring(3, 6);
			int number2 = Integer.parseInt(codeDinary);
			number2++;
			return number2;
		}

		return 1;
	}
}
