package com.rhcloud.tothought.data.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = dateFormat.format(date);
		jgen.writeString(formattedDate);
	}

}
