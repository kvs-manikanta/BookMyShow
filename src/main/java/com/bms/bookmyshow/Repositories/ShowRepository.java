package com.bms.bookmyshow.Repositories;

import com.bms.bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Override
    Optional<Show> findById(Long showId);
}
