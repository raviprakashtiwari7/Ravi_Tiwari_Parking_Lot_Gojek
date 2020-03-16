package com.gojek.assignment.model;

import com.gojek.assignment.Constants.Command;
import com.gojek.assignment.manager.Constants;

import java.util.*;

public class ParkingLot {

    private int noOfSlots;
    private PriorityQueue<ParkingSlot> parkingSlots;
    private HashMap<Vehicle, ParkingSlot> vehicleMap = new HashMap<>();


    public ParkingLot(int noOfSlots, PriorityQueue<ParkingSlot> parkingSlots) {
        this.noOfSlots = noOfSlots;
        this.parkingSlots = parkingSlots;
        for(int slotNumber=1;slotNumber<=noOfSlots;slotNumber++){
            parkingSlots.add(new ParkingSlot(String.valueOf(slotNumber)));
        }
    }

    public String alotParkingToVehicle(Vehicle vehicle){
        if(parkingSlots.isEmpty()){
            System.out.println(Constants.NO_SPACE);
            return Constants.NO_SPACE;
        }
        ParkingSlot slot = getNextEmptySlots();
        vehicle.setParkingSlot(slot);
        slot.setVehicle(vehicle);
        vehicleMap.put(vehicle, slot);
        System.out.println(String.format(Constants.ALLOCATED_SLOT, slot.getSlotNumber()));

        return String.format(Constants.ALLOCATED_SLOT, slot.getSlotNumber());
    }

    public void getStatus(){
        if(parkingSlots.isEmpty()){
            System.out.println(Constants.NO_SPACE);
        }

        for(ParkingSlot slot : parkingSlots){
            System.out.println(String.format(Constants.STATUS_BODY, slot.getSlotNumber(), slot.getVehicle().getRegistrationNumber(), slot.getVehicle().getColour()));
        }
    }

    public String freeParking(String slotNumber){

        Vehicle vehicle =null;
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        while (itr.hasNext()){
            vehicle = itr.next();
            if(vehicle.getParkingSlot().getSlotNumber() == slotNumber) {
                break;
            }
        }
        ParkingSlot slot = vehicleMap.get(vehicle);
        slot.setVehicle(null);
        vehicle.setParkingSlot(null);
        vehicleMap.remove(vehicle);
        parkingSlots.add(slot);

        System.out.println(String.format(Constants.SLOT_FREED, slotNumber));

        return String.format(Constants.SLOT_FREED, slotNumber);
    }

    public void getRegistrationNumsForCarsWithColour(String colour){
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        String data = "";
        while (itr.hasNext()){
           Vehicle vehicle = itr.next();
           if(vehicle.getColour().equals(colour)){
               data += vehicle.getRegistrationNumber()+",";
           }
        }
        System.out.println(data.substring(0, data.length()-1));
    }

    public void getSlotNumberForRegistrationNumber(String registrationNumber){
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        while (itr.hasNext()){
            Vehicle vehicle = itr.next();
            if(vehicle.getRegistrationNumber().equals(registrationNumber)){
                System.out.println(vehicle.getParkingSlot().getSlotNumber());
                break;
            }
        }
    }

    public void getSlotNumbersForCarsWithColour(String colour){
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        String data = "";
        while (itr.hasNext()){
            Vehicle vehicle = itr.next();
            if(vehicle.getColour().equals(colour)){
                data += vehicle.getParkingSlot().getSlotNumber()+",";
            }
        }
        System.out.println(data.substring(0, data.length()-1));
    }

    public ParkingSlot getNextEmptySlots(){
        return parkingSlots.poll();
    }

}
