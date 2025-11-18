package com.yugesh.featuresOfJava_8.lambda.customLambdaExample;

import java.util.ArrayList;
import java.util.List;

public class HotelService {

    List<Hotel>list=new ArrayList<>();

    public HotelService(){
        list.add(new Hotel(2000,3,HotelType.FOUR_STAR));
        list.add(new Hotel(100,1,HotelType.THREE_STAR));
        list.add(new Hotel(300,2,HotelType.THREE_STAR));
        list.add(new Hotel(1000,3,HotelType.FOUR_STAR));
        list.add(new Hotel(2500,4,HotelType.FIVE_STAR));
        list.add(new Hotel(300,2,HotelType.THREE_STAR));
        list.add(new Hotel(500,3,HotelType.THREE_STAR));
        list.add(new Hotel(700,3,HotelType.THREE_STAR));
        list.add(new Hotel(4000,4,HotelType.FIVE_STAR));
        list.add(new Hotel(5000,5,HotelType.FIVE_STAR));
        list.add(new Hotel(900,2,HotelType.THREE_STAR));
        list.add(new Hotel(1200,1,HotelType.THREE_STAR));
        list.add(new Hotel(8000,5,HotelType.FIVE_STAR));
    }

    public List<Hotel> filterHotels(FilterHotel filterHotel){
        List<Hotel>filtered=new ArrayList<>();

        for(Hotel i:list){
            if(filterHotel.filter(i)){
                filtered.add(i);
            }
        }
        return filtered;
    }
}
