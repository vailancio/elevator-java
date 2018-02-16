package com.vailancio;
import java.util.*;
public class ElevatorController {
    private static ElevatorController instance=null;
    private Elevator elevators[];
    private Floor floors[];

    HashMap<Elevator, Floor> allocationTable=new HashMap<Elevator, Floor>();

    private ElevatorController(){

    }


    public static ElevatorController getInstance()
    {
        if (instance == null)
        {
            instance = new ElevatorController();
        }
        return instance;
    }


    public void config(Elevator elevators[],Floor floors[]){
        this.elevators = elevators;
        this.floors = floors;
    }


    public void allocateElevator(Floor f) {

        int rand =  ElevatorController.randInt(0,this.elevators.length - 1);
        Elevator currentClosestElevator = this.elevators[rand];
        int currentProximatyScore;
        int previousProximatyScore = 10000;

        for (int i=0; i< this.elevators.length; i++){

            currentProximatyScore = this.getProximityScore(this.elevators[i], f);

            if(currentProximatyScore < previousProximatyScore){
                currentClosestElevator = this.elevators[i];
            }else{
                if(i != 0) {
                    currentClosestElevator = this.elevators[i - 1];
                }
            }

        }

        this.setFloor(currentClosestElevator, f);
    }


    public void setFloor(Elevator e, Floor f){
        allocationTable.put(e,f);
    }

    public void resetToGround(){
        for(int i=0; i < elevators.length; i++) {
            this.setFloor(elevators[i], this.floors[0]);
        }
    }

    public void displayCurrentAllocation(){

        System.out.println("------------------------");

        for(int i=0; i < this.elevators.length; i++) {
            System.out.print("Elevator: "+this.elevators[i].number);

            Floor allocatedFloor = this.allocationTable.get(this.elevators[i]);
            if(allocatedFloor != null){
                System.out.println(" Floor: "+allocatedFloor.number);
            }

        }

        System.out.println("------------------------");
    }

    private static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int getProximityScore(Elevator e, Floor f){
        int currentFloorNumber  = this.allocationTable.get(e).number;
        return Math.abs(currentFloorNumber - f.number);
    }

}
