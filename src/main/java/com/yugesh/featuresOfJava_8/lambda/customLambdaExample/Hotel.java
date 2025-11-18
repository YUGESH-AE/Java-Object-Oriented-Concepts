package com.yugesh.featuresOfJava_8.lambda.customLambdaExample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Hotel {

    private int pricePerNight;
    private int ratings;
    private HotelType hotelType;

}
