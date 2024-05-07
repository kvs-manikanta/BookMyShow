package com.bms.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Movie {
    private String movieName;
    private Date  realeaseDate;

    private List<Feature> features;
}
