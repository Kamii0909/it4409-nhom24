package edu.hust.it4409.booking.hotel.room.view;

import static com.google.common.collect.ImmutableList.of;

import com.google.common.collect.ImmutableList;

public enum CommonViewFeature implements ViewFeature {
    SEA_VIEW("Sea", false),
    CITY_VIEW("City", false),
    LAKE_VIEW("Lake", false),
    RIVER_VIEW("River", false),
    SEA_VIEW_BALCONY("Sea", true),
    CITY_VIEW_BALCONY("City", true),
    LAKE_VIEW_BALCONY("Lake", true),
    RIVER_VIEW_BALCONY("River", true),
    CITY_LAKE_VIEW("City and lake", false),
    CITY_SEA_VIEW("City and sea", false),
    SEA_EXTRA_CITY_VIEW_BALCONY("Sea", true, of("City"));
    
    private final String mainView;
    private final boolean hasBalcony;
    private final ImmutableList<String> extraViews;
    
    private CommonViewFeature(String mainView, boolean hasBalcony) {
        this.mainView = mainView;
        this.hasBalcony = hasBalcony;
        this.extraViews = of();
    }
    
    private CommonViewFeature(String mainView, boolean hasBalcony, ImmutableList<String> extraViews) {
        this.mainView = mainView;
        this.hasBalcony = hasBalcony;
        this.extraViews = extraViews;
    }
    
    @Override
    public String mainView() {
        return mainView;
    }
    
    @Override
    public boolean hasBalcony() {
        return hasBalcony;
    }
    
    @Override
    public ImmutableList<String> extraViews() {
        return extraViews;
    }
    
}
