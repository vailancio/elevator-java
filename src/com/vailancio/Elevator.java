package com.vailancio;

public class Elevator {
    public static final int maxLoad = 250;
    public float currentLoad;
    public int number;

    Elevator(int number){
        this.currentLoad = 0;
        this.number = number;
    }

    public void setLoad(float load){
        this.currentLoad = load;
    }
}
