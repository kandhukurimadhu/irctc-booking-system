package com.irctc.booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trainId;
    private String trainName;

    private String passengerName;
    private int passengerAge;
    private String passengerGender;

    private String status;

    public Booking() {}

    public Booking(Long trainId, String trainName,
                   String passengerName, int passengerAge,
                   String passengerGender, String status) {

        this.trainId = trainId;
        this.trainName = trainName;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerGender = passengerGender;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
