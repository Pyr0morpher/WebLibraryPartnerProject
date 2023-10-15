package helper;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, java.sql.Date> {
	@Override
	public java.sql.Date convertToDatabaseColumn(LocalDate attribute) {
		return (attribute == null ? null : java.sql.Date.valueOf(attribute));
	}

	@Override
	public LocalDate convertToEntityAttribute(java.sql.Date dbData) {
		return (dbData == null ? null : dbData.toLocalDate());
	}
}
