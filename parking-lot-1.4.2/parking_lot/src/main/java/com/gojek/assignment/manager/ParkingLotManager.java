package com.gojek.assignment.manager;

import com.gojek.assignment.Constants.Command;
import com.gojek.assignment.comparator.SlotComparator;
import com.gojek.assignment.model.ParkingLot;
import com.gojek.assignment.model.ParkingSlot;
import com.gojek.assignment.model.Vehicle;

import java.util.PriorityQueue;

public class ParkingLotManager {
    ParkingLot parkingLot;

    public ParkingLotManager(int noOfSlots){
        parkingLot = new ParkingLot(noOfSlots);
    }

    public void parkVehicle(String registrationNumber, String colour){
        Vehicle vehicle = new Vehicle(colour, registrationNumber);
        this.parkingLot.alotParkingToVehicle(vehicle);
    }

    public void freeParking(int slotNumber){
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
