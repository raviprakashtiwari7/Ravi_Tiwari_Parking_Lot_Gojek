package com.gojek.assignment.model;

import com.gojek.assignment.constants.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(2);
    }

    @Test
    public void alotParkingToVehicle() throws Exception {
        parkingLot.alotParkingToVehicle(new Vehicle("red", "123"));
        assertEquals(1, parkingLot.getVehicleMap().size());
        assertEquals(1, parkingLot.getParkingSlots().size());

        parkingLot.alotParkingToVehicle(new Vehicle( "blue", "1234"));
        assertEquals(2, parkingLot.getVehicleMap().size());
        assertEquals(0, parkingLot.getParkingSlots().size());

        parkingLot.alotParkingToVehicle(new Vehicle( "white", "12345"));
        assertEquals(2, parkingLot.getVehicleMap().size());
        assertEquals(0, parkingLot.getParkingSlots().size());
    }

    @Test
    public void freeParking() throws Exception {
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "123"));
        parkingLot.alotParkingToVehicle(new Vehicle( "blue", "1234"));
        parkingLot.alotParkingToVehicle(new Vehicle( "white", "12345"));
        parkingLot.freeParking(1);
        assertEquals(1, parkingLot.getVehicleMap().size());
        assertEquals(1, parkingLot.getParkingSlots().size());

        parkingLot.freeParking(2);
        assertEquals(0, parkingLot.getVehicleMap().size());
        assertEquals(2, parkingLot.getParkingSlots().size());
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals(Constants.ALL_PARKING_SLOT_EMPTY, parkingLot.getStatus());
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "123"));
        assertEquals("", parkingLot.getStatus());
    }

    @Test
    public void getRegistrationNumsForCarsWithColour() throws Exception {
        assertEquals(Constants.NOT_PARKED_IN_PARKING_LOT, parkingLot.getRegistrationNumsForCarsWithColour("red"));
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "123"));
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "1234"));
        assertTrue(parkingLot.getRegistrationNumsForCarsWithColour("red").equals("123,1234") || parkingLot.getRegistrationNumsForCarsWithColour("red").equals("1234,123"));
    }

    @Test
    public void getSlotNumberForRegistrationNumber() throws Exception {
        assertEquals(Constants.NOT_PARKED_IN_PARKING_LOT, parkingLot.getSlotNumberForRegistrationNumber("123"));
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "123"));
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "1234"));
        assertEquals("1", parkingLot.getSlotNumberForRegistrationNumber("123"));
        assertEquals("2", parkingLot.getSlotNumberForRegistrationNumber("1234"));
    }

    @Test
    public void getSlotNumbersForCarsWithColour() throws Exception {
        assertEquals(Constants.COLOR_CAR_NOT_PARKED_IN_PARKING_LOT, parkingLot.getSlotNumbersForCarsWithColour("red"));
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "123"));
        parkingLot.alotParkingToVehicle(new Vehicle( "red", "1234"));
        assertTrue(parkingLot.getSlotNumbersForCarsWithColour("red").equals("1,2") || parkingLot.getSlotNumbersForCarsWithColour("red").equals("2,1"));
    }


}
