package edu.hust.it4409.booking.hotel.amenity.internet;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Preconditions;

public interface InternetAmenity {
    public enum RestrictionPeriod {
        PER_STAY,
        PER_DAY;
    }
    
    public interface WifiRestriction {
    }
    
    public record TimeRestriction(int amount, TimeUnit timeUnit, RestrictionPeriod restrictionPeriod)
        implements WifiRestriction {
        public TimeRestriction {
            Preconditions.checkArgument(timeUnit != TimeUnit.HOURS || timeUnit != TimeUnit.MINUTES,
                "Can't restrict by anything but Minutes and Hours");
            if (timeUnit == TimeUnit.HOURS) {
                Preconditions.checkArgument(amount > 0 && amount < 24,
                    "Hour length %s is not in valid (0,24) range", amount);
            } else {
                Preconditions.checkArgument(amount > 0 && amount < 1440,
                    "Minute length %s is not in valid (0,1440) range", amount);
            }
        }
    }
    
    public record WifiConnection(boolean isProvided, boolean isFree) {
    }
    
    WifiConnection wifiInGuestRooms();
    
    WifiConnection wifiInPublicAreas();
    
    default boolean ethernetInGuestRooms() {
        return false;
    }
    
    default boolean ethernetInPublicAreas() {
        return false;
    }
    
    default boolean dialupInGuestRooms() {
        return false;
    }
    
    default boolean dialupInPublicAreas() {
        return false;
    }
}
