package com.bms.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Region extends BaseModel{

    private String name;

//    @OneToMany
//    private List<Theater> theaters;



}

/*
    1       M
Region --- Theater
    1       1
 */
