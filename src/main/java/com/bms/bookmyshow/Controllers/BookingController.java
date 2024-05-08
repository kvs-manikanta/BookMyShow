package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Dtos.CreateBookingRequestDto;
import com.bms.bookmyshow.Dtos.CreateBookingResponseDto;
import com.bms.bookmyshow.Services.BookingService;
import org.springframework.stereotype.Controller;

@Controller

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService)
    {
        this.bookingService=bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto)
    {
        return null;
    }

}
