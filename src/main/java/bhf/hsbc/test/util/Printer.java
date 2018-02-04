package bhf.hsbc.test.util;

import bhf.hsbc.test.entity.Car;
import bhf.hsbc.test.entity.Park;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Printer {
    public static void ShowParkAndCar(Park park, Car car){
        String[] map = park.getMap().clone();
        int carPositionX = car.getPositionX();
        int carPositionY = car.getPositionY();
        String carOrientation = car.getOrientation();
        int heightIndex = 2*(park.getHeight()-carPositionY)-1;
        StringBuffer carIcon = new StringBuffer("|");
        for(int i=0 ;i<park.getWidth();i++){
            if(i==carPositionX)
                carIcon.append(" "+carOrientation+" |");
            else
                carIcon.append("    |");
        }
        map[heightIndex]=carIcon.toString();
        Arrays.asList(map).forEach(x-> System.out.println(x));
    }
}
