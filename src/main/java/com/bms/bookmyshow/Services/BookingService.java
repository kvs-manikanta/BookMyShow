package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Exceptions.UserNotFoundException;
import com.bms.bookmyshow.Models.*;
import com.bms.bookmyshow.Repositories.ShowRepository;
import com.bms.bookmyshow.Repositories.ShowSeatRepository;
import com.bms.bookmyshow.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    //Create the respective repositories and get the details required
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculator priceCalculator;

    //ConstructorInjection
    public BookingService(UserRepository userRepository,
                            ShowRepository showRepository,
                            ShowSeatRepository showSeatRepository,
                            PriceCalculator priceCalculator)
    {
        this.userRepository=userRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.priceCalculator=priceCalculator;
    }

    public Booking createBooking(Long userId, List<Long> showSeatIds,Long showId) throws UserNotFoundException {
        /*
        Inject the Repositories and get the Details from the DB
        1.Get the details of a user
        2.Get the List of Seat user id trying to Book
        3.Get the Show details
        4.validate the availability of seats selected by user whether to book
        5.if all seats are available block the seats booked by user
        6.if not throw the exception
        7.Save to the DB after blocking the Seats
        8.Now book the Ticket and save it to the DB
        9.and return the Booking back to the Controller
        10.Handle the Exceptions
        */

        //1.Get the details of a user
        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isEmpty())
        {
            throw new UserNotFoundException("User is not available "+ userId + "Please check again");
        }
        User user= optionalUser.get();

        //3.Get the Show object from showID
        Optional<Show> optionalShow=showRepository.findById(showId);

        if(optionalShow.isEmpty())
        {
            throw new RuntimeException("Show is not valid " + showId);
        }

        Show show=optionalShow.get();

        //2.Get the List of Seat user id trying to Book
        List<ShowSeat> showSeats=showSeatRepository.findAllById(showSeatIds);

        //4.Validate the availability of ShowSeats
        for(ShowSeat showSeat : showSeats)
        {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new RuntimeException("Your current Show Seat " + showSeat.getShow().getId()
                        + showSeat.getSeat().getId() + " isn't available");
            }
        }

        //5.set the showSeat Status to blocked

        for(ShowSeat showSeat : showSeats)
        {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);

            //saving into DB
            showSeatRepository.save(showSeat);
        }

        Booking booking=new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(show);
        booking.setUser(user);
        booking.setBookingNumber("9899bdsgchc12");
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        booking.setCratedAt(new Date());

        booking.setAmount(priceCalculator.calculatePrice(show,showSeats));




        return null;
    }

}
