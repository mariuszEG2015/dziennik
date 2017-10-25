<<<<<<< HEAD
package pl.eurogeo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	  @Override
	    public Date convertToDatabaseColumn(LocalDate locDate) {
	    	return (locDate == null ? null : Date.valueOf(locDate));
	    }
//koment
	    @Override
	    public LocalDate convertToEntityAttribute(Date sqlDate) {
	    	return (sqlDate == null ? null : sqlDate.toLocalDate());
	    }

}
=======
package pl.eurogeo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	  @Override
	    public Date convertToDatabaseColumn(LocalDate locDate) {
	    	return (locDate == null ? null : Date.valueOf(locDate));
	    }
//koment
	    @Override
	    public LocalDate convertToEntityAttribute(Date sqlDate) {
	    	return (sqlDate == null ? null : sqlDate.toLocalDate());
	    }

}
>>>>>>> 76125fe7be162450faf5de35c419081e5ca577f9
