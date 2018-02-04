package bhf.hsbc.test.entity.impl;

import bhf.hsbc.test.entity.Park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkImpl implements Park {
    private int width;
    private int height;
    private String[] map;

    public static void main(String[] args) {
        Park park = new ParkImpl(10,5);
    }

    public ParkImpl(int width, int height) {
        this.width = width;
        this.height = height;

        //Template Gen
        StringBuffer bound = new StringBuffer("+");
        StringBuffer content = new StringBuffer("|");
        for(int i =0 ;i<width; i++){
            bound.append("----+");
            content.append("    |");
        }
        //Map Gen
        String[] map = new String[2*height+1];
        map[0] = bound.toString();
        for(int i=1; i<=height; i++){
            map[2*i-1] = content.toString();
            map[2*i]=bound.toString();
        }
        this.map=map;
//        Arrays.asList(map).forEach(n -> System.out.println(n));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public String[] getMap() {
        return this.map;
    }
}
