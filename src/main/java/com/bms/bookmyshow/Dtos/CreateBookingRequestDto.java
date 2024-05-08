package com.bms.bookmyshow.Dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {

    //From the frontend we only get and Id's and then get the data from DB by models and JPA
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
