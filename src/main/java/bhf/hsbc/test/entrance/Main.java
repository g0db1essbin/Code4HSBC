package bhf.hsbc.test.entrance;

import bhf.hsbc.test.entity.Car;
import bhf.hsbc.test.entity.Park;
import bhf.hsbc.test.entity.impl.CarImpl;
import bhf.hsbc.test.entity.impl.ParkImpl;
import bhf.hsbc.test.exception.ParkOutboundException;

import java.util.Scanner;

public class Main {
    public static final String[] COMMAND = {"FORWARD","TURN"};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Please input the [Width] of park:");
        int parkWidth = 5;
        while((parkWidth=sc.nextInt())>=20){
            System.out.println("[Width] of park should be less than 20");
            System.out.print("Please input the [Width] of park:");
        }
        System.out.print("Please input the [Height] of park:");
        int parkHeight = sc.nextInt();
        Park park = new ParkImpl(parkWidth,parkHeight);
        Car car = new CarImpl(park);
        int command = 0;
        while(true){
            System.out.println("Please input command:");
            System.out.println("[1] : Move forward");
            System.out.println("[2] : Turn clockwise");
            System.out.println("[3] : Exit");
            command = sc.nextInt();
            switch (command){
                case 1:
                    try {
                        car.move("FORWARD");
                    } catch (ParkOutboundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        car.move("TURN");
                    } catch (ParkOutboundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                 default:
                     System.err.println("Wrong command!");
                     break;
            }
        }
    }
}
