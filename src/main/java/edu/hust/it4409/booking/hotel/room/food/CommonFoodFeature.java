package edu.hust.it4409.booking.hotel.room.food;

import com.google.common.collect.ImmutableList;

public enum CommonFoodFeature implements FoodFeature {
    DEFAULT_NO_FREE_FOOD(false, false, false, true, true),
    DEFAULT_FREE_BREAKFAST_ONLY(true, false, false, true, true),
    DEFAULT_FREE_FOOD(true, true, true, true, true);
    
    private final boolean freeBreakfast;
    private final boolean freeLunch;
    private final boolean freeDinner;
    private final boolean hasRoomService;
    private final boolean hasLimitedRoomService;
    private final ImmutableList<String> others;
    
    @SuppressWarnings("unused constructor")
    private CommonFoodFeature(boolean freeBreakfast,
        boolean freeLunch,
        boolean freeDinner,
        boolean hasRoomService,
        boolean hasLimitedRoomService,
        ImmutableList<String> others) {
        this.freeBreakfast = freeBreakfast;
        this.freeLunch = freeLunch;
        this.freeDinner = freeDinner;
        this.hasRoomService = hasRoomService;
        this.hasLimitedRoomService = hasLimitedRoomService;
        this.others = others;
    }
    
    private CommonFoodFeature(boolean freeBreakfast,
        boolean freeLunch,
        boolean freeDinner,
        boolean hasRoomService,
        boolean hasLimitedRoomService) {
        this.freeBreakfast = freeBreakfast;
        this.freeLunch = freeLunch;
        this.freeDinner = freeDinner;
        this.hasRoomService = hasRoomService;
        this.hasLimitedRoomService = hasLimitedRoomService;
        this.others = ImmutableList.of();
    }
    
    @Override
    public boolean hasFreeBreakfast() {
        return freeBreakfast;
    }
    
    @Override
    public boolean hasFreeLunch() {
        return freeLunch;
    }
    
    @Override
    public boolean hasFreeDinner() {
        return freeDinner;
    }
    
    @Override
    public boolean hasRoomService() {
        return hasRoomService;
    }
    
    @Override
    public boolean hasLimitedRoomService() {
        return hasLimitedRoomService;
    }
    
    @Override
    public ImmutableList<String> others() {
        return others;
    }
    
}
