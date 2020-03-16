package com.gojek.assignment.manager;

import com.gojek.assignment.Constants.Command;
import com.gojek.assignment.comparator.SlotComparator;
import com.gojek.assignment.model.ParkingLot;
import com.gojek.assignment.model.ParkingSlot;
import com.gojek.assignment.model.Vehicle;

import java.util.PriorityQueue;

public class ParkingLotManager {
    int numberOfParkingSlots;
    ParkingLot parkingLot;

    public void createParkingSlots(int noOfSlots){
        PriorityQueue<ParkingSlot> slots = new PriorityQueue<>(numberOfParkingSlots, new SlotComparator());
        parkingLot = new ParkingLot(numberOfParkingSlots, slots);
    }

    public void parkVehicle(String registrationNumber, String colour){
        Vehicle vehicle = new Vehicle(colour, registrationNumber);
        this.parkingLot.alotParkingToVehicle(vehicle);
    }

    public void freeParking(String slotNumber){
        parkingLot.freeParking(slotNumber);
    }

    public void getParkingLotStatus(){
        parkingLot.getStatus();
    }

    public void getRegistrationNumsForCarsWithColour(String colour){
        parkingLot.getRegistrationNumsForCarsWithColour(colour);
    }

    public void getSlotNumberForCarsWithColour(String colour){
        parkingLot.getSlotNumbersForCarsWithColour(colour);
    }

    public void getSlotNumberForCarWithRegistrationNum(String registrationNumber){
        parkingLot.getSlotNumberForRegistrationNumber(registrationNumber);
    }

}
