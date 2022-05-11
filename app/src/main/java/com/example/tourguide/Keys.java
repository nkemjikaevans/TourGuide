package com.example.tourguide;

/**
 * Public constants
 * Created by Evans on 01/06/2020.
 */

public class Keys {

    /**
     * Keys for sending data through bundle from Fragments -> {@link AttractionDetailActivity}
     */
    public static final String ATTRACTION_NAME_KEY = "attraction_name";
    public static final String ATTRACTION_DETAIL_KEY = "attraction_detail";
    public static final String ATTRACTION_ADDRESS_KEY = "attraction_address";
    public static final String ATTRACTION_LOCATION_KEY = "attraction_location";
    public static final String ATTRACTION_IMAGE_KEY = "attraction_image";
    public static final String ATTRACTION_RATING_KEY = "attraction_rating";
    public static final String ATTRACTION_PHONE_NUMBER_KEY = "attraction_phone_number";
    public static final String FRAGMENT_IDENTIFIER = "fragment_identifier";

    private Keys() {
        // Empty constructor so no one can accidentally use it
    }
}
