package com.irctc.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.irctc.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findTopByOrderByIdDesc();
}
