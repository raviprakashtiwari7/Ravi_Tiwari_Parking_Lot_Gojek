package com.gojek.assignment.model;

import com.gojek.assignment.constants.Constants;
import com.gojek.assignment.comparator.SlotComparator;

import java.util.*;

public class ParkingLot {

    private int noOfSlots;
    private PriorityQueue<ParkingSlot> parkingSlots;
    private HashMap<Vehicle, ParkingSlot> vehicleMap = new HashMap<>();

    public PriorityQueue<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(PriorityQueue<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public HashMap<Vehicle, ParkingSlot> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(HashMap<Vehicle, ParkingSlot> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public ParkingLot(int noOfSlots) {
        parkingSlots = new PriorityQueue<ParkingSlot>(noOfSlots, new SlotComparator());
        this.noOfSlots = noOfSlots;
        this.parkingSlots = parkingSlots;
        for(int slotNumber=1;slotNumber<=noOfSlots;slotNumber++){
            parkingSlots.add(new ParkingSlot(slotNumber));
        }
        System.out.println(String.format(Constants.PARKING_LOT_CREATED, noOfSlots));
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

    public String getStatus(){
        if(vehicleMap.isEmpty()){
            System.out.println(Constants.ALL_PARKING_SLOT_EMPTY);
            return Constants.ALL_PARKING_SLOT_EMPTY;
        }
        System.out.println(String.format(Constants.STATUS_HEADER));
        for(Map.Entry<Vehicle, ParkingSlot> slot : vehicleMap.entrySet()){
            System.out.println(String.format(Constants.STATUS_BODY, slot.getValue().getSlotNumber(), slot.getKey().getRegistrationNumber(), slot.getKey().getColour()));
        }
        return "";
    }

    public String freeParking(int slotNumber){

        if(parkingSlots.contains(new ParkingSlot(slotNumber))){
            System.out.println(String.format(Constants.ALREADY_EMPTY));
            return Constants.ALREADY_EMPTY;
        }

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

    public String getRegistrationNumsForCarsWithColour(String colour){
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        String data = "";
        while (itr.hasNext()){
           Vehicle vehicle = itr.next();
           if(vehicle.getColour().equals(colour)){
               data += vehicle.getRegistrationNumber()+",";
           }
        }
        if(data.equals("")){
            System.out.println(Constants.NOT_PARKED_IN_PARKING_LOT);
            return Constants.NOT_PARKED_IN_PARKING_LOT;
        }
        else{
            System.out.println(data.substring(0, data.length()-1));
            return data.substring(0, data.length()-1);
        }
    }

    public String getSlotNumberForRegistrationNumber(String registrationNumber){
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        while (itr.hasNext()){
            Vehicle vehicle = itr.next();
            if(vehicle.getRegistrationNumber().equals(registrationNumber)){
                System.out.println(vehicle.getParkingSlot().getSlotNumber());
                return String.valueOf(vehicle.getParkingSlot().getSlotNumber());
            }
        }
            System.out.println(Constants.NOT_PARKED_IN_PARKING_LOT);
            return Constants.NOT_PARKED_IN_PARKING_LOT;
    }

    public String getSlotNumbersForCarsWithColour(String colour){
        Iterator<Vehicle> itr = vehicleMap.keySet().iterator();
        String data = "";
        while (itr.hasNext()){
            Vehicle vehicle = itr.next();
            if(vehicle.getColour().equals(colour)){
                data += vehicle.getParkingSlot().getSlotNumber()+",";
            }
        }
        if(data.equals("")){
            System.out.println(Constants.COLOR_CAR_NOT_PARKED_IN_PARKING_LOT);
            return Constants.COLOR_CAR_NOT_PARKED_IN_PARKING_LOT;
        }
        else{
            System.out.println(data.substring(0, data.length()-1));
            return data.substring(0, data.length()-1);
        }
    }

    public ParkingSlot getNextEmptySlots(){
        return parkingSlots.poll();
    }

}
