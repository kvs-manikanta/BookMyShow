package com.bms.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.SpringCacheAnnotationParser;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;
}
