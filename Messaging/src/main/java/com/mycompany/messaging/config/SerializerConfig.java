package com.mycompany.messaging.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class SerializerConfig implements Jackson2ObjectMapperBuilderCustomizer {

	@Override
	public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
		// CustomDateJsonSerializer serializer = new CustomDateJsonSerializer();
		// CustomDateJsonDeserializer deserializer = new CustomDateJsonDeserializer();
		// jacksonObjectMapperBuilder.deserializerByType(Date.class,
		// deserializer).serializerByType(Date.class, serializer)
		// .serializerByType(java.sql.Date.class,
		// serializer).deserializerByType(java.sql.Date.class, deserializer)
		// .serializers(serializer).deserializers(deserializer);

	}

}
