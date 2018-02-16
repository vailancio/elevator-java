package com.vailancio;

public class Floor {
    public int number;
    Floor(int number){
        this.number = number;
    }
    public void buttonPressed(){
        ElevatorController controller = ElevatorController.getInstance();
        controller.allocateElevator(this);
    }
}
