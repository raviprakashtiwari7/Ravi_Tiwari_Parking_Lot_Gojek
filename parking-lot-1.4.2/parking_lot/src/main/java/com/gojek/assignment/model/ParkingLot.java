package com.gojek.assignment.model;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ParkingLot {

    private int slotNumber;
    private PriorityQueue<ParkingSlot> parkingSlots;

    public ParkingLot(int slotNumber, PriorityQueue<ParkingSlot> parkingSlots) {
        this.slotNumber = slotNumber;
        this.parkingSlots = parkingSlots;
    }


}
