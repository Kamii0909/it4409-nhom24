package edu.hust.it4409.booking.hotel.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import edu.hust.it4409.booking.hotel.amenity.parking.CommonParkingAmenity;
import edu.hust.it4409.booking.hotel.amenity.parking.ParkingAmenity;
import jakarta.persistence.AttributeConverter;

public class ParkingAmenityConverter implements AttributeConverter<ParkingAmenity, String> {
    
    private final ObjectWriter interfaceWriter;
    
    public ParkingAmenityConverter(ObjectMapper objectMapper) {
        interfaceWriter = objectMapper.writerFor(ParkingAmenity.class);
    }
    
    @Override
    public String convertToDatabaseColumn(ParkingAmenity attribute) {
        try {
            if (attribute instanceof CommonParkingAmenity cpa) {
                return cpa.toJson();
            }
            return interfaceWriter.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }
    
    @Override
    public ParkingAmenity convertToEntityAttribute(String dbData) {
        CommonParkingAmenity cpa;
        if ((cpa = CommonParkingAmenity.fromJson(dbData)) != null) {
            return cpa;
        }
        throw new UnsupportedOperationException(
            "Unimplemented default parking amenity converter: %s".formatted(dbData));
    }
    
}
