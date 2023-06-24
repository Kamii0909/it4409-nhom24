package edu.hust.it4409.booking.hotel;

import org.springframework.stereotype.Repository;

import io.hypersistence.utils.spring.repository.BaseJpaRepository;

@Repository
public interface HotelRepository extends BaseJpaRepository<Hotel, Long> {
    
}
