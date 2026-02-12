package com.irctc.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.booking.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {

    List<Train> findBySourceAndDestinationAndDate(
            String source,
            String destination,
            String date
    );
}
