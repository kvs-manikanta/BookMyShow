package com.bms.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;

    private List<Booking> bookings;
}
