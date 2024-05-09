package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Override
    Booking save(Booking booking);
}
