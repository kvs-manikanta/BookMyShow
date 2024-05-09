package com.bms.bookmyshow.Services;

import com.bms.bookmyshow.Models.Show;
import com.bms.bookmyshow.Models.ShowSeat;
import com.bms.bookmyshow.Models.ShowSeatType;
import com.bms.bookmyshow.Repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository)
    {
        this.showSeatTypeRepository=showSeatTypeRepository;
    }

    public int calculatePrice(Show show, List<ShowSeat> showSeats)
    {
        int amount=0;
        //Get the price of the particular SeatType for a show
        List<ShowSeatType> showSeatTypes=showSeatTypeRepository.findAllByShow(show);

        for(ShowSeat showSeat : showSeats)
        {
            for(ShowSeatType showSeatType : showSeatTypes)
            {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType()))
                {
                    amount = showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
