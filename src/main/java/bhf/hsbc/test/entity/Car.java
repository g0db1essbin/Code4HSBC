package bhf.hsbc.test.entity;

import bhf.hsbc.test.exception.ParkOutboundException;

public interface Car {
    void move(String command) throws ParkOutboundException;
    int getPositionX();
    int getPositionY();
    String getOrientation();
}
