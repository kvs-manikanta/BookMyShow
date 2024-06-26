package com.bms.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.SpringCacheAnnotationParser;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int price;
}

/*

    1              1
ShowSeatType --- Show
    M               1

 */
