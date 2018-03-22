package com.github.javadojo;

public class MovingParser {
    public static void parse(String movement, MarsRover marsRover){
        for (int i = 0; i<movement.length();i++){
            switch (movement.charAt(i)){
                case 's' : {
                    marsRover.moveForward();
                    break;
                }
                case 'l' : {
                    marsRover.turnLeft();
                    break;
                }
                case 'r' :{
                    marsRover.turnRight();
                    break;
                }
                case 'S' :{
                    marsRover.addSamplePositionToPath();
                    break;
                }
            }
        }
    }
}
