package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.Models.Show;
import com.bms.bookmyshow.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
