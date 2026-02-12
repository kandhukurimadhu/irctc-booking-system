package com.irctc.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.irctc.booking.entity.Train;
import com.irctc.booking.repository.TrainRepository;

@RestController
@RequestMapping("/api/trains")
@CrossOrigin(origins = "*")
public class TrainController {

    @Autowired
    private TrainRepository repo;

    // ✅ Admin Add Train API
    @PostMapping("/add")
    public String addTrain(@RequestBody Train train) {
        repo.save(train);
        return "Train Added Successfully 🚆";
    }

    // ✅ User Search Train API
    @GetMapping("/search")
    public List<Train> searchTrain(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date
    ) {
        return repo.findBySourceAndDestinationAndDate(source, destination, date);
    }

    // ✅ Get All Trains API
    @GetMapping("/all")
    public List<Train> getAllTrains() {
        return repo.findAll();
    }
}
