package com.gojek.assignment.model;

public class ParkingSlot {

    private String slotNumber;
    private Vehicle vehicle;

    public ParkingSlot(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
