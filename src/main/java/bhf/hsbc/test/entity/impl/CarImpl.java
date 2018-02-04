package bhf.hsbc.test.entity.impl;

import bhf.hsbc.test.entity.Car;
import bhf.hsbc.test.entity.Park;
import bhf.hsbc.test.exception.ParkOutboundException;
import bhf.hsbc.test.util.Printer;

public class CarImpl implements Car {
    public static final String COMMAND_TURN = "TURN";
    public static final String COMMAND_FORWARD= "FORWARD";
    private int positionX;
    private int positionY;
    private int orientation;
    private Park park;

    public CarImpl() {
        this.positionX = 0;
        this.positionY = 0;
        this.orientation = Orientation.WEST;
    }

    public CarImpl(Park park) {
        this.positionX = 0;
        this.positionY = 0;
        this.orientation = Orientation.NORTH;
        this.park = park;
        Printer.ShowParkAndCar(this.park,this);
    }

    public void move(String command) throws ParkOutboundException {
        switch (command){
            case COMMAND_TURN :
                turn();
                break;
            case COMMAND_FORWARD :
                forward();
                break;
        }
        Printer.ShowParkAndCar(this.park,this);
    }

    protected void turn(){
        this.orientation = (this.orientation+1)%4;
    }

    protected void forward() throws ParkOutboundException{
        int newPositionX = this.positionX;
        int newPositionY = this.getPositionY();
        switch (this.orientation){
            case Orientation.NORTH: newPositionY++; break;
            case Orientation.EAST: newPositionX++; break;
            case Orientation.SOUTH: newPositionY--; break;
            case Orientation.WEST: newPositionX--; break;
        }
        if (positionCheck(newPositionX,newPositionY)){
            this.positionX = newPositionX;
            this.positionY = newPositionY;
        }else{
            throw new ParkOutboundException("outside the car park boundaries!");
        }
    }

    protected boolean positionCheck(int x, int y){
        return ( x>=0 && y>=0) && ( x<park.getWidth() && y<park.getHeight());
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public String getOrientation() {
        return Orientation.ORIENTATION_ICON[this.orientation];
    }

}
