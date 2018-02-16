package com.vailancio;

public class Main {

    public static void main(String[] args) {
        int numberOfFloors = 100;
        int numberOfElevator = 5;


        Elevator elevators[] = new Elevator[numberOfElevator];
        Floor floors[] = new Floor[numberOfFloors];

        for(int i = 0; i< numberOfElevator; i++){
            elevators[i] = new Elevator(i);
        }

        for(int i = 0; i< numberOfFloors; i++){
            floors[i] = new Floor(i);
        }


        ElevatorController controller = ElevatorController.getInstance();
        controller.config(elevators,floors);
        controller.resetToGround();


        controller.displayCurrentAllocation();
        floors[1].buttonPressed();

        floors[4].buttonPressed();

        controller.displayCurrentAllocation();

        //System.out.println(controller.getProximityScore(elevators[3], floors[3]));

        //controller.setFloor(elevators[4],floors[99]);

        //System.out.println(controller.getProximityScore(elevators[4], floors[3]));

        controller.displayCurrentAllocation();

        floors[5].buttonPressed();

        floors[90].buttonPressed();

        controller.displayCurrentAllocation();

        floors[8].buttonPressed();

        floors[1].buttonPressed();

        controller.displayCurrentAllocation();



    }
}
