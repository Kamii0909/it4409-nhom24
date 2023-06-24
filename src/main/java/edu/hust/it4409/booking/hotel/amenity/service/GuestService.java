package edu.hust.it4409.booking.hotel.amenity.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GuestService {
    private Smoking smoking;
    private boolean hasLuggageStorage;
    private boolean hasLaundryService;
    private boolean hasConciergeService;
    private boolean hasComputerStation;
    private boolean hasHairSalon;
    private boolean hasMultilingualStaff;
    private boolean hasPorterOrBellhop;
    private boolean hasWeddingService;
}
