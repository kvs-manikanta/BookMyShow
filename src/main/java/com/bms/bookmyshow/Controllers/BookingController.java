package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Dtos.CreateBookingRequestDto;
import com.bms.bookmyshow.Dtos.CreateBookingResponseDto;
import com.bms.bookmyshow.Dtos.ResponseStatus;
import com.bms.bookmyshow.Models.Booking;
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
        CreateBookingResponseDto responseDto=new CreateBookingResponseDto();
        try {
            Booking booking = bookingService.createBooking(requestDto.getUserId(),
                    requestDto.getShowSeatIds(),
                    requestDto.getShowId());

            responseDto.setBookingId(booking.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }

}
