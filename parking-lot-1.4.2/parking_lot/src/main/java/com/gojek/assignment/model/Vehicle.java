package com.gojek.assignment.model;

public class Vehicle {
    private String colour;
    private String registrationNumber;
    private ParkingTicket parkingTicket;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
