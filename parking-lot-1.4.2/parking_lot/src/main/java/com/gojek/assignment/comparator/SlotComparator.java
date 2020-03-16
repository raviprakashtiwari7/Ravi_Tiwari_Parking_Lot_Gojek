package com.gojek.assignment.comparator;

import com.gojek.assignment.model.ParkingSlot;

import java.util.Comparator;

public class SlotComparator implements Comparator<ParkingSlot> {

    @Override
    public int compare(ParkingSlot o1, ParkingSlot o2) {
        return o1.getSlotNumber() - o2.getSlotNumber();
    }
}
