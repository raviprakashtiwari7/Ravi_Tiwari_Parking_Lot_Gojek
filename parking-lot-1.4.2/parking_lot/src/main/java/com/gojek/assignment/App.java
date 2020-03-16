package com.gojek.assignment;

import com.gojek.assignment.Constants.Command;
import com.gojek.assignment.manager.ParkingLotManager;

import java.io.*;

/**
 * Parking Lot Application
 *
 */
public class App 
{
    ParkingLotManager parkingLotController;


    public static void main(String[] args) {
        App parkingLotApplication = new App();
        if (args == null || args.length == 0) {
            parkingLotApplication.takeInputFromCommandPrompt();
        } else {
            parkingLotApplication.takeInputFromFile(args[0]);
        }

    }

    private void takeInputFromFile(String filePath) {
        File file = new File(filePath);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Error Reading file");
        }

        String command;
        try {
            while ((command = br.readLine()) != null)
                if (command != null) {
                    executeCommand(command.split(" "));
                }
        } catch (IOException e) {
            e . printStackTrace ();
        }
    }


    private void takeInputFromCommandPrompt() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = null;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                System.out.print("something went wrong");
            }
            if (command != null) {
                executeCommand(command.split(" "));
            }
        }
    }

    private void executeCommand(String[] command) {
        switch (command[0]) {
            case Command.CREATE_PARKING_LOT:
                if (command.length >= 2) {
                    parkingLotController = new ParkingLotManager(Integer.valueOf(command[1]));
                    return;
                }
                break;
            case Command.PARK:
                if (command.length >= 3) {
                    if (parkingLotController != null) {
                        parkingLotController.parkVehicle(command[1], command[2]);//write the assumption
                        return;
                    }
                }
                break;
            case Command.LEAVE:
                if (command.length >= 2) {
                    if (parkingLotController != null) {
                        parkingLotController.freeParking(Integer.valueOf(command[1]));
                        return;
                    }
                }
                break;
            case Command.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
                if (command.length >= 2) {
                    if (parkingLotController != null) {
                        parkingLotController.getRegistrationNumsForCarsWithColour(command[1]);
                        return;
                    }
                }
                break;
            case Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                if (command.length >= 2) {
                    if (parkingLotController != null) {
                        parkingLotController.getSlotNumberForCarWithRegistrationNum(command[1]);
                        return;
                    }
                }
                break;
            case Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                if (command.length >= 2) {
                    if (parkingLotController != null) {
                        parkingLotController.getSlotNumberForCarsWithColour(command[1]);
                        return;
                    }
                }
                break;
            case Command.STATUS:
                if (parkingLotController != null) {
                    parkingLotController.getParkingLotStatus();
                    return;
                }
                break;
            case Command.EXIT:
                System.exit(0);
        }
        System.out.println("Something Went Wrong");
    }
}
