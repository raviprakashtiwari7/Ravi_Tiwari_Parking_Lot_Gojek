package com.gojek.assignment.model;

public class ParkingTicket {
    private String ticketNumber;

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getAllotedSlotNumber() {
        return allotedSlotNumber;
    }

    public void setAllotedSlotNumber(String allotedSlotNumber) {
        this.allotedSlotNumber = allotedSlotNumber;
    }

    public Vehicle getAllotedVehicle() {
        return allotedVehicle;
    }

    public void setAllotedVehicle(Vehicle allotedVehicle) {
        this.allotedVehicle = allotedVehicle;
    }

    private String allotedSlotNumber;
    private Vehicle allotedVehicle;
}
