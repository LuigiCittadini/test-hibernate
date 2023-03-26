package it.exolab.testmybatis.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	public String idGenerator() {
		System.out.println("Genero id");
		String id = "";
		for (int i = 0; i < 3; i++) {
			char primaParte = (char) ((Math.random() * 25) + 66);
			id += primaParte;
		}
		for (int i = 0; i < 3; i++) {
			int secondaParte = (int) (Math.random() * 10);
			id += secondaParte;
		}
		return id;
	}


	public java.util.Date formattaData(String data) {
		System.out.println("formatto data");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = (Date) dateFormat.parse(data);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
