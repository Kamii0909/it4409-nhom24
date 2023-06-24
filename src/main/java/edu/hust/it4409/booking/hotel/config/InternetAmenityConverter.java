package edu.hust.it4409.booking.hotel.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import edu.hust.it4409.booking.hotel.amenity.internet.CommonInternetAmenity;
import edu.hust.it4409.booking.hotel.amenity.internet.InternetAmenity;
import jakarta.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InternetAmenityConverter implements AttributeConverter<InternetAmenity, String> {
    
    private final ObjectWriter interfaceWriter;
    
    public InternetAmenityConverter(ObjectMapper objectMapper) {
        interfaceWriter = objectMapper.writerFor(InternetAmenity.class);
    }
    
    @Override
    public String convertToDatabaseColumn(InternetAmenity attribute) {
        try {
            if (attribute instanceof CommonInternetAmenity cia) {
                return cia.toJson();
            }
            return interfaceWriter.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }
    
    @Override
    public InternetAmenity convertToEntityAttribute(String dbData) {
        CommonInternetAmenity cia;
        if ((cia = CommonInternetAmenity.fromJson(dbData)) != null) {
            return cia;
        }
        log.warn("Deserializing non enum InternetAmenity instance: {}", dbData);
        throw new IllegalStateException(dbData);
        
    }
    
}
