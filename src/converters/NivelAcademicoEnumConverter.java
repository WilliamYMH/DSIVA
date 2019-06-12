package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import negocio.NivelAcademicoEnum;

@Converter
public class NivelAcademicoEnumConverter implements AttributeConverter<NivelAcademicoEnum, String> {

	@Override
	public String convertToDatabaseColumn(NivelAcademicoEnum attribute) {
		return attribute.toString();
	}

	@Override
	public NivelAcademicoEnum convertToEntityAttribute(String dbData) {
		for(NivelAcademicoEnum i:NivelAcademicoEnum.values()){
			if(i.toString().equals(dbData.toUpperCase())){
				return i;
			}
		}
		return null;
	}

}
