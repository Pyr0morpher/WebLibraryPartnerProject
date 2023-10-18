package helper;

import java.time.LocalDate;
import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@SuppressWarnings("unused")
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, java.sql.Date> {
    
    // Converts LocalDate to java.sql.Date for database storage
    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate attribute) {
        return (attribute == null ? null : java.sql.Date.valueOf(attribute));
    }

    // Converts java.sql.Date from the database to LocalDate
    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date dbData) {
        return (dbData == null ? null : dbData.toLocalDate());
    }
}
