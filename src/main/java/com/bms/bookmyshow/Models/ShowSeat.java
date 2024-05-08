package com.bms.bookmyshow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL) // 0 1 2
    private ShowSeatStatus showSeatStatus;
}

/*

    1           1
ShowSeat --- Seat
    M           1

show - m a e
seat - 1 2 3

show Seat - m1 m2 m3 a1 a2 a2 e1 e2 e3




 */
