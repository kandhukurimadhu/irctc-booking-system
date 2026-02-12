package com.irctc.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.irctc.booking.entity.Booking;
import com.irctc.booking.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingRepository repo;

    // ✅ Book Ticket API
    @PostMapping("/book")
    public String bookTicket(@RequestBody Booking booking) {

        booking.setStatus("CONFIRMED");
        repo.save(booking);

        return "Ticket Booked Successfully 🎫";
    }

    // ✅ Latest Ticket API
    @GetMapping("/latest")
    public Booking getLatestBooking() {

        return repo.findTopByOrderByIdDesc();
    }
}
