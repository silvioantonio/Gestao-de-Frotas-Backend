package com.silvio.gestaoDeFrotas.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@SuppressWarnings("serial")
public class DateHandler extends StdDeserializer<Date> {
	
	public DateHandler() {
		this(null);
	}

	public DateHandler(Class<?> object) {
		super(object);
	}

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = p.getText();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("date: "+sdf.format(date));
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

}