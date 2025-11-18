package com.yugesh.featuresOfJava_8.lambda.customLambdaExample;

import java.util.List;

public class Main {

    static void main() {


        HotelService service = new HotelService();

        List<Hotel> filteredBasedOnRatings = service
                .filterHotels(
                        hotel -> hotel.getRatings() < 3
                );

        System.out.println(filteredBasedOnRatings);

        List<Hotel> fiveStartHotels = service
                .filterHotels(
                        hotel -> hotel.getHotelType().equals(HotelType.FIVE_STAR)
                );
        System.out.println(fiveStartHotels);
    }
}
